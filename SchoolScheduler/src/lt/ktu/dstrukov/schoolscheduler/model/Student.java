package lt.ktu.dstrukov.schoolscheduler.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lt.ktu.dstrukov.scheduler.model.ResourceOwner;

/**
 * @author Denis
 */
public class Student extends ResourceOwner {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5531926260294809834L;

	/**
	 * @uml.property name="group"
	 * @uml.associationEnd
	 */
	private StudentGroup group;
	private List<Job> jobs = new ArrayList<Job>();
	private Map<SchoolTask, List<Student>> taskGroup = new HashMap<SchoolTask, List<Student>>();
	private Map<SchoolTask, Teacher> taskTeacher = new HashMap<SchoolTask, Teacher>();

	public boolean addJob(Job job) {
		return jobs.add(job);
	}

	public Student(StudentGroup group) {
		this.group = group;
	}

	/**
	 * @return
	 * @uml.property name="group"
	 */
	public StudentGroup getGroup() {
		return group;
	}

	private boolean isSameLavel(Student s) {
		return this.getGroup().getGroupLevel() == s.getGroup().getGroupLevel();
	}

	public boolean isCompatibleWithStudent(SchoolTask task, Student s) {

		// Students have to be same level
		if (!this.isSameLavel(s))
			return false;

		if (this.equals(s))
			return false;

		// student has to belong to same taskGroup if one exists
		if (taskGroup.containsKey(task))
			return taskGroup.get(task).contains(s);

		// in case all conditions met
		return true;
	}

	public boolean isCompatibleWithTeacher(SchoolTask task, Teacher t) {

		// Student has to stay with his teacher
		if (taskTeacher.containsKey(task))
			return taskTeacher.get(task).equals(t);

		// no violations detected
		return true;
	}

	/**
	 * @uml.property name="jobs"
	 * @uml.associationEnd multiplicity="(0 -1)"
	 *                     inverse="student:lt.ktu.dstrukov.schoolscheduler.model.Job"
	 */
	private Collection<Job> jobs1;

	/**
	 * Getter of the property <tt>jobs</tt>
	 * 
	 * @return Returns the jobs1.
	 * @uml.property name="jobs"
	 */
	public Collection<Job> getJobs() {
		return jobs1;
	}

	/**
	 * Setter of the property <tt>jobs</tt>
	 * 
	 * @param jobs
	 *            The jobs1 to set.
	 * @uml.property name="jobs"
	 */
	public void setJobs(Collection<Job> jobs) {
		jobs1 = jobs;
	}

}
