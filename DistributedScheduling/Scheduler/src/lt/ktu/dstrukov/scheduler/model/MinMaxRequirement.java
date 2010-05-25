package lt.ktu.dstrukov.scheduler.model;


/**
 * @author  Denis
 */
public class MinMaxRequirement {

	/**
	 * @uml.property  name="min"
	 */
	private int min;
	/**
	 * @uml.property  name="max"
	 */
	private int max;
	
	/**
	 * @return
	 * @uml.property  name="min"
	 */
	public int getMin() {
		return min;
	}


	/**
	 * @return
	 * @uml.property  name="max"
	 */
	public int getMax() {
		return max;
	}



	
	
	public MinMaxRequirement(int minimum, int maximum) {
		min=minimum;
		max = maximum;
	}
	
	
	
	
	
}
