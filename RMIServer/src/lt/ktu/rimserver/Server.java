package lt.ktu.rimserver;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import lt.ktu.rimserver.model.RemoteTask;

public class Server extends UnicastRemoteObject implements Executor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2141103463085808917L;

	protected Server() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public Object executeRemoteTask(Runnable task) throws RemoteException {
		
		
		return null;
	}
	
	public static void main(String[] args) {
		
		try {
			Server svc = new Server();
			
			Registry reg = LocateRegistry.createRegistry(1099);
			reg.rebind("ServerSvc", svc);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
		
	}

	public Object executeRemoteTask(RemoteTask task) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
