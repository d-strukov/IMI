package lt.ktu.dstrukov.scheduler.model;

import lt.ktu.dstrukov.scheduler.model.collections.BaseCollection;
import lt.ktu.dstrukov.scheduler.model.collections.CollectionItem;
import lt.ktu.dstrukov.scheduler.model.misc.IDGenerator;

/**
 * @author Denis
 */
public abstract class ResourceOwner extends AbstractBase implements
		CollectionItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6178263289529968750L;

	/**
	 * @uml.property name="description"
	 */
	private String description;

	/**
	 * @return the description
	 * @uml.property name="description"
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the name to set
	 * @uml.property name="description"
	 */
	public void setDescription(String description) {
		this.description = description;
	}

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

	@Override
	public String toString() {

		return "ResourceOwner[" + description + "]";
	}

	@Override
	public void setCollection(BaseCollection<?> collection) {

	}

}
