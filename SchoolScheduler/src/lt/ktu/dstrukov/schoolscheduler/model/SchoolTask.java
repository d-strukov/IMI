package lt.ktu.dstrukov.schoolscheduler.model;

import lt.ktu.dstrukov.scheduler.model.Task;

/**
 * @author Denis
 */
public class SchoolTask extends Task {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7186380821240555241L;

	/**
	 * @uml.property name="code"
	 */
	private String code;

	/**
	 * @return
	 * @uml.property name="code"
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 * @uml.property name="code"
	 */
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "SchoolTask [code=" + code + "]";
	}

}
