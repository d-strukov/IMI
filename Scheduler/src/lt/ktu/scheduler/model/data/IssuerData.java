package lt.ktu.scheduler.model.data;

import java.util.ArrayList;
import java.util.List;

public class IssuerData {

	protected String groupName;
	protected String fullName;
	protected List<String> jobs;

	public IssuerData() {
		groupName = "";
		fullName = "";
		jobs = new ArrayList<String>();
	}

	/**
	 * 
	 * @param row
	 *            list of columns
	 *            [[Sequence][Name][subject1]...[subjectN][totalCount] ]
	 */
	public IssuerData(List<String> row) {
		this();

		for (int i = 0; i < row.size(); i++) {

			if (i == 0) {
				continue;
			}

			if (i == 1) {
				setFullName(row.get(i));
				continue;
			}

			if (i < row.size() - 1) {
				jobs.add(row.get(i));
			}

		}

	}

	private void setFullName(String string) {
		// TODO Auto-generated method stub

	}

}
