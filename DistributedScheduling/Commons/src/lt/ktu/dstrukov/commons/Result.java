package lt.ktu.dstrukov.commons;

import java.io.Serializable;

public class Result implements Serializable{

	private String resultString ="";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3671989907381290868L;

	public Result() {
		// TODO Auto-generated constructor stub
	}

	public Result(String res) {
		resultString = res;
	}
	
	public String getResultString(){
		return resultString;
	}

	
}
