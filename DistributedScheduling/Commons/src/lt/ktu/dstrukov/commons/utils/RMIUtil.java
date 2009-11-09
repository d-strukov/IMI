package lt.ktu.dstrukov.commons.utils;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIUtil {

	private static Registry reg;

	public static Registry getRegistry(int port) throws RemoteException {

		if (reg != null)
			return reg;

		try {
			reg = LocateRegistry.getRegistry(port);

			System.out.println("Searching for registry @ port " + port);
			try {
				reg.list();
			} catch (Exception ex) {
				System.out.println("Failed. Resason " + ex.getMessage()
						+ ". Creating registry @ port " + port);
				try {
					reg = LocateRegistry.createRegistry(port);
				} catch (RemoteException e) {
					throw e;
				}

				try {
					reg.list();
				} catch (RemoteException e) {
					System.out.println("Failed. Resason " + e.getMessage());
					return null;
				}
			}

			return reg;
		} catch (RemoteException e) {
			System.out.println("Fatal Error: " + e.getMessage());
			throw e;
		}
	}

}
