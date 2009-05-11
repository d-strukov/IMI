package lt.ktu.scheduler.model;

import lt.ktu.scheduler.model.abstracts.AbstractBase;
import lt.ktu.scheduler.model.utils.IDGeneratorI;
import lt.ktu.scheduler.model.utils.IncrementalIDGenerator;

public class Task extends AbstractBase {

	private String code;

	@Override
	protected IDGeneratorI getIDGenerator() {
		return new IncrementalIDGenerator();
	}

	public String getCode() {
		return code;
	}

}
