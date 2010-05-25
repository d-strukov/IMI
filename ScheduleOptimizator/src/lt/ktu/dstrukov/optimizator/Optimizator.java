package lt.ktu.dstrukov.optimizator;

import java.util.ArrayList;
import java.util.List;

import lt.ktu.dstrukov.commons.OptimizationParameters;
import lt.ktu.dstrukov.commons.Result;
import lt.ktu.dstrukov.optimizator.listeners.OptimizationProcesListener;
import lt.ktu.dstrukov.optimizator.utils.DeepCopyUtil;
import lt.ktu.dstrukov.schoolscheduler.model.SchoolData;
import lt.ktu.dstrukov.schoolscheduler.model.SchoolSchedule;

public class Optimizator {
	private List<Integer> res = new ArrayList<Integer>();
	private SchoolData data;
	private OptimizationParameters params;
	private SchoolSchedule best;
	private int bestPoints;

	public Optimizator(Object d, OptimizationParameters p) {

		data = (SchoolData) d;
		params = p;

	}

	public void start(OptimizationProcesListener callback) {

		callback.onBeforeOptimization();
		for (int i = 0; i < params.getIterationCount(); i++) {

			SchoolData d = (SchoolData) DeepCopyUtil.copy(data);
			callback.onIterationStart();
			SchoolSchedule schedule = new SchoolSchedule(d);

			int points = schedule.evaluateQuality();

			if (best == null || points < bestPoints) {
				best = schedule;
				bestPoints = points;
			}

			Result result = new Result("" + points);
			res.add(points);
			callback.onIterationComplete(result);
		}
		callback.onAfterOptimization();

	}

	public List<Integer> getResults() {
		return res;
	}

	public SchoolSchedule getBest() {
		return best;
	}

}
