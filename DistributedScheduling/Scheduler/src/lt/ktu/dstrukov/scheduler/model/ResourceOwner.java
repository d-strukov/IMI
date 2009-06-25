package lt.ktu.dstrukov.scheduler.model;

import lt.ktu.dstrukov.scheduler.model.misc.IDGenerator;

public class ResourceOwner extends AbstractBase {




	/**
	 * 
	 */
	private static final long serialVersionUID = -6178263289529968750L;

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
		
		return "ResourceOwner["+getId()+"]";
	}

}
