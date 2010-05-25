package lt.ktu.dstrukov.scheduler.model;

import lt.ktu.dstrukov.scheduler.model.collections.BaseCollection;
import lt.ktu.dstrukov.scheduler.model.collections.CollectionItem;
import lt.ktu.dstrukov.scheduler.model.collections.ResourceCollection;
import lt.ktu.dstrukov.scheduler.model.misc.IDGenerator;

/**
 * @author  Denis
 */
public abstract class Resource extends AbstractBase implements CollectionItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8649114892142916577L;

	/**
	 * @uml.property  name="owner"
	 * @uml.associationEnd  
	 */
	private ResourceOwner owner;
	/**
	 * @uml.property  name="collection"
	 * @uml.associationEnd  
	 */
	private ResourceCollection collection;

	/**
	 * @return  the resource owner
	 * @uml.property  name="owner"
	 */
	public ResourceOwner getOwner() {
		return owner;
	}

	/**
	 * @param owner  the owner to set
	 * @uml.property  name="owner"
	 */
	public void setOwner(ResourceOwner owner) {
		this.owner = owner;
	}

	public abstract boolean isCompatibleWithResource(Resource res);

	public abstract boolean isCompatibleWithTask(Task task);

	@Override
	public void setCollection(BaseCollection<?> collection) {
		this.collection = (ResourceCollection) collection;
	}

	private static int counter = -1;

	/**
	 * @uml.property  name="idGenerator"
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
	 * @return
	 * @uml.property  name="collection"
	 */
	public ResourceCollection getCollection() {
		return collection;
	}

}
