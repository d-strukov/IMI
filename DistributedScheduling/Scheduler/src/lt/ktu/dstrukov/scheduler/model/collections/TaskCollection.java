package lt.ktu.dstrukov.scheduler.model.collections;


import lt.ktu.dstrukov.scheduler.model.Task;
import lt.ktu.dstrukov.scheduler.model.misc.IDGenerator;

/**
 * @author  Denis
 */
public class TaskCollection extends BaseCollection<Task> {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -7868697913666615011L;

	private static int counter=-1;
	
	/**
	 * @uml.property  name="idGenerator"
	 * @uml.associationEnd  
	 */
	private IDGenerator idGenerator ;

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
