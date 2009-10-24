package lt.ktu.dstrukov.scheduler.exception;


import lt.ktu.dstrukov.scheduler.model.Task;
import lt.ktu.dstrukov.scheduler.model.collections.ResourceCollection;

public class InsufficientResourceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5107634011643791975L;
	private ResourceCollection collection;
	private Task task;
	private String message = "Insufitient resources";
	
	
	public InsufficientResourceException(ResourceCollection collection, Task task) {
		this.task =task;
		this.collection = collection;
		
	}
	
	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String msg){
		message=msg;
	}

	public ResourceCollection getCollection() {
		return collection;
	}


	public Task getTask() {
		return task;
	}

}
