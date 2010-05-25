package lt.ktu.dstrukov.schoolscheduler.model;

import java.io.Serializable;

/**
 * @author  Denis
 */
public class Penalties implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4275376610440953653L;
	
	
	//Penalties
	/**
	 * @uml.property  name="teacherWindows"
	 */
	private int teacherWindows;
	/**
	 * @uml.property  name="studentWindows"
	 */
	private int studentWindows;
	/**
	 * @uml.property  name="teacherAtDayOff"
	 */
	private int teacherAtDayOff;
	/**
	 * @uml.property  name="teacherLessonOvertime"
	 */
	private int teacherLessonOvertime;
	/**
	 * @uml.property  name="studentLessonOvertime"
	 */
	private int studentLessonOvertime;
	
	/**
	 * @uml.property  name="jobNotScheduled"
	 */
	private int jobNotScheduled;
	
	
	// Constants
	/**
	 * @uml.property  name="teacherMaxLessonsPerPeriode"
	 */
	private int teacherMaxLessonsPerPeriode;
	/**
	 * @uml.property  name="studentMaxLessonsPerPeriode"
	 */
	private int studentMaxLessonsPerPeriode;
	
	public Penalties(){
		teacherWindows = 1;
		studentWindows = 100;
		
		teacherAtDayOff = 1;
		teacherLessonOvertime =1;
		studentLessonOvertime =1;
		
		jobNotScheduled=1;
		
	}
	
	
	/**
	 * @return
	 * @uml.property  name="teacherWindows"
	 */
	public int getTeacherWindows() {
		return teacherWindows;
	}
	/**
	 * @param teacherWindows
	 * @uml.property  name="teacherWindows"
	 */
	public void setTeacherWindows(int teacherWindows) {
		this.teacherWindows = teacherWindows;
	}
	/**
	 * @return
	 * @uml.property  name="studentWindows"
	 */
	public int getStudentWindows() {
		return studentWindows;
	}
	/**
	 * @param studentWindows
	 * @uml.property  name="studentWindows"
	 */
	public void setStudentWindows(int studentWindows) {
		this.studentWindows = studentWindows;
	}
	/**
	 * @return
	 * @uml.property  name="teacherAtDayOff"
	 */
	public int getTeacherAtDayOff() {
		return teacherAtDayOff;
	}
	/**
	 * @param teacherAtDayOff
	 * @uml.property  name="teacherAtDayOff"
	 */
	public void setTeacherAtDayOff(int teacherAtDayOff) {
		this.teacherAtDayOff = teacherAtDayOff;
	}
	/**
	 * @return
	 * @uml.property  name="teacherLessonOvertime"
	 */
	public int getTeacherLessonOvertime() {
		return teacherLessonOvertime;
	}
	/**
	 * @param teacherLessonOvertime
	 * @uml.property  name="teacherLessonOvertime"
	 */
	public void setTeacherLessonOvertime(int teacherLessonOvertime) {
		this.teacherLessonOvertime = teacherLessonOvertime;
	}
	/**
	 * @return
	 * @uml.property  name="studentLessonOvertime"
	 */
	public int getStudentLessonOvertime() {
		return studentLessonOvertime;
	}
	/**
	 * @param studentLessonOvertime
	 * @uml.property  name="studentLessonOvertime"
	 */
	public void setStudentLessonOvertime(int studentLessonOvertime) {
		this.studentLessonOvertime = studentLessonOvertime;
	}
	/**
	 * @return
	 * @uml.property  name="jobNotScheduled"
	 */
	public int getJobNotScheduled() {
		return jobNotScheduled;
	}
	/**
	 * @param jobNotScheduled
	 * @uml.property  name="jobNotScheduled"
	 */
	public void setJobNotScheduled(int jobNotScheduled) {
		this.jobNotScheduled = jobNotScheduled;
	}
	/**
	 * @return
	 * @uml.property  name="teacherMaxLessonsPerPeriode"
	 */
	public int getTeacherMaxLessonsPerPeriode() {
		return teacherMaxLessonsPerPeriode;
	}
	/**
	 * @param teacherMaxLessonsPerPeriode
	 * @uml.property  name="teacherMaxLessonsPerPeriode"
	 */
	public void setTeacherMaxLessonsPerPeriode(int teacherMaxLessonsPerPeriode) {
		this.teacherMaxLessonsPerPeriode = teacherMaxLessonsPerPeriode;
	}
	/**
	 * @return
	 * @uml.property  name="studentMaxLessonsPerPeriode"
	 */
	public int getStudentMaxLessonsPerPeriode() {
		return studentMaxLessonsPerPeriode;
	}
	/**
	 * @param studentMaxLessonsPerPeriode
	 * @uml.property  name="studentMaxLessonsPerPeriode"
	 */
	public void setStudentMaxLessonsPerPeriode(int studentMaxLessonsPerPeriode) {
		this.studentMaxLessonsPerPeriode = studentMaxLessonsPerPeriode;
	}
	
	
	
	

}
