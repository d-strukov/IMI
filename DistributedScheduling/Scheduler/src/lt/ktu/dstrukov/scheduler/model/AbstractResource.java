package lt.ktu.dstrukov.scheduler.model;


public abstract class AbstractResource extends AbstractBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8649114892142916577L;
	
	private ResourceOwner owner;
	
	
	
	

	/**
	 * @return the resource owner
	 */
	protected ResourceOwner getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	protected void setOwner(ResourceOwner owner) {
		this.owner = owner;
	}
	

	

}
