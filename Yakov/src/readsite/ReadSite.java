package readsite;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class ReadSite {

	public static void main(String[] args) {
		URL url=null;
		URLConnection urlConn=null;
		InputStreamReader inputStreamReader=null;
		BufferedReader buffer=null;
		
		
		String strGoogle=new String();
		try	{
			url = new URL("http://google.com");
			urlConn=url.openConnection(); 
			inputStreamReader=new InputStreamReader(urlConn.getInputStream(), "Windows-1251");
			buffer=new BufferedReader(inputStreamReader);
			String str=null;
			while((str=buffer.readLine())!=null){
				strGoogle=strGoogle+str;
				System.out.println(str);
											
			}
			writeToFile(strGoogle);
			
		}catch(Exception e){
			
			System.out.println(e.getMessage());
			
		}finally {
			try{
				inputStreamReader.close();
				buffer.close();
			}catch(IOException e){
				System.out.println("Cant close coonection" + e.getMessage());
			}
		
			
		}

	}
	 public static void writeToFile(String str) {
		 
		 	try(
		 		FileOutputStream file =new FileOutputStream("google.html");
		 		OutputStreamWriter outputWriter =new OutputStreamWriter(file, "UTF-8");
		 		BufferedWriter buffer=new BufferedWriter(outputWriter);
		 	){
		 		buffer.write(str);
		 		
		 	}catch(IOException e){
		 		System.out.println(e.getMessage());
		 	}
	}

}
