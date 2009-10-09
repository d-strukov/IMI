package lt.ktu.dstrukov.schoolscheduler.model;

import lt.ktu.dstrukov.scheduler.model.Resource;
import lt.ktu.dstrukov.scheduler.model.Task;

public class Server extends Resource {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1528902955576255064L;
	
	private Teacher teacher;
	private SchoolTask task;
	
	
	public Server(SchoolTask task, Teacher owner) {
		this.task = task;
		teacher =owner;
		setOwner(owner);
		owner.addServingResource(this);
	}
	
	public SchoolTask getTask(){
		return task;
	}

	@Override
	public boolean isCompatibleWithResource(Resource res) {
		
		if(res.getOwner() instanceof Student){
			Student s = (Student)res.getOwner();
			if(!teacher.canServeStudnetGroup(task, s.getGroup()))return false;
			return true; 
		} else if (res.getOwner() instanceof Teacher) {
			Teacher t = (Teacher)res.getOwner();
			//if(!student.isCompatibleWithTeacher(task, t))return false;
			return false; 
		} else if (res.getOwner() instanceof Room) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isCompatibleWithTask(Task task) {
		
		return this.task ==task;
	}

}
