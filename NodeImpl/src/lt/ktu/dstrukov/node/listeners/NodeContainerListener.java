package lt.ktu.dstrukov.node.listeners;

public interface NodeContainerListener {

	void onHostResolved(String hostname, String ip);
	
	void onCentralBound();
}
