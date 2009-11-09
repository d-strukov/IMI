package lt.ktu.dstrukov.central;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

import javax.swing.JButton;
import javax.swing.JFrame;

import lt.ktu.dstrukov.central.semantics.Central;

public class Main {

	private static Central central;

	public static void main(String[] args) {

		try {
			central = new Central();
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		if (central == null)
			return;

		JFrame app = new JFrame();
		app.setSize(new Dimension(100, 100));
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		app.setTitle("");

		JButton btnAddNode = new JButton("Start Nodes");
		btnAddNode.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					central.startAllNodes();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		app.getContentPane().add(btnAddNode);
		app.setVisible(true);

	}

}
