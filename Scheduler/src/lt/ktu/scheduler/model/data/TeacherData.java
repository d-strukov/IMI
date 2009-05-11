package lt.ktu.scheduler.model.data;

import java.util.ArrayList;
import java.util.List;

import lt.ktu.scheduler.model.i18n.SchedulerResource;
import lt.ktu.scheduler.model.utils.ValidationUtil;

public class TeacherData {

	public static String PRIMARY_SEPARATOR = ";";
	public static String SECONDARY_SEPARATOR = "#";

	private boolean validated = false;

	protected List<String> subjects;
	protected String fullName;
	protected List<List<String>> rooms;
	protected List<Integer> hours;
	protected List<String> subjectCodes;
	protected List<List<String>> canTeachGroups;
	protected List<Integer> daysOff;

	public TeacherData() {
		subjects = new ArrayList<String>();
		subjectCodes = new ArrayList<String>();
		fullName = "";
		rooms = new ArrayList<List<String>>();
		hours = new ArrayList<Integer>();
		canTeachGroups = new ArrayList<List<String>>();
		daysOff = new ArrayList<Integer>();
	}

	public TeacherData(List<String> row, List<TeacherDataColumn> order) {
		this();

		for (int i = 0; i < row.size(); i++) {
			TeacherDataColumn col = TeacherDataColumn.NotUsed;
			try {
				col = order.get(i);
			} catch (IndexOutOfBoundsException e) {
				ValidationUtil.addWarning(this, SchedulerResource
						.getTextFor("TeachersColumnError"));
			}
			switch (col) {
			case Group:
				// Not Used
				break;
			case Sequence:
				// Not Used
				break;
			case Subjects:
				parseSubjects(row.get(i));
				break;
			case Name:
				setName(row.get(i));
				break;
			case Rooms:
				parseRooms(row.get(i));
				break;
			case Hours:
				parseHours(row.get(i));
				break;
			case SubjectCodes:
				parseSubjectCodes(row.get(i));
				break;
			case CanTeachGroups:
				parseGroups(row.get(i));
				break;
			case DaysOff:
				parseDaysOff(row.get(i));
			default:
				break;
			}

		}
	}

	public void parseDaysOff(String string) {
		String[] dayOff = string.split(PRIMARY_SEPARATOR);
		for (String str : dayOff) {
			try {
				daysOff.add(Integer.parseInt(str));
			} catch (NumberFormatException e) {
				ValidationUtil.addError(this, SchedulerResource
						.getTextFor("NotANumber")
						+ " (DayOff)");
			}
		}

	}

	public void parseGroups(String string) {
		String[] subjectGroup = string.trim().split(SECONDARY_SEPARATOR);

		for (String groups : subjectGroup) {
			String[] groupsArr = groups.split(PRIMARY_SEPARATOR);
			List<String> list = new ArrayList<String>();
			for (String group : groupsArr) {
				list.add(group.trim());
			}
			canTeachGroups.add(list);

		}

	}

	public void parseSubjectCodes(String string) {
		subjectCodes.clear();
		String[] subjSplit = string.split(PRIMARY_SEPARATOR);
		for (String str : subjSplit) {
			subjectCodes.add(str.trim());
		}

	}

	public void parseHours(String string) {
		hours.clear();
		String[] hourSplit = string.split(PRIMARY_SEPARATOR);
		for (String str : hourSplit) {
			try {
				hours.add(Integer.parseInt(str));
			} catch (NumberFormatException e) {
				ValidationUtil.addError(this, SchedulerResource
						.getTextFor("NotANumber")
						+ " (Hours)");
			}
		}

	}

	public void parseRooms(String string) {
		rooms.clear();
		String[] subjectRooms = string.trim().split(SECONDARY_SEPARATOR);

		for (String subjectRoom : subjectRooms) {
			String[] roomArr = subjectRoom.split(PRIMARY_SEPARATOR);
			List<String> list = new ArrayList<String>();
			for (String room : roomArr) {
				list.add(room.trim());
			}
			rooms.add(list);

		}
	}

	public void setName(String string) {
		fullName = string;

	}

	public void parseSubjects(String string) {
		subjects.clear();
		String[] subjSplit = string.split(PRIMARY_SEPARATOR);
		for (String str : subjSplit) {
			subjects.add(str.trim());
		}

	}

	public void validate() {
		if (validated)
			return;

		if (subjectCodes.isEmpty()) {
			ValidationUtil.addError(this, SchedulerResource
					.getTextFor("TeacherNoSubjectCodes"));
		}

		if (hours.isEmpty()) {
			ValidationUtil.addError(this, SchedulerResource
					.getTextFor("TeacherNoHours"));
		}
		if (canTeachGroups.isEmpty()) {
			ValidationUtil.addError(this, SchedulerResource
					.getTextFor("TeacherNoCanTeachGroups"));
		}

		int count = subjectCodes.size();

		if (hours.size() != count) {
			ValidationUtil.addError(this, SchedulerResource
					.getTextFor("TeacherHoursCountMissmatch"));
		}

		if (canTeachGroups.size() != count) {
			ValidationUtil.addError(this, SchedulerResource
					.getTextFor("TeacherCanTeachCountMissmatch"));
		}

		if (subjects.size() != count) {
			ValidationUtil.addWarning(this, SchedulerResource
					.getTextFor("TeacherSubjectsCountMissmatch"));
		}

	}

	public String getFullName() {
		return fullName;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public List<List<String>> getRooms() {
		return rooms;
	}

	public List<Integer> getHours() {
		return hours;
	}

	public List<String> getSubjectCodes() {
		return subjectCodes;
	}

	public List<List<String>> getCanTeachGroups() {
		return canTeachGroups;
	}

}
