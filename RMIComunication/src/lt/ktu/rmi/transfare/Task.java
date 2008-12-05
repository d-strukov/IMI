package lt.ktu.rmi.transfare;

public class Task implements ResultContainer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2747427600134287491L;

	public void run() {
		for (int i = 0; i < 1000; i++)
			System.out.println(i);
	}

	public Object getTask() {
		// TODO Auto-generated method stub
		return null;
	}

}
