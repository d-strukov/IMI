package lt.ktu.dstrukov.scheduler.model;

import java.util.ArrayList;
import java.util.List;

import lt.ktu.dstrukov.scheduler.model.misc.IDGenerator;

public abstract class Schedule extends AbstractBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8945579833081585810L;

	private static int count = -1;
	private IDGenerator idGenerator;
	private List<Periode> periods = new ArrayList<Periode>();

	public Schedule(Data data) {
		
		//Initialize Periods and TimeFrames
		for (int i = 0; i < getPeriodeCount(); i++) {
			Periode p = new Periode(getFramesPerPeriode());
			periods.add(p);
		}
		
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

	protected abstract int getPeriodeCount();

	protected abstract int getFramesPerPeriode();

}
