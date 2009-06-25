package lt.ktu.dstrukov.control;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import lt.ktu.dstrukov.central.interfaces.ICentral;
import lt.ktu.dstrukov.commons.Result;
import lt.ktu.dstrukov.node.interfaces.INode;

public class Main {
public static void main(String[] args) {

		
		try {
			
			String[] list = Naming.list("rmi://localhost:1099/");
			for(String s : list){
				System.out.println(s);
			}
			ICentral o = (ICentral)Naming.lookup("rmi://localhost:1099/CentralSvc");
			System.out.println(o.getPathToData());
			
			
			INode n = (INode)Naming.lookup("rmi://localhost:1099/NodeSvc");
			n.startProcess(o);
			
			while(o.isBusy()) continue;
			
			List<Result> res = o.getResults();
			for(Result r : res){
				System.out.println(r.getResultString());
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
