package lt.ktu.dstrukov.schoolscheduler.model;

import java.util.ArrayList;
import java.util.List;

import lt.ktu.dstrukov.scheduler.model.Resource;
import lt.ktu.dstrukov.scheduler.model.ResourceOwner;
import lt.ktu.dstrukov.scheduler.model.Task;

/**
 * @author  Denis
 */
public class Room extends ResourceOwner {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1266174997693200899L;
	private List<ResourceOwner> compatibleResourcesOwners = new ArrayList<ResourceOwner>();
	/**
	 * @uml.property  name="compatibleTasks"
	 */
	private List<Task> compatibleTasks = new ArrayList<Task>();
	
	public Room(String description) {
		this.setDescription(description);
	}
	
	/**
	 * @return
	 * @uml.property  name="compatibleTasks"
	 */
	public List<Task> getCompatibleTasks() {
		return compatibleTasks;
	}

	public List<ResourceOwner> getCompatibleResourceOwners() {
		return compatibleResourcesOwners;
	}
	
	public void addCompatibleTask(Task task){
		compatibleTasks.add(task);
	}
	
	public void addCompatibleResourceOwners(ResourceOwner res){
		compatibleResourcesOwners.add(res);
	}

}
