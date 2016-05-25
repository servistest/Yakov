package readsite;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadFile {

	public static void main(String[] args) {
		
		try {
			URL url =new URL("http://st1.zv.fm/music/7/37/detskie_pesni_-_uchat_v_shkole_(zvukoff.ru).mp3");
			URLConnection urlConn=url.openConnection() ;
			try (
				InputStream inputStream=urlConn.getInputStream();
					// !!!! При использовании InputStreamReader скачивается битый файл.!!! 
					//    Потому что он перекодирует файл в кодировку по умолчанию!!!
				FileOutputStream fileOutputStream =new FileOutputStream("sonce.mp3"); 
			){
				int data;
				System.out.println("Download mp3 :");
				while((data=inputStream.read())>-1){
					fileOutputStream.write(data);
				}
				System.out.println("Download sonce.mp3  complet ...");
				
			}
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
		
		

	}

}
