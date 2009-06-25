package lt.ktu.dstrukov.scheduler.model;

import lt.ktu.dstrukov.scheduler.model.collections.BaseCollection;
import lt.ktu.dstrukov.scheduler.model.collections.CollectionItem;


public abstract class AbstractResource extends AbstractBase implements CollectionItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8649114892142916577L;
	
	private ResourceOwner owner;
	
	
	
	

	/**
	 * @return the resource owner
	 */
	public ResourceOwner getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(ResourceOwner owner) {
		this.owner = owner;
	}
	
	@Override
	public void setCollection(BaseCollection<?> collection) {
				
	}

	

}
