package lt.ktu.rmi.transfare;

import java.io.Serializable;

public interface ResultContainer extends Runnable, Serializable {

	public Object getTask();

}
