package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;


public class RMIServerStart {
	private static final String  adressServer="rmi://localhost:1099/serviecesNasdaq";
	
		public static void startServer() throws RemoteException {
			try {
				
				RMIServerImpl rmiServer=new RMIServerImpl();
				Naming.bind(adressServer, rmiServer);
				System.out.println("Server start and listen:");
				
			}catch(MalformedURLException | AlreadyBoundException e){
				System.out.println(e.getMessage());
			}
			
		}

	public static void main(String[] args) throws RemoteException  {
		startServer();	
	}
	

}
