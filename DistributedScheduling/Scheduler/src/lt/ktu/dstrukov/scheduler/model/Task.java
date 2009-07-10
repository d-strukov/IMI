package lt.ktu.dstrukov.scheduler.model;

import lt.ktu.dstrukov.scheduler.model.collections.BaseCollection;
import lt.ktu.dstrukov.scheduler.model.collections.CollectionItem;
import lt.ktu.dstrukov.scheduler.model.misc.IDGenerator;

public class Task extends AbstractBase implements CollectionItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4895742755603521549L;
	
	private static int counter=-1;
	
	private IDGenerator idGenerator ;
	
	
	@Override
	protected IDGenerator getIDGenerator() {
		if(idGenerator==null){
			idGenerator = new IDGenerator(){

				@Override
				public int next() {
					counter++;
					return counter;
				}
				
			};
		}
		return idGenerator;
	}
	
	
	@Override
	public String toString() {
		
		return "Task["+getId()+"]";
	}


	@Override
	public void setCollection(BaseCollection<?> collection) {
		
		
	}

}
