package lt.ktu.dstrukov.scheduler.model.collections;

import lt.ktu.dstrukov.scheduler.model.Resource;
import lt.ktu.dstrukov.scheduler.model.misc.IDGenerator;

/**
 * @author  Denis
 */
public class ResourceCollection extends BaseCollection<Resource> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7651224156849683075L;
	
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
