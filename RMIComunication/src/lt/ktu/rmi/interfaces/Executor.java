package lt.ktu.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Executor extends Remote {

	public Object executeRemoteTask(Runnable task) throws RemoteException;

}
