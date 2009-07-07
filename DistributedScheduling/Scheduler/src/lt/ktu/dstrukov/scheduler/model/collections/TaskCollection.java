package lt.ktu.dstrukov.scheduler.model.collections;


import lt.ktu.dstrukov.scheduler.model.Task;
import lt.ktu.dstrukov.scheduler.model.misc.IDGenerator;

public class TaskCollection extends BaseCollection<Task> {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -7868697913666615011L;

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
