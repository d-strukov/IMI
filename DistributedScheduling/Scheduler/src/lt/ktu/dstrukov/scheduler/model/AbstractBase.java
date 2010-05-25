package lt.ktu.dstrukov.scheduler.model;

import java.io.Serializable;

import lt.ktu.dstrukov.scheduler.model.misc.IDGenerator;

/**
 * @author  Denis
 */
public abstract class AbstractBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5219726585304972261L;
	
	/**
	 * @uml.property  name="id"
	 */
	private int id;

	

	/**
	 * @return
	 * @uml.property  name="id"
	 */
	public  int getId(){
		return id;
	}
	
	
	protected abstract IDGenerator getIDGenerator();

	public AbstractBase() {
		id = getIDGenerator().next();
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
