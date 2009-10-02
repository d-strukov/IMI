package lt.ktu.dstrukov.schoolscheduler.model;

import lt.ktu.dstrukov.scheduler.model.Resource;
import lt.ktu.dstrukov.scheduler.model.Task;

public class Job extends Resource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 729247195478742339L;
	private SchoolTask task;
	private Student student;
	
	public Job(Student stud, SchoolTask task, String level) {
		this.task = task; 
		student = stud;
		stud.addJob(this);
		
	}

	@Override
	public boolean isCompatibleWithResource(Resource res) {
		if(res.getOwner() instanceof Student){
			Student s = (Student)res.getOwner();
			return true; //TODO: change that
		} else if (res.getOwner() instanceof Teacher) {
			Teacher t = (Teacher)res.getOwner();
			return t.canServeStudnetGroup(task, student.getGroup());// student.getGroup().getGroupDescription();
		} else if (res.getOwner() instanceof Room) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isCompatibleWithTask(Task task) {
		
		return this.task == task;
	}

}
