package lt.ktu.rmi.transfare;

import java.io.Serializable;

public class RemoteTask implements Serializable, Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -740764843255875330L;
	private Runnable run;
	private int id = 0;
	private TaskEndListener listener;

	public RemoteTask(Runnable task, int id) {
		this.run = task;
		this.id = id;
	}

	public void run() {
		run.run();
		if (listener != null)
			listener.TaskFinished(this);
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
		RemoteTask other = (RemoteTask) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public void setListener(TaskEndListener listener) {
		this.listener = listener;
	}

}
