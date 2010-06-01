package lt.ktu.dstrukov.schoolscheduler.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lt.ktu.dstrukov.scheduler.model.Data;
import lt.ktu.dstrukov.scheduler.model.MinMaxRequirement;
import lt.ktu.dstrukov.scheduler.model.ResourceOwner;
import lt.ktu.dstrukov.scheduler.model.Task;
import lt.ktu.dstrukov.scheduler.model.collections.ResourceCollection;
import lt.ktu.dstrukov.scheduler.model.collections.ResourceOwnerCollection;
import lt.ktu.dstrukov.scheduler.model.collections.TaskCollection;

/**
 * @author Denis
 */
public class SchoolData extends Data {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3406228162185748012L;

	private List<ResourceOwnerCollection> ownerCollectionList = new ArrayList<ResourceOwnerCollection>();
	/**
	 * @uml.property name="students"
	 * @uml.associationEnd
	 */
	private ResourceOwnerCollection students = new ResourceOwnerCollection();
	/**
	 * @uml.property name="teachers"
	 * @uml.associationEnd
	 */
	private ResourceOwnerCollection teachers = new ResourceOwnerCollection();
	/**
	 * @uml.property name="rooms"
	 * @uml.associationEnd
	 */
	private ResourceOwnerCollection rooms = new ResourceOwnerCollection();
	public static final int STUDENTS = 0;

	public static final int TEACHERS = 1;

	public static final int ROOMS = 2;

	private List<ResourceCollection> resourceCollectionList = new ArrayList<ResourceCollection>();
	/**
	 * @uml.property name="jobs"
	 * @uml.associationEnd
	 */
	private ResourceCollection jobs = new ResourceCollection();
	/**
	 * @uml.property name="servers"
	 * @uml.associationEnd
	 */
	private ResourceCollection servers = new ResourceCollection();
	/**
	 * @uml.property name="environments"
	 * @uml.associationEnd
	 */
	private ResourceCollection environments = new ResourceCollection();
	public static final int JOBS = 0;

	public static final int SERVERS = 1;

	public static final int ENVIRONMENTS = 2;

	/**
	 * @uml.property name="tasks"
	 * @uml.associationEnd
	 */
	private TaskCollection tasks = new TaskCollection();

	/**
	 * @uml.property name="penalties"
	 * @uml.associationEnd
	 */
	private Penalties penalties = new Penalties();

	private List<StudentGroup> groups = new ArrayList<StudentGroup>();

	public SchoolData() {
		ownerCollectionList.add(STUDENTS, students);
		ownerCollectionList.add(TEACHERS, teachers);
		ownerCollectionList.add(ROOMS, rooms);

		// The sequence is important
		// priority is highest on top of the list
		resourceCollectionList.add(JOBS, jobs);
		resourceCollectionList.add(SERVERS, servers);
		resourceCollectionList.add(ENVIRONMENTS, environments);

	}

	public boolean addStudent(Student student) {
		return students.add(student);
	}

	public boolean addTeacher(Teacher teacher) {
		return teachers.add(teacher);
	}

	public boolean addRoom(Room room) {
		return rooms.add(room);
	}

	public boolean addStudentGroup(StudentGroup group) {
		return groups.add(group);
	}

	public boolean addJob(Job job) {
		return jobs.add(job);
	}

	public boolean addServer(Server server) {
		return servers.add(server);
	}

	public boolean addEnvironment(Environment env) {
		return environments.add(env);
	}

	public boolean addTask(SchoolTask type) {
		return tasks.add(type);
	}

	public SchoolTask getTaskByCode(String code) {
		for (Task t : tasks) {
			if (((SchoolTask) t).getCode().equals(code))
				return (SchoolTask) t;
		}
		return null;
	}

	@Override
	public List<ResourceCollection> getResourceCollections() {

		return resourceCollectionList;
	}

	@Override
	public List<ResourceOwnerCollection> getResourceOwnerCollections() {
		return ownerCollectionList;
	}

	@Override
	public Map<Task, Map<ResourceCollection, MinMaxRequirement>> getResourceRequirements() {

		Map<Task, Map<ResourceCollection, MinMaxRequirement>> ret = new HashMap<Task, Map<ResourceCollection, MinMaxRequirement>>();

		for (Task t : tasks) {
			Map<ResourceCollection, MinMaxRequirement> req = new HashMap<ResourceCollection, MinMaxRequirement>();
			req.put(resourceCollectionList.get(JOBS), new MinMaxRequirement(1,
					30));
			req.put(resourceCollectionList.get(SERVERS), new MinMaxRequirement(
					1, 1));
			req.put(resourceCollectionList.get(ENVIRONMENTS),
					new MinMaxRequirement(1, 1));
			ret.put(t, req);
		}

		return ret;
	}

	@Override
	public TaskCollection getTaskCollection() {

		return tasks;
	}

	public StudentGroup getStudentGroupByCode(String code) {
		for (StudentGroup sg : groups) {
			if (sg.getGroupDescription().equals(code))
				return sg;
		}
		return null;
	}

	public SchoolTask getTaskBySequence(int i) {
		return (SchoolTask) tasks.get(i);
	}

	public Room getRoomByCode(String str) {
		for (ResourceOwner r : rooms) {
			if (r.getDescription().equals(str))
				return (Room) r;
		}
		return null;
	}

	/**
	 * @return
	 * @uml.property name="penalties"
	 */
	public Penalties getPenalties() {
		return penalties;
	}

	public void clear() {

		environments.clear();
		students.clear();
		jobs.clear();
		tasks.clear();
		teachers.clear();
		servers.clear();
		rooms.clear();
		groups.clear();
		// resourceCollectionList.clear();
		// ownerCollectionList.clear();

	}

}
