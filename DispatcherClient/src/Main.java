import java.rmi.RMISecurityManager;

import lt.ktu.rmi.semantics.Dispatcher;
import lt.ktu.rmi.transfare.Results;


public class Main {

	public static void main(String[] args) {
		Results c = new Results();
//		RMISecurityManager sec = new RMISecurityManager();
//		System.setSecurityManager(sec);
		Dispatcher.dispatchTask(c);
	}

}
