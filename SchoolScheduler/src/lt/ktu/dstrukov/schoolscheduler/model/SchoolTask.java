package lt.ktu.dstrukov.schoolscheduler.model;

import lt.ktu.dstrukov.scheduler.model.Task;

public class SchoolTask  extends Task {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7186380821240555241L;
	
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	

}
