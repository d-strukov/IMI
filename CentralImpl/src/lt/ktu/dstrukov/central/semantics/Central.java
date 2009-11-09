package lt.ktu.dstrukov.central.semantics;

import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lt.ktu.dstrukov.central.interfaces.ICentral;
import lt.ktu.dstrukov.commons.OptimizationParameters;
import lt.ktu.dstrukov.commons.Result;
import lt.ktu.dstrukov.commons.utils.RMIUtil;
import lt.ktu.dstrukov.node.interfaces.INode;
import lt.ktu.dstrukov.schoolscheduler.model.SchoolData;
import lt.ktu.dstrukov.schoolscheduler.model.io.DataParser;

public class Central extends UnicastRemoteObject implements ICentral {

	private boolean started = false;
	private Map<Integer, List<Result>> results = new HashMap<Integer, List<Result>>();
	private int startedCount = 0;
	private List<INode> registeredNodes = new ArrayList<INode>();
	private SchoolData data = new SchoolData();
	private static String name = "CentralSvc";
	private static int port = 1100;
	private Thread broadcaster;
	private Result firstResult;
	private static boolean broadcasting = false;
	private List<Integer> mainResults = new ArrayList<Integer>();
	private int currentBest = -1;
	private static volatile int nodeIds = 0;

	/**
	 * 
	 */
	private static final long serialVersionUID = -4873817237062835205L;

	private static String pathToData;

	public Central() throws RemoteException {
		super();

		initializeData(new File("SchoolData1.xml"));
		bindCentral();
		broadcastLocation();

	}

	private void bindCentral() {
		Registry reg;
		try {
			reg = RMIUtil.getRegistry(port);

			reg.bind(name, this);
			System.out.println("Central Bound");

		} catch (RemoteException e) {
			e.printStackTrace();
			port++;
			if (port > 1101)
				return;
			bindCentral();

		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}

	private synchronized void broadcastLocation() {

		if (Central.broadcasting)
			return;
		Central.broadcasting = true;
		broadcaster = new Thread(new Runnable() {

			@Override
			public void run() {

				while (Central.broadcasting) {
					try {

						DatagramSocket socket = new DatagramSocket();

						InetAddress address = InetAddress
								.getByName("230.0.0.1");

						int broadcastPort = 4446;
						byte[] buf = (":" + Central.port + "/" + Central.name)
								.getBytes();
						DatagramPacket packet = new DatagramPacket(buf,
								buf.length, address, broadcastPort);

						socket.send(packet);
						System.out.println("Bradcasting location");
						try {
							Thread.sleep(10000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					} catch (UnknownHostException e) {

						e.printStackTrace();
					} catch (SocketException e) {

						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});

		broadcaster.setDaemon(true);
		broadcaster.start();

	}

	public void initializeData(File f) {
		new DataParser(data, f);
	}

	@Override
	public void addResult(int nodeId, Result res) throws RemoteException {

		synchronized (this) {

			if (firstResult == null) {
				firstResult = res;
				currentBest = Integer.parseInt(res.getResultString());
				mainResults.add(currentBest);
			}

			if (currentBest > Integer.parseInt(res.getResultString())) {
				currentBest = Integer.parseInt(res.getResultString());
				mainResults.add(currentBest);
			}

			List<Result> lst;
			if (results.containsKey(nodeId))
				lst = results.get(nodeId);
			else
				lst = new ArrayList<Result>();
			lst.add(res);
			results.put(nodeId, lst);
		}

	}

	@Override
	public Object getData() throws RemoteException {

		return data;
	}

	@Override
	public String getPathToData() throws RemoteException {
		return pathToData;
	}

	@Override
	public List<Result> getResults(int nodeId) throws RemoteException {
		synchronized (this) {
			if (results.containsKey(nodeId))
				return results.get(nodeId);
			else
				return new ArrayList<Result>();
		}

	}

	public Map<Integer, List<Integer>> getResultsAsInts() {
		Map<Integer, List<Integer>> ret = new HashMap<Integer, List<Integer>>();
		for (int key : results.keySet()) {
			List<Integer> lst = new ArrayList<Integer>();
			for (Result r : results.get(key))
				lst.add(Integer.parseInt(r.getResultString()));
			ret.put(key, lst);
		}
		return ret;
	}

	@Override
	public void setData(Object data) throws RemoteException {

	}

	@Override
	public void setPathToData(String path) throws RemoteException {
		pathToData = path;

	}

	@Override
	public OptimizationParameters getOptimizationParameters()
			throws RemoteException {

		return new OptimizationParameters();
	}

	@Override
	public void setOptimizationParameters(OptimizationParameters params)
			throws RemoteException {

	}

	@Override
	public boolean isBusy() throws RemoteException {
		return started;
	}

	@Override
	public void setStarted() throws RemoteException {
		startedCount++;
		started = true;

	}

	@Override
	public void registerNode(String nodeAddress) throws RemoteException {
		try {
			System.out.println("Looking up " + nodeAddress);
			INode node = (INode) Naming.lookup(nodeAddress);
			registeredNodes.add(node);
			node.assignId(++nodeIds);
			System.out.println(nodeAddress);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void startAllNodes() throws RemoteException {
		clearBrokenNodes();
		for (INode node : registeredNodes) {
			node.startProcess();
		}

	}

	public int getNodeCount() {
		return registeredNodes.size();
	}

	public void clearBrokenNodes() {
		List<INode> broken = new ArrayList<INode>();
		for (INode node : registeredNodes) {
			try {
				node.ping();
			} catch (RemoteException e) {
				broken.add(node);
			}
		}

		for (INode node : broken)
			registeredNodes.remove(node);

	}

	@Override
	protected void finalize() throws Throwable {
		broadcaster.interrupt();
		super.finalize();
	}

	public int getFirstResult() {
		int ret = -1;
		try {
			if (firstResult != null)
				ret = Integer.parseInt(firstResult.getResultString());
		} catch (Exception ex) {

		}
		return ret;
	}

	public List<Integer> getMainResults() {
		return mainResults;
	}

}
