import lt.ktu.rmi.semantics.Dispatcher;
import lt.ktu.rmi.transfare.Task;

public class Main {

	public static void main(String[] args) {
		Task c = new Task();
		// RMISecurityManager sec = new RMISecurityManager();
		// System.setSecurityManager(sec);
		Dispatcher.dispatchTask(c);
	}

}
