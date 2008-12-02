package lt.ktu.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import lt.ktu.rmi.transfare.RemoteTask;

public interface Uplink extends Remote {

	public void resultReady(RemoteTask res) throws RemoteException;

}
