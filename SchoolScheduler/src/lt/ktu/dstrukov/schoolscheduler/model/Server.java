package lt.ktu.dstrukov.schoolscheduler.model;

import lt.ktu.dstrukov.scheduler.model.Resource;
import lt.ktu.dstrukov.scheduler.model.Task;

public class Server extends Resource {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1528902955576255064L;
	
	private SchoolTask task;
	
	
	public Server(SchoolTask task, Teacher owner) {
		this.task = task;
		setOwner(owner);
		owner.addServingResource(this);
	}
	
	public SchoolTask getTask(){
		return task;
	}

	@Override
	public boolean isCompatibleWithResource(Resource res) {
		
		return false;
	}

	@Override
	public boolean isCompatibleWithTask(Task task) {
		
		return false;
	}

}
