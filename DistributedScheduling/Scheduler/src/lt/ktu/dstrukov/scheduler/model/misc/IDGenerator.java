package lt.ktu.dstrukov.scheduler.model.misc;

import java.io.Serializable;

public interface IDGenerator  extends Serializable{
	
	/**
	 * 
	 * @return next unique id;
	 */
	public int next();
}
