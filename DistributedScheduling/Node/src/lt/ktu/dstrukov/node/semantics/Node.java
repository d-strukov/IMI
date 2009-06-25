package lt.ktu.dstrukov.node.semantics;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import lt.ktu.dstrukov.central.interfaces.ICentral;
import lt.ktu.dstrukov.commons.Result;
import lt.ktu.dstrukov.node.interfaces.INode;

public class Node extends UnicastRemoteObject implements INode {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6144504104518364063L;
	
	
	public Node() throws RemoteException{
		super();
		
	}

	@Override
	public void startProcess(ICentral central) throws RemoteException {
		central.addResult(new Result("Test"));
		
	}

}
