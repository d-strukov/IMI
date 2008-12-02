package lt.ktu.rimserver;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import lt.ktu.rmi.interfaces.Executor;
import lt.ktu.rmi.interfaces.Uplink;
import lt.ktu.rmi.transfare.RemoteTask;
import lt.ktu.rmi.transfare.TaskEndListener;

public class Server extends UnicastRemoteObject implements Executor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2141103463085808917L;

	protected Server() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public Object executeRemoteTask(final Runnable task) throws RemoteException {

		Thread th = new Thread(new Runnable(){

			@Override
			public void run() {
				task.run();
				onTaskFinished(task);
			}});
		th.start();
		return null;
	}

	public static void main(String[] args) {

		try {
			Server svc = new Server();
			
			Registry reg = LocateRegistry.createRegistry(1100);
			reg.rebind("ServerSvc", svc);
			System.out.println("Service Binded");
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}


	protected void onTaskFinished(Runnable task) {
		try {
			
			
			Uplink lnk = (Uplink) Naming.lookup("rmi://localhost:1099/UplinkSvc");
			lnk.resultReady(task);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
