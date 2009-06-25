package lt.ktu.dstrukov.scheduler.model.collections;

import lt.ktu.dstrukov.scheduler.model.AbstractResource;
import lt.ktu.dstrukov.scheduler.model.ResourceOwnerType;

public class ResourceCollection extends BaseCollection<AbstractResource> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7651224156849683075L;
	
	private ResourceOwnerType type = ResourceOwnerType.Unknown;
	
	
	public boolean add(AbstractResource o) {
		if(type == ResourceOwnerType.Unknown){
			type = o.getOwner().getType();
			return super.add(o);
		} else {
			if(type==o.getOwner().getType()) return super.add(o);
			else return false;			
		}
	};



}
