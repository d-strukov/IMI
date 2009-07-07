package lt.ktu.dstrukov.scheduler.model;

import lt.ktu.dstrukov.scheduler.model.collections.BaseCollection;
import lt.ktu.dstrukov.scheduler.model.collections.CollectionItem;
import lt.ktu.dstrukov.scheduler.model.misc.IDGenerator;

public class ResourceOwner extends AbstractBase implements CollectionItem {




	/**
	 * 
	 */
	private static final long serialVersionUID = -6178263289529968750L;
	



	private String description;

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the name to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
