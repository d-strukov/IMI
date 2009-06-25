package lt.ktu.dstrukov.scheduler.model;

import lt.ktu.dstrukov.scheduler.model.collections.BaseCollection;
import lt.ktu.dstrukov.scheduler.model.collections.CollectionItem;
import lt.ktu.dstrukov.scheduler.model.misc.IDGenerator;

public class ResourceOwner extends AbstractBase implements CollectionItem {




	/**
	 * 
	 */
	private static final long serialVersionUID = -6178263289529968750L;
	
	
	public ResourceOwner(ResourceOwnerType type) {
		super();
		this.type =type;
	}
	
	
	private ResourceOwnerType type; 
	
	/**
	 * @return the type
	 */
	public ResourceOwnerType getType() {
		return type;
	}


	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


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
	
	
	@Override
	public String toString() {
		
		return "ResourceOwner["+getId()+"]";
	}


	@Override
	public void setCollection(BaseCollection<?> collection) {
				
	}

}
