package lt.ktu.rmi.semantics;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Set;

import lt.ktu.rmi.interfaces.Executor;
import lt.ktu.rmi.transfare.RemoteTask;
import lt.ktu.rmi.transfare.ResultContainer;

public class Dispatcher {

	private static Set<RemoteTask> dispatchedTasks = new HashSet<RemoteTask>();
	private static int idGenerator = 0;

	public static void dispatchTask(ResultContainer task) {
		
		RemoteTask t = new RemoteTask(task, idGenerator);
		idGenerator++;
		dispatchedTasks.add(t);

		try {
			Executor lnk = (Executor) Naming
					.lookup("rmi://localhost:1100/ServerSvc");

			lnk.executeRemoteTask(t);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
