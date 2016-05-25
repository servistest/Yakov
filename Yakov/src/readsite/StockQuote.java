package readsite;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.StringTokenizer;
public class StockQuote {
	
	public static void printStockQuote(String symbol){
	
		String finance=null;
		try {
			URL url =new URL("http://quote.yahoo.com/d/quotes.csv?s=" +symbol + "&f=sl1d1t1c1ohgv&e=.csv");
			URLConnection urlCon=url.openConnection();
			try (
					InputStreamReader inputStreamReader=new InputStreamReader(urlCon.getInputStream());
					BufferedReader buffer=new BufferedReader(inputStreamReader);
				
			){
				finance=buffer.readLine();
			
			}
			
			StringTokenizer parsingFinance=new StringTokenizer(finance,",");
			String nameOrganization=parsingFinance.nextToken();
			String price=parsingFinance.nextToken();
			String date=parsingFinance.nextToken();
			String time=parsingFinance.nextToken();
			System.out.println("Name="+nameOrganization+" price="+price+" date= " + date + " time="+time );
			
				
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		if (args[0]!=null){
			String symbol=args[0];
			printStockQuote(symbol);
		}
	}
	
	
}
