package io;


import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class BufferOutput {

	public static void main(String[] args) {
		String adres=new String("Sovetsk , f50");
		try (FileOutputStream file =new FileOutputStream("out1.txt");
			 OutputStreamWriter outputStreamWriter =new OutputStreamWriter(file, "UTF-8");	
			 BufferedWriter output=new BufferedWriter(outputStreamWriter)	
			){
			output.write(adres);
			
		}catch (IOException e) {
			System.out.println(e.getMessage());
			
		}

	}

}
