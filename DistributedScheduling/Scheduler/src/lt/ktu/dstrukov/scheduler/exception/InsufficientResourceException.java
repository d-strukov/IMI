package lt.ktu.dstrukov.scheduler.exception;


import lt.ktu.dstrukov.scheduler.model.Task;
import lt.ktu.dstrukov.scheduler.model.collections.ResourceCollection;

/**
 * @author  Denis
 */
public class InsufficientResourceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5107634011643791975L;
	/**
	 * @uml.property  name="collection"
	 * @uml.associationEnd  
	 */
	private ResourceCollection collection;
	/**
	 * @uml.property  name="task"
	 * @uml.associationEnd  
	 */
	private Task task;
	/**
	 * @uml.property  name="message"
	 */
	private String message = "Insufitient resources";
	
	
	public InsufficientResourceException(ResourceCollection collection, Task task) {
		this.task =task;
		this.collection = collection;
		
	}
	
	/**
	 * @return
	 * @uml.property  name="message"
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/**
	 * @param msg
	 * @uml.property  name="message"
	 */
	public void setMessage(String msg){
		message=msg;
	}

	/**
	 * @return
	 * @uml.property  name="collection"
	 */
	public ResourceCollection getCollection() {
		return collection;
	}


	/**
	 * @return
	 * @uml.property  name="task"
	 */
	public Task getTask() {
		return task;
	}

}
