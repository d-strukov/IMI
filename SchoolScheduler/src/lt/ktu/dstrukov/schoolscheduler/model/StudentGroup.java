package lt.ktu.dstrukov.schoolscheduler.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lt.ktu.dstrukov.schoolscheduler.utils.StringParser;

public class StudentGroup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1083338364235979559L;
	
	private List<Student> students = new ArrayList<Student>();

	private String groupDescription;
	private int groupLevel;
	private String groupID;
	
	
	public List<Student> getStudents() {
		return students;
	}


	public String getGroupDescription() {
		return groupDescription;
	}


	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
		int splitIndex = groupDescription.length()-1;
		String s = groupDescription.substring(0,splitIndex);
		
		while(!StringParser.tryParseInt(s)){
			splitIndex--;
			s = s.substring(0,splitIndex);
		}
		
		int level = Integer.parseInt(s);
		String groupID = groupDescription.substring(splitIndex);
		setGroupLevel(level);
		setGroupID(groupID);
	}


	public int getGroupLevel() {
		return groupLevel;
	}


	private void setGroupLevel(int groupLevel) {
		this.groupLevel = groupLevel;
	}


	public String getGroupID() {
		return groupID;
	}


	private void setGroupID(String groupdID) {
		this.groupID = groupdID;
	}


	

}
