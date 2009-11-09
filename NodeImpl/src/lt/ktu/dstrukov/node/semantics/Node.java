package lt.ktu.dstrukov.node.semantics;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import lt.ktu.dstrukov.central.interfaces.ICentral;
import lt.ktu.dstrukov.commons.OptimizationParameters;
import lt.ktu.dstrukov.commons.Result;
import lt.ktu.dstrukov.node.interfaces.INode;
import lt.ktu.dstrukov.optimizator.Optimizator;
import lt.ktu.dstrukov.optimizator.listeners.OptimizationProcesListener;

public class Node extends UnicastRemoteObject implements INode {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6144504104518364063L;
	private NodeContainer container;
	private int id = -1;

	public Node(NodeContainer c) throws RemoteException {
		super();
		container = c;
	}

	@Override
	public void startProcess() throws RemoteException {

		Thread th = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					final ICentral central = container.getCentral();
					OptimizationParameters params = central
							.getOptimizationParameters();
					Object data = central.getData();

					final Optimizator opt = new Optimizator(data, params);

					opt.start(new OptimizationProcesListener() {

						@Override
						public void onIterationStart() {

						}

						@Override
						public void onIterationComplete(Result res) {
							try {
								central.addResult(id, res);
							} catch (RemoteException e) {
								e.printStackTrace();
							}

						}

						@Override
						public void onBeforeOptimization() {

						}

						@Override
						public void onAfterOptimization() {

						}
					});

				} catch (RemoteException e) {
				}
			}
		});
		th.start();
	}

	@Override
	public void ping() throws RemoteException {
		// Do nothing
	}

	@Override
	public void assignId(int id) throws RemoteException {
		System.out.println("Got ID: " + id);
		this.id = id;

	}

}
