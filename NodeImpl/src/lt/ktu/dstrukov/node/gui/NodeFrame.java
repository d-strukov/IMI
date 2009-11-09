package lt.ktu.dstrukov.node.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import lt.ktu.dstrukov.node.listeners.NodeContainerListener;
import lt.ktu.dstrukov.node.semantics.NodeContainer;

public class NodeFrame extends JFrame implements NodeContainerListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4335813855468529275L;
	
	private JButton btnAddNode = new JButton("Create Node");
	
	private NodeContainer container = new NodeContainer();
	
	
	
	public NodeFrame() {
		
		
		this.setSize(new Dimension(400,300));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(container.getHostname());
		
		
		container.connectToCentral();
		
		
		btnAddNode.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					container.createNode();				
			}
		});
		
		JPanel mainPanel = new JPanel();
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridBagLayout());
		
		controlPanel.add(btnAddNode);
		
		this.setLayout(new BorderLayout());
		this.add(controlPanel, BorderLayout.SOUTH);
		this.add(mainPanel, BorderLayout.CENTER);
		this.setVisible(true);
	}

	@Override
	public void onCentralBound() {
		System.out.println("Found Central");
		
	}

	@Override
	public void onHostResolved(String hostname, String ip) {
		// TODO Auto-generated method stub
		
	}

}
