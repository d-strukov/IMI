package lt.ktu.dstrukov.schoolscheduler;

import java.io.File;

import lt.ktu.dstrukov.scheduler.model.Execution;
import lt.ktu.dstrukov.scheduler.model.Periode;
import lt.ktu.dstrukov.scheduler.model.TimeFrame;
import lt.ktu.dstrukov.scheduler.model.collections.ResourceCollection;
import lt.ktu.dstrukov.schoolscheduler.model.SchoolData;
import lt.ktu.dstrukov.schoolscheduler.model.io.DataParser;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SchoolData data = new SchoolData();
		new DataParser(data, new File("SchoolData1.xml"));
		
		for( ResourceCollection c : data.getResourceCollections()){
			System.out.println(c.toString());
		}
		
		Periode parent = new Periode(1);
		Execution e = Execution.createExecution(data, data.getTaskBySequence(0),new TimeFrame(parent));
		System.out.println("Finished " + e);
		
	}

}
