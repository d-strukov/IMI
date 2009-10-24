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
		setOwner(stud);
		stud.addJob(this);
		
	}
	
	private Student getStudent(){
		return (Student)getOwner();
	}

	@Override
	public boolean isCompatibleWithResource(Resource res) {
		if(res.getOwner() instanceof Student){
			Student s = (Student)res.getOwner();
			if(!getStudent().isCompatibleWithStudent(task, s))return false;
			return true; 
		} else if (res.getOwner() instanceof Teacher) {
			Teacher t = (Teacher)res.getOwner();
			if(!getStudent().isCompatibleWithTeacher(task, t))return false;
			return true; 
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
