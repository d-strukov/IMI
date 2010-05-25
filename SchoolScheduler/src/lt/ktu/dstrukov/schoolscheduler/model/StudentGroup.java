package lt.ktu.dstrukov.schoolscheduler.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lt.ktu.dstrukov.schoolscheduler.utils.StringParser;

/**
 * @author  Denis
 */
public class StudentGroup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1083338364235979559L;
	
	/**
	 * @uml.property  name="students"
	 */
	private List<Student> students = new ArrayList<Student>();

	/**
	 * @uml.property  name="groupDescription"
	 */
	private String groupDescription;
	/**
	 * @uml.property  name="groupLevel"
	 */
	private int groupLevel;
	/**
	 * @uml.property  name="groupID"
	 */
	private String groupID;
	
	
	/**
	 * @return
	 * @uml.property  name="students"
	 */
	public List<Student> getStudents() {
		return students;
	}


	/**
	 * @return
	 * @uml.property  name="groupDescription"
	 */
	public String getGroupDescription() {
		return groupDescription;
	}


	/**
	 * @param groupDescription
	 * @uml.property  name="groupDescription"
	 */
	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription.trim();
		int splitIndex = groupDescription.length();
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


	/**
	 * @return
	 * @uml.property  name="groupLevel"
	 */
	public int getGroupLevel() {
		return groupLevel;
	}


	/**
	 * @param groupLevel
	 * @uml.property  name="groupLevel"
	 */
	private void setGroupLevel(int groupLevel) {
		this.groupLevel = groupLevel;
	}


	/**
	 * @return
	 * @uml.property  name="groupID"
	 */
	public String getGroupID() {
		return groupID;
	}


	/**
	 * @param groupdID
	 * @uml.property  name="groupID"
	 */
	private void setGroupID(String groupdID) {
		this.groupID = groupdID;
	}


	

}
