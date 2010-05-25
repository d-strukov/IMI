package lt.ktu.dstrukov.scheduler.model;

/**
 * @author   Denis
 */
public enum Action {
	/**
	 * @uml.property  name="fatal"
	 * @uml.associationEnd  
	 */
	Fatal,
	/**
	 * @uml.property  name="ignore"
	 * @uml.associationEnd  
	 */
	Ignore,
	/**
	 * @uml.property  name="skipFrame"
	 * @uml.associationEnd  
	 */
	SkipFrame,
	/**
	 * @uml.property  name="skipPeriode"
	 * @uml.associationEnd  
	 */
	SkipPeriode,
	/**
	 * @uml.property  name="skipTask"
	 * @uml.associationEnd  
	 */
	SkipTask

}
