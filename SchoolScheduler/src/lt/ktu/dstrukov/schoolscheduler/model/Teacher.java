package lt.ktu.dstrukov.schoolscheduler.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lt.ktu.dstrukov.scheduler.model.ResourceOwner;

public class Teacher extends ResourceOwner {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3869774757983058018L;

	private Map<SchoolTask, List<StudentGroup>> limitations = new HashMap<SchoolTask, List<StudentGroup>>();
	private List<SchoolTask> tasks = new ArrayList<SchoolTask>();
	private List<Integer> desiredDaysOff = new ArrayList<Integer>();
	private List<Server> servingResources = new ArrayList<Server>();

	public void addTaskLimitations(SchoolTask task, List<StudentGroup> groups) {

		if (limitations.containsKey(task)) {
			limitations.get(task).addAll(groups);
		} else {
			limitations.put(task, groups);
		}
	}

	public void addServingResource(Server s) {
		servingResources.add(s);
	}

}
