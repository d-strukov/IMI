package lt.ktu.dstrukov.scheduler.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import lt.ktu.dstrukov.scheduler.model.collections.ResourceCollection;
import lt.ktu.dstrukov.scheduler.model.collections.ResourceOwnerCollection;
import lt.ktu.dstrukov.scheduler.model.collections.TaskCollection;

public abstract class Data implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5673573010266046252L;


	public abstract List<ResourceOwnerCollection> getResourceOwnerCollections();
	
	public abstract List<ResourceCollection> getResourceCollections();
	
	public abstract TaskCollection getTaskCollection();
	
	protected abstract Map<Task, Map<ResourceCollection, MinMaxRequirement>> getResourceRequirements();
	

}
