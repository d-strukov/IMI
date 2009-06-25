package lt.ktu.dstrukov.scheduler.model;

import lt.ktu.dstrukov.scheduler.model.misc.IDGenerator;

public class Task extends AbstractBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4895742755603521549L;
	
	private static int counter=-1;
	
	private IDGenerator idGenerator = new IDGenerator(){

		@Override
		public int next() {
			counter++;
			return counter;
		}
		
	};
	
	
	@Override
	protected IDGenerator getIDGenerator() {
		
		return idGenerator;
	}
	
	
	@Override
	public String toString() {
		
		return "Task["+getId()+"]";
	}

}
