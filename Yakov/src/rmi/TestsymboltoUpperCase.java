package rmi;

import java.util.ArrayList;

public class TestsymboltoUpperCase {
	
	public static ArrayList<String> nasdaqSymbol=new ArrayList<>();
	static String name="IBM2";
	
	public static void main(String[] args) {
		nasdaqSymbol.add("IBM");
		nasdaqSymbol.add("AAPL");
		nasdaqSymbol.add("MSFT");
		nasdaqSymbol.add("YHOO");
		nasdaqSymbol.add("AMZN");
		
		if (nasdaqSymbol.indexOf(name)!=-1){
			System.out.println("true");
			
		}else{
			System.out.println("false");
		}
	}
}
