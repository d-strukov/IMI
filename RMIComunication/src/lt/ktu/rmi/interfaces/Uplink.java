package lt.ktu.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Uplink extends Remote {

	public void resultReady(Runnable res) throws RemoteException;

}
