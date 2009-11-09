package lt.ktu.dstrukov.optimizator.listeners;

import lt.ktu.dstrukov.commons.Result;

public interface OptimizationProcesListener {

	public void onBeforeOptimization();

	public void onIterationStart();

	public void onIterationComplete(Result res);

	public void onAfterOptimization();

}
