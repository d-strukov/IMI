package lt.ktu.dstrukov.schoolscheduler.model;

import lt.ktu.dstrukov.scheduler.model.Resource;
import lt.ktu.dstrukov.scheduler.model.Task;

public class Job extends Resource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 729247195478742339L;
	private SchoolTask task;
	
	public Job(Student stud, SchoolTask task, String level) {
		this.task = task; 
		stud.addJob(this);
	}

	@Override
	public boolean isCompatibleWithResource(Resource res) {
		
		return false;
	}

	@Override
	public boolean isCompatibleWithTask(Task task) {
		
		return this.task == task;
	}

}
