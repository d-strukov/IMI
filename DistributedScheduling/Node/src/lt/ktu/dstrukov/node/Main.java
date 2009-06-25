package lt.ktu.dstrukov.node;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import lt.ktu.dstrukov.node.semantics.Node;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Node svc =new Node();
			Registry reg = LocateRegistry.getRegistry(1099);
			reg.rebind("NodeSvc", svc);
			System.out.println("Test Node Binded");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
