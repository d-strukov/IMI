package lt.ktu.dstrukov.commons;

import java.io.Serializable;

public class OptimizationParameters implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5264067406833851862L;

	private int iterationCount;

	// Penalties
	private int teacherWindows;
	private int studentWindows;
	private int teacherAtDayOff;
	private int teacherLessonOvertime;
	private int studentLessonOvertime;

	private int jobNotScheduled;

	// Constants
	private int teacherMaxLessonsPerPeriode;
	private int studentMaxLessonsPerPeriode;

	public OptimizationParameters() {
		teacherWindows = 1;
		studentWindows = 100;

		teacherAtDayOff = 1;
		teacherLessonOvertime = 1;
		studentLessonOvertime = 1;

		jobNotScheduled = 1;

		iterationCount = 100;

	}

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

	public int getIterationCount() {
		return iterationCount;
	}

	public void setIterationCount(int iterationCount) {
		this.iterationCount = iterationCount;
	}

}
