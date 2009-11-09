package lt.ktu.dstrukov.schoolscheduler.model;


import lt.ktu.dstrukov.scheduler.exception.InsufficientResourceException;
import lt.ktu.dstrukov.scheduler.model.Action;
import lt.ktu.dstrukov.scheduler.model.Periode;
import lt.ktu.dstrukov.scheduler.model.Resource;
import lt.ktu.dstrukov.scheduler.model.ResourceOwner;
import lt.ktu.dstrukov.scheduler.model.Schedule;
import lt.ktu.dstrukov.scheduler.model.TimeFrame;
import lt.ktu.dstrukov.scheduler.model.collections.ResourceCollection;
import lt.ktu.dstrukov.scheduler.model.collections.ResourceOwnerCollection;

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
	public int evaluateQuality() {
		
		int count =0;
		ResourceOwnerCollection teachers = getData().getResourceOwnerCollections().get(SchoolData.TEACHERS);
		ResourceOwnerCollection students = getData().getResourceOwnerCollections().get(SchoolData.STUDENTS);
		
		count += calculateWindows(teachers)  * getData().getPenalties().getTeacherWindows();
		count += calculateWindows(students) * getData().getPenalties().getStudentWindows();
		
		return count;
	}
	
	private int calculateWindows(ResourceOwnerCollection owners){
		
		int count =0;
		for(ResourceOwner ro : owners){
			count +=calculateWindows(ro);
		}
		return count;
	}
	
	private int calculateWindows(ResourceOwner owner){
	
		int count =0;
		for (Periode p : getPeriods()){
			int tempCount=0;
			boolean studiesThatPeriode = false;
			for(TimeFrame tf : p.getFrames()){
			
				boolean studiesAtTimeframe = tf.containsResourceOwner(owner);
				
				if(studiesAtTimeframe  && studiesThatPeriode){
					count+= tempCount;
					tempCount =0;
				}
				
				if(studiesAtTimeframe && !studiesThatPeriode){
					studiesThatPeriode =true;
				} 
				
				if(!studiesAtTimeframe && studiesThatPeriode) {
					tempCount ++;
				}				
			}
			
		}
	
		return count;
		
	}

	@Override
	protected Action handleInsufitientResourceException(
			InsufficientResourceException ex) {
		SchoolTask task = (SchoolTask)ex.getTask();
		
		
		
		if(ex.getCollection().size() <=0) return Action.Fatal;
		Resource r = ex.getCollection().get(0);
		
		if(r instanceof Job){
			ex.setMessage("Jobs for " + task.getCode() + " are exhausted");
			return Action.SkipTask;
		}
		
		if(r instanceof Server){
			ex.setMessage("Servers for " + task.getCode() + " are exhausted at given time frame");
			return Action.SkipFrame;
		}
		
		if(r instanceof Environment){
			ex.setMessage("Environments for " + task.getCode() + " are exhausted at given time frame");
			return Action.SkipFrame;
		}
		
		ex.setMessage("Resource for " + task.getCode() + " are exhausted at given time frame");
		
		return Action.SkipFrame;
	}
	

}
