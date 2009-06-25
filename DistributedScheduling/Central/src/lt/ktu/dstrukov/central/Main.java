package lt.ktu.dstrukov.central;


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import lt.ktu.dstrukov.central.semantics.Central;

public class Main {

	public static void main(String[] args) {
		try {
			Central svc =new Central();
			Registry reg = LocateRegistry.getRegistry(1099);
			reg.rebind("CentralSvc", svc);
			System.out.println("Central Binded");
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

}
