package lt.ktu.scheduler.model;

import lt.ktu.scheduler.model.abstracts.AbstractBase;
import lt.ktu.scheduler.model.utils.IDGeneratorI;
import lt.ktu.scheduler.model.utils.IncrementalIDGenerator;

public class Job extends AbstractBase {

	private Task task;

	@Override
	protected IDGeneratorI getIDGenerator() {
		return new IncrementalIDGenerator();
	}

	public Task getTask() {
		return task;
	}

}
