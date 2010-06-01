package lt.ktu.dstrukov.schoolscheduler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import lt.ktu.dstrukov.scheduler.model.collections.ResourceCollection;
import lt.ktu.dstrukov.schoolscheduler.model.SchoolData;
import lt.ktu.dstrukov.schoolscheduler.model.SchoolSchedule;
import lt.ktu.dstrukov.schoolscheduler.model.io.DataParser;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SchoolData data = new SchoolData();
		try {
			new DataParser(data, new FileInputStream(new File(
					"Optimai_Trakai.xml")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (ResourceCollection c : data.getResourceCollections()) {
			System.out.println(c.toString());
		}

		SchoolSchedule schedule = new SchoolSchedule(data);

		System.out.println("Finished " + schedule.evaluateQuality());

	}

}
