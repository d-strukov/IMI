package lt.ktu.dstrukov.schoolscheduler.model;

import lt.ktu.dstrukov.scheduler.model.Resource;
import lt.ktu.dstrukov.scheduler.model.Task;

public class Environment extends Resource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6918929602403579253L;

	

	public Room getRoom() {
		return (Room)getOwner();
	}

	public Environment(Room r) {
		setOwner(r);
	}

	@Override
	public boolean isCompatibleWithResource(Resource res) {
		if (!(res instanceof Job))
			return true;

		return getRoom().getCompatibleResources().contains(res);
	}

	@Override
	public boolean isCompatibleWithTask(Task task) {
		return getRoom().getCompatibleTasks().contains(task);
	}

}
