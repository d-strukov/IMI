package lt.ktu.dstrukov.schoolscheduler.model;

public class Penalties {
	
	//Penalties
	private int teacherWindows;
	private int studentWindows;
	private int teacherAtDayOff;
	private int teacherLessonOvertime;
	private int studentLessonOvertime;
	
	private int jobNotScheduled;
	
	
	// Constants
	private int teacherMaxLessonsPerPeriode;
	private int studentMaxLessonsPerPeriode;
	
	public Penalties(){}
	
	
	public int getTeacherWindows() {
		return teacherWindows;
	}
	public void setTeacherWindows(int teacherWindows) {
		this.teacherWindows = teacherWindows;
	}
	public int getStudentWindows() {
		return studentWindows;
	}
	public void setStudentWindows(int studentWindows) {
		this.studentWindows = studentWindows;
	}
	public int getTeacherAtDayOff() {
		return teacherAtDayOff;
	}
	public void setTeacherAtDayOff(int teacherAtDayOff) {
		this.teacherAtDayOff = teacherAtDayOff;
	}
	public int getTeacherLessonOvertime() {
		return teacherLessonOvertime;
	}
	public void setTeacherLessonOvertime(int teacherLessonOvertime) {
		this.teacherLessonOvertime = teacherLessonOvertime;
	}
	public int getStudentLessonOvertime() {
		return studentLessonOvertime;
	}
	public void setStudentLessonOvertime(int studentLessonOvertime) {
		this.studentLessonOvertime = studentLessonOvertime;
	}
	public int getJobNotScheduled() {
		return jobNotScheduled;
	}
	public void setJobNotScheduled(int jobNotScheduled) {
		this.jobNotScheduled = jobNotScheduled;
	}
	public int getTeacherMaxLessonsPerPeriode() {
		return teacherMaxLessonsPerPeriode;
	}
	public void setTeacherMaxLessonsPerPeriode(int teacherMaxLessonsPerPeriode) {
		this.teacherMaxLessonsPerPeriode = teacherMaxLessonsPerPeriode;
	}
	public int getStudentMaxLessonsPerPeriode() {
		return studentMaxLessonsPerPeriode;
	}
	public void setStudentMaxLessonsPerPeriode(int studentMaxLessonsPerPeriode) {
		this.studentMaxLessonsPerPeriode = studentMaxLessonsPerPeriode;
	}
	
	
	
	

}
