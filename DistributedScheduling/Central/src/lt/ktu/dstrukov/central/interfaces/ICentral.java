package lt.ktu.dstrukov.central.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import lt.ktu.dstrukov.commons.OptimizationParameters;
import lt.ktu.dstrukov.commons.Result;

public interface ICentral extends Remote {

	/***
	 * Sets path to data. (http, db?)
	 * 
	 * @param path
	 * @throws RemoteException
	 */
	public void setPathToData(String path) throws RemoteException;

	/***
	 * ???? IDEA:Maybe allow local data replication. return keyword "LOCAL" if
	 * file is predistributed????
	 * 
	 * @return path to data
	 * @throws RemoteException
	 */
	public String getPathToData() throws RemoteException;

	public void setData(Object data) throws RemoteException;

	public Object getData() throws RemoteException;

	public void setOptimizationParameters(OptimizationParameters params)
			throws RemoteException;

	public OptimizationParameters getOptimizationParameters()
			throws RemoteException;

	public void addResult(int nodeId, Result res) throws RemoteException;

	public List<Result> getResults(int nodeId) throws RemoteException;

	public void setStarted() throws RemoteException;

	public boolean isBusy() throws RemoteException;

	public void registerNode(String nodeAddress) throws RemoteException;

	public void startAllNodes() throws RemoteException;

}
