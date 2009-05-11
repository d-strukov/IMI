package lt.ktu.scheduler.model.utils;


public class IncrementalIDGenerator implements IDGeneratorI {

	private int currentID = 0;

	public int generateID() {
		return currentID++;
	}

}
