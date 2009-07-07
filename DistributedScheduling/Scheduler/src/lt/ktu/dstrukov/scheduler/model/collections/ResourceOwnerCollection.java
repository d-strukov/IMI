package lt.ktu.dstrukov.scheduler.model.collections;


import lt.ktu.dstrukov.scheduler.model.ResourceOwner;
import lt.ktu.dstrukov.scheduler.model.misc.IDGenerator;

public class ResourceOwnerCollection extends BaseCollection<ResourceOwner> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7651123455649683075L;
	
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
	

}
