package lt.ktu.dstrukov.scheduler.model;

import lt.ktu.dstrukov.scheduler.model.misc.IDGenerator;

public class Execution extends AbstractBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4210880125976709984L;

	private static int count = -1;
	private IDGenerator idGenerator;
	
	
	
	public static Execution createExecution(Data data, Task task, TimeFrame frame){
		Execution execution = new Execution();
		
		
		
		return execution;
		
	}
	
	
	@Override
	protected IDGenerator getIDGenerator() {
		if (idGenerator == null) {
			idGenerator = new IDGenerator() {

				@Override
				public int next() {
					count++;
					return count;
				}
			};
		}
		return idGenerator;
	}

}
