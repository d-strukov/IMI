package lt.ktu.dstrukov.scheduler.model;

import java.util.HashSet;
import java.util.Set;

import lt.ktu.dstrukov.scheduler.model.misc.IDGenerator;

/**
 * @author Denis
 */
public class TimeFrame extends AbstractBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1571789704929941175L;

	private static int counter = -1;

	/**
	 * @uml.property name="idGenerator"
	 * @uml.associationEnd
	 */
	private IDGenerator idGenerator;

	@Override
	protected IDGenerator getIDGenerator() {
		if (idGenerator == null) {
			idGenerator = new IDGenerator() {

				@Override
				public int next() {
					counter++;
					return counter;
				}

			};
		}
		return idGenerator;
	}

	/**
	 * @uml.property name="parent"
	 * @uml.associationEnd
	 */
	private Periode parent;

	protected Set<Task> tasks = new HashSet<Task>();

	protected Set<ResourceOwner> resourcesOwners = new HashSet<ResourceOwner>();
	protected Set<Resource> resources = new HashSet<Resource>();

	public TimeFrame(Periode parent) {
		this.parent = parent;
	}

	public boolean canContainTask(Task task) {
		return true;
	}

	public boolean isResourceAvailable(Resource res) {
		return !containsResourceOwner(res.getOwner());
	}

	public boolean containsResourceOwner(ResourceOwner own) {
		return resourcesOwners.contains(own);
	}

	/**
	 * @return
	 * @uml.property name="parent"
	 */
	public Periode getParent() {
		return parent;
	}

	public boolean registerJob(Resource job) {
		//
		return true;
	}

	public boolean unRegisterJob(Resource job) {
		//
		return true;
	}

	public boolean registerResource(Resource resource, Task task) {
		resourcesOwners.add(resource.getOwner());
		resources.add(resource);
		return true;
	}

	public boolean unRegisterResourc(Resource resource, Task task) {

		return true;
	}

	public void registerExecution(Execution e) {
		for (Resource r : e.getResources()) {
			this.registerResource(r, e.getTask());
		}
	}

	public Resource getResourceOf(ResourceOwner ro) {

		for (Resource r : resources) {
			if (r.getOwner().equals(ro))
				return r;
		}

		return null;
	}
}
