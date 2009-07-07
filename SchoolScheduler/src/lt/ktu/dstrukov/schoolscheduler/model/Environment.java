package lt.ktu.dstrukov.schoolscheduler.model;

import lt.ktu.dstrukov.scheduler.model.Resource;
import lt.ktu.dstrukov.scheduler.model.Task;

public class Environment extends Resource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6918929602403579253L;
	
	

	@Override
	public boolean isCompatibleWithResource(Resource res) {

		return false;
	}

	@Override
	public boolean isCompatibleWithTask(Task task) {

		return false;
	}

}
