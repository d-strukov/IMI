package lt.ktu.dstrukov.scheduler.exception;


import lt.ktu.dstrukov.scheduler.model.Task;
import lt.ktu.dstrukov.scheduler.model.collections.ResourceCollection;

public class InsufficientResourceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5107634011643791975L;
	private static String compileMessage(ResourceCollection collection, Task task){
		
		return ""+collection + " has no compatible elements with task  " + task;
	}
	
	public InsufficientResourceException(ResourceCollection collection, Task task) {
		super(compileMessage(collection, task));
	}

}
