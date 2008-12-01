package lt.ktu.rimserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

import lt.ktu.rimserver.model.RemoteTask;

public interface Executor extends Remote {
	
	public Object executeRemoteTask(RemoteTask task) throws RemoteException;

}
