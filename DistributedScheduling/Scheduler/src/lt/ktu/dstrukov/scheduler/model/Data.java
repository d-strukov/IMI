package lt.ktu.dstrukov.scheduler.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lt.ktu.dstrukov.scheduler.exception.InsufficientResourceException;
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
	
	public abstract Map<Task, Map<ResourceCollection, MinMaxRequirement>> getResourceRequirements();
	
	public List<List<Resource>> getCompatibleResources(Task task) throws InsufficientResourceException{
		List<List<Resource>> ret = new ArrayList<List<Resource>>();
		
		for(ResourceCollection c : getResourceCollections()){
			List<Resource> res = new ArrayList<Resource>();
			for(Resource r : c){
				if(r.isCompatibleWithTask(task)) res.add(r);
			}
			
			if(res.size()<=0){
				throw new InsufficientResourceException(c,task);
			}
			
			ret.add(res);
		}
		
		
		return ret;
	}
	

}
