package lt.ktu.dstrukov.scheduler.model.collections;


import lt.ktu.dstrukov.scheduler.model.ResourceOwner;
import lt.ktu.dstrukov.scheduler.model.misc.IDGenerator;

/**
 * @author  Denis
 */
public class ResourceOwnerCollection extends BaseCollection<ResourceOwner> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7651123455649683075L;
	
	private static int counter=-1;
	
	/**
	 * @uml.property  name="idGenerator"
	 * @uml.associationEnd  
	 */
	private IDGenerator idGenerator;

	@Override
	protected IDGenerator getIDGenerator() {
		if(idGenerator==null){
			idGenerator =  new IDGenerator(){

				@Override
				public int next() {
					counter++;
					return counter;
				}
				
			};
		}
		
		return idGenerator;
	}
	

}
