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
	
	protected List<Resource> getResources() {
		return resources;
	}

	//Encapsulate default Constructor
	private Execution(){};

	public static Execution createExecution(Data data, Task task,
			TimeFrame frame) {
		Execution execution = new Execution();

		// initialize requirements map
		Map<ResourceCollection, MinMaxRequirement> req = data
				.getResourceRequirements().get(task);
		List<ResourceCollection> allResources = data.getResourceCollections();

		// initialize compatibility map
		Map<ResourceCollection, List<Resource>> taskCompatibleMap = null;
		try {
			taskCompatibleMap = data.getCompatibleResources(task);
		} catch (InsufficientResourceException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

		// in case of failure, throw runtime exception
		if (taskCompatibleMap == null)
			throw new RuntimeException("taskCompatibleMap == null");
		

		// start collecting resources
		for (ResourceCollection rc : allResources) {

			// get resource requirements
			MinMaxRequirement minMax = req.get(rc);

			// get task compatible resources
			List<Resource> taskCompatible = taskCompatibleMap.get(rc);

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
			
			// at this place an initial group of students, a teacher and a task 

			
			
			// in case these are last resources and are all compatible + less
			// then max limit
			if (compatible.size() <= minMax.getMax() && compatible.size() == taskCompatible.size() ) {
				// put all of the resources in an Execution
				execution.resources.addAll(compatible);
				continue;
			}
			
			

			// Choose amount of resources between min and max
			int amountNeeded = RandomGenerator.getRandomNumber(minMax.getMin(),
					minMax.getMax());

			// see if random amount is available
			if (compatible.size() >= amountNeeded) {
				// TODO: it would be nice to make sure that there is place
				// for another execution for this task

				// make it random
				Collections.shuffle(compatible);

				// choose the amount of resources
				List<Resource> chosen = compatible.subList(0, amountNeeded - 1);

				// add them to execution
				execution.resources.addAll(chosen);
			} else {
				return null;
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
