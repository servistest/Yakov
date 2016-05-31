package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class StockQuoteServer {
	private static ServerSocket serverSocket;
	private static Socket client;
	private static String messageIn;
	private static String messageOut;
	
	public static void startServer(){
		try{
			
			serverSocket=new ServerSocket(3001);
			
			while(true){
			System.out.println("Waiting for remote request:");
			client=serverSocket.accept();
			
		
				try (
						InputStreamReader inputStreamReader=new InputStreamReader(client.getInputStream());
						BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
						OutputStream outputStream=client.getOutputStream();
						
						){
					System.out.println("wait....");
					
						messageIn=bufferedReader.readLine();
						System.out.println(messageIn);
					
					System.out.println("Input messager = " + messageIn);
					messageOut=new String(Double.toString(Math.random()*100));
					System.out.println(("For company " + messageIn +" price stock = " + messageOut));
					outputStream.write(("For company " + messageIn +" price stock = " + messageOut+"\n").getBytes());
					outputStream.write(("END\n").getBytes());
					
				}
			}	
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		
	
	}

	public static void main(String[] args) {
		startServer();

	}

}
