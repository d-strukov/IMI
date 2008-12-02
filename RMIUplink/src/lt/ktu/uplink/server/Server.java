package lt.ktu.uplink.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import lt.ktu.rmi.interfaces.Uplink;
import lt.ktu.rmi.transfare.RemoteTask;

public class Server extends UnicastRemoteObject implements Uplink {

	protected Server() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6614598806778019742L;

	public static void main(String[] args) {

		try {
			Server svc = new Server();

			Registry reg = LocateRegistry.createRegistry(1099);
			reg.rebind("UplinkSvc", svc);
			System.out.println("Uplink Binded");
		} catch (RemoteException e) {

			e.printStackTrace();
		}
	}

	public void resultReady(RemoteTask res) {

	}

}
