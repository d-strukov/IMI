package lt.ktu.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import lt.ktu.rmi.transfare.RemoteTask;

public interface Executor extends Remote {

	public Object executeRemoteTask(RemoteTask task) throws RemoteException;

}
