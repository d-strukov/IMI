package lt.ktu.dstrukov.schoolscheduler.model;

import lt.ktu.dstrukov.scheduler.model.Resource;
import lt.ktu.dstrukov.scheduler.model.Task;

public class Environment extends Resource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6918929602403579253L;

	private Room room;

	public Room getRoom() {
		return room;
	}

	public Environment(Room r) {
		room = r;
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
