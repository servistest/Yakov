package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


// !!!Автоматом закрывается сервер если не прописано в классе extends UnicastRemoteObject!!!
public class RMIServerImpl extends UnicastRemoteObject implements RMIServerI {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<String> nasdaqSymbol = new ArrayList<>();
	private String price;
	
	public RMIServerImpl() throws RemoteException {
		
		//Create Registry
		LocateRegistry.createRegistry(1099);
		//add symbol to list
		nasdaqSymbol.add("IBM");
		nasdaqSymbol.add("AAPL");
		nasdaqSymbol.add("MSFT");
		nasdaqSymbol.add("YHOO");
		nasdaqSymbol.add("AMZN");
		
	}

	@Override
	public String getPriceStock(String symbol) throws RemoteException {
		
		price=null;
		if(nasdaqSymbol.indexOf(symbol.toUpperCase())!=-1){
			price=(new Double(Math.random()*100)).toString();
			System.out.println(price);
		}
		return price;
	}

	@Override
	public ArrayList<String> getNasdaqSymbol() throws RemoteException {
		
		return nasdaqSymbol;
	}

	
	
}
