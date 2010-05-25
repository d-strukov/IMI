package lt.ktu.dstrukov.frontend.beans;

public class DataBean {

	private int iterationCount = 10;
	private int studentPenalty = 100;
	private int teacherPenalty = 10;
	private int teacherOffPenalty = 10;
	private int hourOverflowPenalty = 10;

	public int getIterationCount() {
		return iterationCount;
	}

	public void setIterationCount(int iterationCount) {
		this.iterationCount = iterationCount;
	}

	public int getStudentPenalty() {
		return studentPenalty;
	}

	public void setStudentPenalty(int studentPenalty) {
		this.studentPenalty = studentPenalty;
	}

	public int getTeacherPenalty() {
		return teacherPenalty;
	}

	public void setTeacherPenalty(int teacherPenalty) {
		this.teacherPenalty = teacherPenalty;
	}

	public int getTeacherOffPenalty() {
		return teacherOffPenalty;
	}

	public void setTeacherOffPenalty(int teacherOffPenalty) {
		this.teacherOffPenalty = teacherOffPenalty;
	}

	public int getHourOverflowPenalty() {
		return hourOverflowPenalty;
	}

	public void setHourOverflowPenalty(int hourOverflowPenalty) {
		this.hourOverflowPenalty = hourOverflowPenalty;
	}

}
