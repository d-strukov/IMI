package lt.ktu.scheduler.model.interfaces;

import lt.ktu.scheduler.model.Job;
import lt.ktu.scheduler.model.Task;

public interface Resource {

	/**
	 * Tests the resource against provided {@link BaseTask} if resource can be
	 * supplied to a given task
	 * 
	 * @param task
	 *            - a {@link BaseTask} to test against
	 * @return - true if resource and a task are compatible
	 */
	public boolean isCompatibleWithTask(Task task);

	/**
	 * Tests the resource against provided {@link BaseJob} if resource can be
	 * used with a given job
	 * 
	 * @param job
	 *            - a {@link BaseJob} to test against
	 * @return - true if resource and a job are compatible
	 */
	public boolean isCompatableWithJob(Job job);

	/**
	 * Tests the resource against provided {@link Resource} if resource can be
	 * used along with the given resource
	 * 
	 * @param res
	 *            - a {@link Resource} to test against
	 * @return - true if resource and a given resource are compatible
	 */
	public boolean isCompatibleWithResource(Resource res);

}
