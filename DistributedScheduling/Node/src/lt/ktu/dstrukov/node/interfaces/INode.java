package lt.ktu.dstrukov.node.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import lt.ktu.dstrukov.central.interfaces.ICentral;

public interface INode extends Remote {
	
	public void startProcess(ICentral central) throws RemoteException;

}
