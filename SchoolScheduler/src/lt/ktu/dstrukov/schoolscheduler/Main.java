package lt.ktu.dstrukov.schoolscheduler;

import java.io.File;

import lt.ktu.dstrukov.schoolscheduler.model.SchoolData;
import lt.ktu.dstrukov.schoolscheduler.model.io.DataParser;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SchoolData data = new SchoolData();
		
		new DataParser(data, new File("E:\\Project\\SchoolScheduler\\SchoolData1.xml"));
		
		
		System.out.println("Finished");
		
	}

}
