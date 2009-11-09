package lt.ktu.dstrukov.frontend.beans;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import lt.ktu.dstrukov.central.semantics.Central;

public class CentralBean {

	private boolean centralBound = false;
	private Central central = null;

	public CentralBean() {
		try {
			central = new Central();
			centralBound = true;

		} catch (RemoteException e) {
			System.out.println("Failed to Create Central");
			e.printStackTrace();
		}
	}

	public int getNodeCount() {
		return central.getNodeCount();
	}

	public boolean getCentralBound() {
		return centralBound;
	}

	public void setCentralBound(boolean centralBound) {
		this.centralBound = centralBound;
	}

	public int getFirstValue() {

		return central.getFirstResult();
	}

	public List<Integer> getMainValues() {
		return central.getMainResults();
	}

	public void start() {
		try {
			central.startAllNodes();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Map<Integer, List<Integer>> getResultsAsInts() {
		return central.getResultsAsInts();
	}

}
