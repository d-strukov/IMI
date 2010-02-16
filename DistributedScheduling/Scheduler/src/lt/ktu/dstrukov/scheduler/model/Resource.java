package lt.ktu.dstrukov.scheduler.model;

import lt.ktu.dstrukov.scheduler.model.collections.BaseCollection;
import lt.ktu.dstrukov.scheduler.model.collections.CollectionItem;
import lt.ktu.dstrukov.scheduler.model.collections.ResourceCollection;
import lt.ktu.dstrukov.scheduler.model.misc.IDGenerator;

public abstract class Resource extends AbstractBase implements CollectionItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8649114892142916577L;

	private ResourceOwner owner;
	private ResourceCollection collection;

	/**
	 * @return the resource owner
	 */
	public ResourceOwner getOwner() {
		return owner;
	}

	/**
	 * @param owner
	 *            the owner to set
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

	public ResourceCollection getCollection() {
		return collection;
	}

}
