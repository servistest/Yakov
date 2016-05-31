package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RMIServerI extends Remote{

	public String  getPriceStock(String symbol) throws RemoteException;
	
	public ArrayList<String> getNasdaqSymbol() throws RemoteException;
}
