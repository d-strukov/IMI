package lt.ktu.dstrukov.central.semantics;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import lt.ktu.dstrukov.central.interfaces.ICentral;
import lt.ktu.dstrukov.commons.OptimizationParameters;
import lt.ktu.dstrukov.commons.Result;

public class Central extends UnicastRemoteObject implements ICentral {

	private boolean started = false;
	private List<Result> results = new ArrayList<Result>();
	private int startedCount =0; 

	/**
	 * 
	 */
	private static final long serialVersionUID = -4873817237062835205L;

	
	private static String pathToData;

	public Central() throws RemoteException {
		super();
		
	}
	
	

	@Override
	public void addResult(Result res) throws RemoteException {
		startedCount--;
		results.add(res);
		if(startedCount==0){
			started =false;
		}

	}

	@Override
	public Object getData() throws RemoteException {
		
		return null;
	}

	@Override
	public String getPathToData() throws RemoteException {
		// TODO Auto-generated method stub
		return pathToData;
	}

	@Override
	public List<Result> getResults() throws RemoteException {
		// TODO Auto-generated method stub
		return results;
	}

	@Override
	public void setData(Object data) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPathToData(String path) throws RemoteException {
		pathToData =path;

	}

	@Override
	public OptimizationParameters getOptimizationParameters()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOptimizationParameters(OptimizationParameters params)
			throws RemoteException {
		// TODO Auto-generated method stub

	}



	@Override
	public boolean isBusy() throws RemoteException {
		// TODO Auto-generated method stub
		return started;
	}



	@Override
	public void setStarted() throws RemoteException {
		startedCount++;
		started = true;
		
	}

}
