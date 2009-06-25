package lt.ktu.dstrukov.scheduler.model;

import lt.ktu.dstrukov.scheduler.model.misc.IDGenerator;

public class Issuer extends AbstractBase {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5583692390704266561L;

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
		
		return "Issuer["+getId()+"]";
	}

}
