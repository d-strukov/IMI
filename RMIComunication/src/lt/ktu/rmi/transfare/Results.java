package lt.ktu.rmi.transfare;



public class Results implements ResultContainer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2747427600134287491L;

	@Override
	public Object getResults() {
		
		return null;
	}

	@Override
	public void run() {
		for(int i =0; i< 1000; i++)System.out.println(i);
	}

}
