package lt.ktu.dstrukov.schoolscheduler.model.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import lt.ktu.dstrukov.scheduler.model.Task;
import lt.ktu.dstrukov.schoolscheduler.model.Environment;
import lt.ktu.dstrukov.schoolscheduler.model.Job;
import lt.ktu.dstrukov.schoolscheduler.model.Room;
import lt.ktu.dstrukov.schoolscheduler.model.SchoolData;
import lt.ktu.dstrukov.schoolscheduler.model.SchoolTask;
import lt.ktu.dstrukov.schoolscheduler.model.Server;
import lt.ktu.dstrukov.schoolscheduler.model.Student;
import lt.ktu.dstrukov.schoolscheduler.model.StudentGroup;
import lt.ktu.dstrukov.schoolscheduler.model.Teacher;
import lt.ktu.dstrukov.schoolscheduler.utils.StringParser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DataParser {

	protected static final String DELIMITER2 = "#";

	protected static final String DELIMITER1 = ";";

	private SchoolData data;

	private XmlDataReader reader;

	public DataParser(SchoolData d, File file) {
		data = d;
		System.out.println("File Found:  " + file.exists());
		String path = "";
		path = file.getPath();
		reader = new XmlDataReader(path);

		parseJobTypes(reader);
		parseStudents(reader);
		parseServers(reader);

	}

	public void parseStudents(XmlDataReader read) {

		for (int j = 2; j < read.getSheet_count() - 1; j++) {

			StudentGroup group = new StudentGroup();
			String gCode = read.getName(j);
			group.setGroupDescription(gCode);
			data.addStudentGroup(group);

			for (int i = 0; i < read.getRow_count(j); i++) {

				Node n = read.getData(j).item(i);
				Element row = (Element) n;

				if (i > 1) {

					Student student = new Student(group);
					data.addStudent(student);
					NodeList cells = row.getElementsByTagName("Cell");

					for (int k = 0; k < cells.getLength(); k++) {

						boolean flag = true;
						Node list = null;
						try {
							list = cells.item(k).getChildNodes().item(0)
									.getFirstChild();

						} catch (NullPointerException ex) {
							flag = false;
						}

						if (k < 2)
							continue;

						if (k < data.getTaskCollection().size() + 2) {
							if (flag) {

								String jobDescriptorString = list
										.getNodeValue();
								int splitIndex = jobDescriptorString.length();
								String s = jobDescriptorString.substring(0,
										splitIndex);

								while (!StringParser.tryParseInt(s)) {
									splitIndex--;
									s = s.substring(0, splitIndex);
								}

								int jobCount = Integer.parseInt(s);
								String level = jobDescriptorString
										.substring(splitIndex);

								for (int z = 0; z < jobCount; z++) {
									Job job = new Job(student, data
											.getTaskBySequence(k - 2), level);
									// data.getJobType(k - 2).addJob(job);
									data.addJob(job);
									student.addJob(job);
								}

							}

						}

					}

				}

			}

		}

	}

	public void parseServers(XmlDataReader read) {

		for (int i = 0; i < read.getRow_count(1); i++) {
			Node n = read.getData(1).item(i);
			Element eilute = (Element) n;
			if (i < 2)
				continue;

			NodeList cells = eilute.getElementsByTagName("Cell");
			Teacher teacher = new Teacher();

			String hours = "";
			String codes = "";
			String groups = "";
			String classrooms ="";
			String periodeRestrictions = "";

			for (int k = 0; k < cells.getLength(); k++) {
				Node nnn;

				try {
					nnn = cells.item(k).getChildNodes().item(0).getFirstChild();

				} catch (NullPointerException ex) {
					nnn = null;
				}

				switch (k) {
				case 3:

					break;
				case 4:
					if (nnn != null)
						classrooms = nnn.getNodeValue();
					break;
				case 5:
					if (nnn != null)
						hours = nnn.getNodeValue();
					break;
				case 6:
					if (nnn != null)
						codes = nnn.getNodeValue();
					break;
				case 7:
					if (nnn != null)
						groups = nnn.getNodeValue();
					break;
				case 8:
					if (nnn != null)
						periodeRestrictions = nnn.getNodeValue();
					break;
				}

			}

			if (!hours.isEmpty() || !codes.isEmpty() || !groups.isEmpty() || !classrooms.isEmpty()) {
				parseJobTypesAndHours(teacher, hours, codes,classrooms);
				parseIssuerGroups(teacher, groups, codes);
				
				data.addTeacher(teacher);
			}

		}

	}
	
	
	

	/**
	 * Parses {@link Task}s that given server can serve and assigns capacity to
	 * each of the type.<br>
	 * Also adds {@link ExecutionResource} to available server list of the
	 * {@link Task}
	 * 
	 * @param teacher
	 *            - {@link ExecutionResource}
	 * @param hours
	 *            - String of capacities to parse
	 * @param codes
	 *            - String of JobType Codes to parse.
	 */
	protected void parseJobTypesAndHours(Teacher teacher, String hours,
			String codes, String classrooms) {
		String[] hourSplit = hours.trim().split(DELIMITER1);
		String[] codeSplit = codes.trim().split(DELIMITER1);
		String[] classSplit = classrooms.trim().split(DELIMITER1);

		if (hourSplit.length != codeSplit.length)
			throw new RuntimeException("Error parsing Teacher: "
					+ teacher.getId()
					+ "; Reason: hour and code amount does not match");

		List<Integer> h = new ArrayList<Integer>();
		for (String str : hourSplit) {
			try {
				h.add(Integer.parseInt(str));
			} catch (NumberFormatException e) {
				throw new RuntimeException("Not a number: " + str, e);
			}
		}

		List<SchoolTask> t = new ArrayList<SchoolTask>();

		for (String str : codeSplit) {
			SchoolTask jt = data.getTaskByCode(str);
			if (jt == null)
				throw new RuntimeException("Task does not exist: " + str);
			t.add(jt);
			// jt.addServer(s);
		}
		
		

		for (String str : classSplit) {
			Room r = data.getRoomByCode(str);
			if (r == null){
				r= new Room(str);
				data.addRoom(r);
				r.addCompatibleResourceOwners(teacher);
				for(Task task : t){
					r.addCompatibleTask(task);
				}
				Environment env = new Environment(r);
				data.addEnvironment(env);
			} else {
				r.addCompatibleResourceOwners(teacher);
				for(Task task : t){
					r.addCompatibleTask(task);
				}				
			}
				
			
			// jt.addServer(s);
		}

		for (int i = 0; i < h.size(); i++) {
			for (int j = 0; j < h.get(i); j++) {
				Server s = new Server(t.get(i), teacher);
				data.addServer(s);
			}
		}

	}

	protected void parseIssuerGroups(Teacher s, String toParse, String codes) {

		String[] classGroup = toParse.trim().split(DELIMITER2);
		String[] codeSplit = codes.trim().split(DELIMITER1);
		if (classGroup.length != codeSplit.length)
			throw new RuntimeException("Error parsing Server: " + s.getId()
					+ "; Reason: Group and code amount does not match");

		List<SchoolTask> t = new ArrayList<SchoolTask>();

		for (String str : codeSplit) {
			SchoolTask jt = data.getTaskByCode(str);
			if (jt == null)
				throw new RuntimeException("JobType does not exist: " + str);
			t.add(jt);
		}

		List<StudentGroup> groups = new ArrayList<StudentGroup>();

		for (int i = 0; i < t.size(); i++) {
			String[] g = classGroup[i].trim().split(DELIMITER1);
			for (int j = 0; j < g.length; j++) {
				StudentGroup gr = data.getStudentGroupByCode(g[j].trim());
				if (gr == null)
					throw new RuntimeException("Issuer Group does not exist: "
							+ g[j]);
				groups.add(gr);
			}
			s.addTaskLimitations(t.get(i), groups);
		}
	}

	public void parseJobTypes(XmlDataReader read) {

		int rowCount = read.getRow_count(0);

		for (int i = 0; i < rowCount; i++) {
			Node n = read.getData(0).item(i);
			Element eilute = (Element) n;
			if (i > 0) {
				NodeList cells = eilute.getElementsByTagName("Cell");
				SchoolTask type = new SchoolTask();
				boolean valid = false;

				for (int k = 0; k < cells.getLength(); k++) {
					valid = true;
					NodeList d = eilute.getElementsByTagName("Data");
					Node duom = d.item(k);
					if (duom == null) {
						valid = false;
						break;
					}
					Node nnn = duom.getFirstChild();

					if (k == 0) {
						type.setCode(nnn.getNodeValue());

					}

				}

				if (valid && data.getTaskByCode(type.getCode()) != null)
					type = data.getTaskByCode(type.getCode());

				data.addTask(type);
			}
		}
	}

}
