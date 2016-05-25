package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputTest {

	public static void main(String[] args) throws IOException {
		FileInputStream myFile=null;
		try{
			myFile=new FileInputStream("charFile2.txt");
			Boolean eof=false;
			while(!eof){
				int byteValue=myFile.read();
				if (byteValue==-1){
					eof=true;
					continue;
				}
				System.out.println((char)byteValue + " ");
			}
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}finally {
			try {
				myFile.close();
			}catch(IOException e){
				System.out.println(e.getMessage());
			}
		}
		
		
		//Read for keyboard
/*		System.out.println("Enter symbol:");
		byte buffer[]=new byte[30];
		for (int i =0;i<20;i++){
			
			buffer[i]=(byte)System.in.read();
		}
*/			
		//Write to file	
		int value[]={51,52,57,58,59,61}; 
		FileOutputStream myFileWrite=null;
		try {
			myFileWrite =new FileOutputStream("charFile2.txt");
			for(int i=0;i<value.length;i++){
				myFileWrite.write(value[i]);
				
			}
			
			//myFileWrite.close();
			
			}catch(IOException e){
				System.out.println(e.getMessage());
			}finally {
					try {
						myFileWrite.close();
					}catch(IOException e){
						System.out.println(e.getMessage());
					}
		}
	}
}	
	
	
	
