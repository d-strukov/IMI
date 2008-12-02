package lt.ktu.rmi.semantics;

import java.io.Serializable;

public interface ResultContainer extends Runnable, Serializable {

	public Object getResults();

}
