package lt.ktu.dstrukov.scheduler.model;

import java.util.HashSet;

import java.util.Set;

import lt.ktu.dstrukov.scheduler.model.misc.IDGenerator;

public class TimeFrame extends AbstractBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1571789704929941175L;
	
	private static int counter=-1;
	
	private IDGenerator idGenerator = new IDGenerator(){

		@Override
		public int next() {
			counter++;
			return counter;
		}
		
	};
	
	
	@Override
	protected IDGenerator getIDGenerator() {
		return idGenerator;
	}

	private Periode parent;
	
	protected Set<Task> tasks = new HashSet<Task>();
	
	protected Set<ResourceOwner> resourcesOwners = new HashSet<ResourceOwner>();
	


	public TimeFrame(Periode parent) {
		this.parent = parent;
	}

	public boolean canContainTask(Task task) {
		return true;
	}



	public boolean isResourceAvailable(AbstractResource res) {
		return !resourcesOwners.contains(res.getOwner());
	}

	
	public Periode getParent() {
		return parent;
	}

	public boolean registerJob(AbstractResource job) {
		//
		return true;
	}

	public boolean unRegisterJob(AbstractResource job) {
		//
		return true;
	}

	public boolean registerResource(AbstractResource resource, Task task) {
	//
		return true;
	}

	public boolean unRegisterResourc(AbstractResource resource, Task task) {
	//
		return true;
	}

	public void registerExecution() {
	
	}

	public boolean cointainsIssuer(AbstractResource issuer) {
		return false;
	}

}
