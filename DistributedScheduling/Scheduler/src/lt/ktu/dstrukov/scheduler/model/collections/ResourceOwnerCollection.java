package lt.ktu.dstrukov.scheduler.model.collections;


import lt.ktu.dstrukov.scheduler.model.ResourceOwner;
import lt.ktu.dstrukov.scheduler.model.ResourceOwnerType;

public class ResourceOwnerCollection extends BaseCollection<ResourceOwner> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7651123455649683075L;
	
	private ResourceOwnerType type = ResourceOwnerType.Unknown;
	
	
	public boolean add(ResourceOwner o) {
		if(type == ResourceOwnerType.Unknown){
			type=o.getType();
			return super.add(o);
		} else {
			if(type==o.getType()) return super.add(o);
			else return false;			
		}
	};



}
