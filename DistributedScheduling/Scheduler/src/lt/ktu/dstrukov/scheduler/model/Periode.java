package lt.ktu.dstrukov.scheduler.model;

import java.util.ArrayList;
import java.util.List;

import lt.ktu.dstrukov.scheduler.model.misc.IDGenerator;

public class Periode extends AbstractBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1559419985234401902L;

	private static int counter=-1;
	private final List<TimeFrame> frames = new ArrayList<TimeFrame>();
	
	private IDGenerator idGenerator;
	
	
	@Override
	protected IDGenerator getIDGenerator() {
		
		if(idGenerator==null){
			idGenerator = new IDGenerator(){

				@Override
				public int next() {
					counter++;
					return counter;
				}
				
			};
		}
		return idGenerator;
	}
	

	

	public Periode(int capacity) {
		for (int i = 0; i < capacity; i++) {
			frames.add(new TimeFrame(this));
		}
	}


	public List<TimeFrame> getFrames() {
		return frames;
	}

}
