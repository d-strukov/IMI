package lt.ktu.dstrukov.scheduler.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import lt.ktu.dstrukov.scheduler.exception.InsufficientResourceException;
import lt.ktu.dstrukov.scheduler.model.collections.ResourceCollection;
import lt.ktu.dstrukov.scheduler.model.misc.IDGenerator;
import lt.ktu.dstrukov.scheduler.model.misc.RandomGenerator;

public class Execution extends AbstractBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4210880125976709984L;

	private static int count = -1;
	private IDGenerator idGenerator;
	private List<Resource> resources = new ArrayList<Resource>();

	public static Execution createExecution(Data data, Task task,
			TimeFrame frame) {
		Execution execution = new Execution();

		Map<ResourceCollection, MinMaxRequirement> req = data
				.getResourceRequirements().get(task);
		List<ResourceCollection> allResources = data.getResourceCollections();

		for (ResourceCollection rc : allResources) {
			MinMaxRequirement minMax = req.get(rc);
			List<Resource> taskCompatible = new ArrayList<Resource>();

			// get all compatible resources for the task
			try {
				taskCompatible = data.getCompatibleResources(task).get(rc);
			} catch (InsufficientResourceException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}

			// check if there is enough
			if (taskCompatible.size() < minMax.getMin()) {
				return null;
			}

			// get all compatible with the time frame
			List<Resource> compatible = new ArrayList<Resource>();
			for (Resource r : taskCompatible) {
				if (frame.isResourceAvailable(r))
					compatible.add(r);
			}

			// see if its enough for this task
			if (compatible.size() < minMax.getMin()) {
				return null;
			}

			// in case these are last resources and are all compatible + less
			// then max limit
			if (compatible.size() <= minMax.getMax()) {
				// put all of the resources in an Execution
				execution.resources.addAll(compatible);
			} else {

				// Choose amount of resources between min and max
				int amountNeeded = RandomGenerator
						.getRandomNumber(minMax.getMin(), minMax.getMax());

				// see if random amount is available
				if (compatible.size() >= amountNeeded) {
					// TODO: it would be nice to make sure that there is place
					// for another execution for this task

					// make it random
					Collections.shuffle(compatible);

					// choose the amount of resources
					List<Resource> chosen = compatible.subList(0,
							amountNeeded - 1);

					// add them to execution
					execution.resources.addAll(chosen);
				} else {
					return null;
				}
			}

		}
		return execution;
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
}
