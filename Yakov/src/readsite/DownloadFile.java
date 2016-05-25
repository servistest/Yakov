package readsite;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class DownloadFile {

	public static void main(String[] args) {
		
		try {
			URL url =new URL("http://st1.zv.fm/music/7/37/detskie_pesni_-_uchat_v_shkole_(zvukoff.ru).mp3");
			URLConnection urlConn=url.openConnection() ;
			try (
				InputStreamReader inputStreamReader=new InputStreamReader(urlConn.getInputStream());
				FileOutputStream fileOutputStream =new FileOutputStream("sonce.mp3"); 
			){
				int data;
				System.out.println("Download mp3 :");
				while((data=inputStreamReader.read())>-1){
					fileOutputStream.write(data);
				}
				System.out.println("Download sonce.mp3  complet ...");
				
			}
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
		
		

	}

}
