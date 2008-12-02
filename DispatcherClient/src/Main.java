import lt.ktu.rmi.semantics.Dispatcher;
import lt.ktu.rmi.semantics.ResultContainer;

public class Main {

	public static void main(String[] args) {
		Dispatcher.dispatchTask(new ResultContainer() {

			/**
			 * 
			 */
			private static final long serialVersionUID = -8518293475176686602L;

			public Object getResults() {

				return null;
			}

			public void run() {
				for (int i = 0; i < 10000; i++) {

				}

			}
		});
	}

}
