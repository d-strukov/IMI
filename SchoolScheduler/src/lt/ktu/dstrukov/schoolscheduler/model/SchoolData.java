package lt.ktu.dstrukov.schoolscheduler.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lt.ktu.dstrukov.scheduler.model.Data;
import lt.ktu.dstrukov.scheduler.model.MinMaxRequirement;
import lt.ktu.dstrukov.scheduler.model.Resource;
import lt.ktu.dstrukov.scheduler.model.Task;
import lt.ktu.dstrukov.scheduler.model.collections.ResourceCollection;
import lt.ktu.dstrukov.scheduler.model.collections.ResourceOwnerCollection;
import lt.ktu.dstrukov.scheduler.model.collections.TaskCollection;

public class SchoolData extends Data {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3406228162185748012L;

	private List<ResourceOwnerCollection> ownerCollectionList = new ArrayList<ResourceOwnerCollection>();
	private ResourceOwnerCollection students = new ResourceOwnerCollection();
	private ResourceOwnerCollection teachers = new ResourceOwnerCollection();
	private ResourceOwnerCollection rooms = new ResourceOwnerCollection();
	private static final int STUDENTS=0,TEACHERS=1,ROOMS=2;
	
	private List<ResourceCollection> resourceCollectionList = new ArrayList<ResourceCollection>();
	private ResourceCollection jobs = new ResourceCollection();
	private ResourceCollection servers = new ResourceCollection();
	private ResourceCollection environments = new ResourceCollection();
	private static final int JOBS=0,SERVERS=1,ENVIRONMENTS=2;
	
	private TaskCollection tasks = new TaskCollection();
	
	private List<StudentGroup> groups = new ArrayList<StudentGroup>();
	
	public SchoolData() {
		ownerCollectionList.add(STUDENTS, students);
		ownerCollectionList.add(TEACHERS,teachers);
		ownerCollectionList.add(ROOMS,rooms);
		
		resourceCollectionList.add(JOBS,jobs);
		resourceCollectionList.add(SERVERS,servers);
		resourceCollectionList.add(ENVIRONMENTS,environments);
		
	}
	
	
	public boolean addStudent(Student student){
		return students.add(student);
	}
	
	public boolean addTeacher(Teacher teacher){
		return teachers.add(teacher);
	}
	
	public boolean addRoom(Room room){
		return rooms.add(room);
	}
	
	public boolean addStudentGroup(StudentGroup group){
		return groups.add(group);
	}
	
	
	public boolean addJob(Job job){
		return jobs.add(job);
	}
	
	public boolean addServer(Server server){
		return servers.add(server);
	}
	
	public boolean addEnvironment(Environment env){
		return environments.add(env);
	}
	
	public boolean addTask(SchoolTask type) {
		return tasks.add(type);
	}
	
	public SchoolTask getTaskByCode(String code) {
		for(Task t : tasks){
			if(((SchoolTask)t).getCode().equals(code))
				return (SchoolTask)t; 			
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
		return null;
	}

	@Override
	public TaskCollection getTaskCollection() {
		
		return tasks;
	}


	public StudentGroup getStudentGroupByCode(String code) {
		for(StudentGroup sg : groups){
			if(sg.getGroupDescription().equals(code)) return sg;
		}
		return null;
	}


	public SchoolTask getTaskBySequence(int i) {
		return (SchoolTask)tasks.get(i);
	}





	
	
	
	
	

}
