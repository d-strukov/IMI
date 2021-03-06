package lt.ktu.dstrukov.node.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface INode extends Remote {

	public void startProcess() throws RemoteException;

	public boolean isBusy() throws RemoteException;

	public void assignId(int id) throws RemoteException;

	public int getId() throws RemoteException;

	public void ping() throws RemoteException;

	public Object getBest() throws RemoteException;

}
