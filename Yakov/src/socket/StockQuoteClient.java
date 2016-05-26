package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class  StockQuoteClient {
	private static Socket socket;
	
	public static void startClient(String nameOfCompany) {
		try {
			socket=new Socket("localhost", 3001);
			
				try(
						OutputStream outputStream =socket.getOutputStream();
						InputStreamReader inputStreamReader=new InputStreamReader(socket.getInputStream());
						BufferedReader bufferedReader=new BufferedReader(inputStreamReader);	
					){
					System.out.println("Output Name of company:" + nameOfCompany);
						outputStream.write((nameOfCompany+"\n").getBytes());
						outputStream.write(("END\n").getBytes());
						
						System.out.println("Waiting input response from server :"  );
						String response=null;
						while(true){
							response=bufferedReader.readLine();
							if("END".equals(response)){
								break;
							}	
						}
						System.out.println("Response= " + response);
					}
			
		}catch (UnknownHostException e  ){
			System.out.println(e.getMessage());
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static void main(String[] args) {
		if (args[0]!=null){
			System.out.println("Name of company is " + args[0]);
			startClient(args[0]);
			
		}else{System.out.println("Name of company not found");}
		
	}

}
