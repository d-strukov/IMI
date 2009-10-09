package lt.ktu.dstrukov.schoolscheduler.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lt.ktu.dstrukov.scheduler.model.ResourceOwner;

public class Student extends ResourceOwner {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5531926260294809834L;
	
	private StudentGroup group;
	private List<Job> jobs = new ArrayList<Job>();
	private Map<SchoolTask,List<Student>> taskGroup = new HashMap<SchoolTask, List<Student>>();
	private Map<SchoolTask, Teacher> taskTeacher = new HashMap<SchoolTask, Teacher>();
	
	public boolean addJob(Job job){
		return jobs.add(job);
	}
	
	public Student(StudentGroup group) {
		this.group= group;
	}

	public StudentGroup getGroup() {
		return group;
	}
	
	public boolean isCompatibleWithStudent(SchoolTask task, Student s){
		return taskGroup.get(task).contains(s);
	}
	
	public boolean isCompatibleWithTeacher(SchoolTask task, Teacher t){
		return taskTeacher.get(task).equals(t);
	}
	
	

}
