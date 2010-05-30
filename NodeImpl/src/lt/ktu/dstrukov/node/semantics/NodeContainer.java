package lt.ktu.dstrukov.node.semantics;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import lt.ktu.dstrukov.central.interfaces.ICentral;
import lt.ktu.dstrukov.commons.Result;
import lt.ktu.dstrukov.commons.utils.RMIUtil;
import lt.ktu.dstrukov.node.listeners.NodeContainerListener;

public class NodeContainer {
	private List<Node> nodes = new ArrayList<Node>();
	private String address = "rmi://";
	private String hostname = "";
	private ICentral central;
	private int registryPort = 1099;
	private List<NodeContainerListener> listeners = new ArrayList<NodeContainerListener>();

	public void addNodeContainerListener(NodeContainerListener l) {
		listeners.add(l);
	}

	public boolean removeNodeContainerListener(NodeContainerListener l) {
		return listeners.remove(l);
	}

	public String getAddress() {
		return address;
	}

	public String getHostname() {
		return hostname;
	}

	public NodeContainer() {

		try {

			InetAddress addr = InetAddress.getLocalHost();
			byte[] ipAddr = addr.getAddress();
			hostname = addr.getHostName();
			String ip = ((int) ipAddr[0] & 0xFF) + "."
					+ ((int) ipAddr[1] & 0xFF) + "." + ((int) ipAddr[2] & 0xFF)
					+ "." + ((int) ipAddr[3] & 0xFF);
			address += ip;

			// raise the even
			for (NodeContainerListener l : listeners)
				l.onHostResolved(hostname, ip);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public void connectToCentral() {

		Thread th = new Thread(new Runnable() {

			@Override
			public void run() {
				try {

					MulticastSocket socket = new MulticastSocket(4446);
					socket.joinGroup(InetAddress.getByName("230.0.0.1"));

					byte[] buf = new byte[50];
					DatagramPacket packet = new DatagramPacket(buf, buf.length);
					System.out.println("Awaiting Central Broadcast packet");
					socket.receive(packet);
					System.out
							.println("Central Broadcast packet received from "
									+ packet.getAddress().toString());
					String address = "rmi:/" + packet.getAddress().toString();

					address += new String(buf).trim();
					central = (ICentral) Naming.lookup(address);

					// raise event
					for (NodeContainerListener l : listeners)
						l.onCentralBound();

					socket.close();

				} catch (MalformedURLException e1) {
					System.out.println("Bad URL ");
					e1.printStackTrace();
				} catch (RemoteException e1) {
					System.out.println("Fatal Error");
					e1.printStackTrace();
					e1.detail.printStackTrace();
				} catch (NotBoundException e1) {
					System.out.println("Not Bound");
					e1.printStackTrace();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		});

		th.setDaemon(true);
		th.run();

	}

	public void createNode() {
		try {

			Node node = new Node(this);
			central.registerNode(bindNode(node, 0));
			nodes.add(node);

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void reportToCentral(int nodeId, Result res) {
		try {
			central.addResult(nodeId, res);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	private String bindNode(Node svc, int index) throws RemoteException {

		String serviceName = "NodeSvc" + index;
		try {
			System.out.println("Binding to: " + getAddress() + serviceName);
			RMIUtil.getRegistry(registryPort).bind(serviceName, svc);

			System.out.println("Node Bound at: " + getAddress() + ":"
					+ registryPort + "/" + serviceName);
			return getAddress() + ":" + registryPort + "/" + serviceName;
		} catch (AccessException e) {
			throw e;
		} catch (RemoteException e) {
			registryPort++;
			return bindNode(svc, index);
		} catch (AlreadyBoundException e) {
			index = index + 1;
			if (index >= 20) {
				System.out.println("Limit Reached");
				return null;
			}
			// System.out.println("Failed to Bind: " + serviceName);

			return bindNode(svc, index++);
		}

	}

	public ICentral getCentral() {
		return central;
	}

}
