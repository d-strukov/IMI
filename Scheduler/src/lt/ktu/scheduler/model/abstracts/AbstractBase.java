package lt.ktu.scheduler.model.abstracts;

import lt.ktu.scheduler.model.utils.IDGeneratorI;

public abstract class AbstractBase {

	private int id;

	public AbstractBase() {
		id = getIDGenerator().generateID();
	}

	protected abstract IDGeneratorI getIDGenerator();

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractBase other = (AbstractBase) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
