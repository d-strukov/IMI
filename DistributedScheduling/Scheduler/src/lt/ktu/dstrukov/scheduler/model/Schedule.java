package lt.ktu.dstrukov.scheduler.model;

import java.util.ArrayList;
import java.util.List;

import lt.ktu.dstrukov.scheduler.model.collections.ResourceCollection;
import lt.ktu.dstrukov.scheduler.model.collections.TaskCollection;
import lt.ktu.dstrukov.scheduler.model.misc.IDGenerator;

public abstract class Schedule extends AbstractBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8945579833081585810L;

	private static int count = -1;
	private IDGenerator idGenerator;
	private List<Periode> periods = new ArrayList<Periode>();
	private List<Execution> executions = new ArrayList<Execution>();
	private Data data;
	

	protected Data getData() {
		return data;
	}

	public Schedule(Data data) {
		this.data=data;
		// Initialize Periods and TimeFrames
		for (int i = 0; i < getPeriodCount(); i++) {
			Periode p = new Periode(getFramesPerPeriod());
			periods.add(p);
		}

		// Start Creating executions
		TaskCollection tasks = data.getTaskCollection();
		while (!getResourceCollectionToExaust().isEmpty()) {
			for (Task task : tasks) {
				if(getResourceCollectionToExaust().isEmpty()) break;
				for (Periode p : periods) {
					if(getResourceCollectionToExaust().isEmpty()) break;
					for (TimeFrame frame : p.getFrames()) {
						if(getResourceCollectionToExaust().isEmpty()) break;
						
						Execution e = null;
						try{
							e=Execution.createExecution(data, task,frame);
						} catch(Exception ex){
							System.out.println(ex.getMessage());
						}
								
						
						if(e!=null){
							executions.add(e);
							getResourceCollectionToExaust().removeAll(e.getResources());
						}

					}
				}

			}

		}
		
		System.out.println("Finished");

	}

	@Override
	protected IDGenerator getIDGenerator() {
		if (idGenerator == null) {
			idGenerator = new IDGenerator() {

				@Override
				public int next() {
					count++;
					return count;
				}
			};
		}
		return idGenerator;
	}

	/**
	 * Return an integer - period count. Normally denotes days 
	 * @return period count
	 */
	protected abstract int getPeriodCount();

	/**
	 *  Return integer - frames per period. Nor
	 * @return
	 */
	protected abstract int getFramesPerPeriod();
	
	/**
	 * Return Resource Collection that has to be exhausted before Schedule is considered complete
	 * @return Resource collection
	 */
	protected abstract ResourceCollection getResourceCollectionToExaust();
	
	/**
	 * Provide a function to evaluate quality of a schedule. (Application will try to minimize given function)
	 * @return number of penalty points
	 */
	protected abstract int evaluateQuality();

}
