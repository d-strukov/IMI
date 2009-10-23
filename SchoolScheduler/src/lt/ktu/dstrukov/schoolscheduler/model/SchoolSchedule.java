package lt.ktu.dstrukov.schoolscheduler.model;


import lt.ktu.dstrukov.scheduler.model.Schedule;
import lt.ktu.dstrukov.scheduler.model.collections.ResourceCollection;

public class SchoolSchedule extends Schedule {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5321022558314886720L;

	public SchoolSchedule(SchoolData data) {
		super(data);
		
	}
	
	@Override
	protected SchoolData getData(){
		return (SchoolData)super.getData();
	}

	
	@Override
	protected int getFramesPerPeriod() {
		
		return 24;
	}

	@Override
	protected int getPeriodCount() {
		
		return 5;
	}


	@Override
	protected ResourceCollection getResourceCollectionToExaust() {
		SchoolData data = this.getData();
		return data.getResourceCollections().get(SchoolData.JOBS);
	}


	@Override
	protected int evaluateQuality() {
		
		return 0;
	}

}
