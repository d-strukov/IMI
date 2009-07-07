package lt.ktu.dstrukov.schoolscheduler.model;

import java.util.ArrayList;
import java.util.List;

import lt.ktu.dstrukov.scheduler.model.ResourceOwner;

public class Student extends ResourceOwner {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5531926260294809834L;
	
	private StudentGroup group;
	private List<Job> jobs = new ArrayList<Job>();
	
	public boolean addJob(Job job){
		return jobs.add(job);
	}
	
	public Student(StudentGroup group) {
		this.group= group;
	}

	public StudentGroup getGroup() {
		return group;
	}
	

}
