package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient {
	private static final String adressServer="rmi://localhost:1099/serviecesNasdaq";
	private static String price;
	public static void main(String[] args) {
		if(args.length==0){
			System.out.println("Usage policy -Djava.security.policy=security.policy ");
			System.exit(0);
		}
		
		try{
			RMIServerI rmiServer=(RMIServerI)Naming.lookup(adressServer);
			price= rmiServer.getPriceStock(args[0]);
			if(price!=null){
				System.out.println("Stoc price is " + price + "of Company symbol " + args[0] );
			}else{
				System.out.println("Not Company of symbol " + args[0] + ". Please use the " + rmiServer.getNasdaqSymbol() );
			}
			
		}catch(RemoteException e){
			System.out.println(e.getMessage());
		}catch(MalformedURLException | NotBoundException e){
			System.out.println(e.getMessage());
		}

	}

}
