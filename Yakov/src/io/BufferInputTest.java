package io;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class BufferInputTest {
	
	public static void main(String[] args) {
	
		StringBuffer str=new StringBuffer();
		try (
				FileInputStream file= new FileInputStream("file1.txt");
				InputStreamReader inputStreamReader=new InputStreamReader(file,"UTF-8");
				BufferedReader reader=new BufferedReader(inputStreamReader);
		
			){
			 int ch;
			 while((ch=reader.read())>-1){
				  str.append(ch);
				//System.out.println((char)ch);
			 }
			 System.out.println(str.toString());
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		

		
		try (
				FileInputStream file= new FileInputStream("file1.txt");
				InputStreamReader inputStreamReader=new InputStreamReader(file,"UTF-8");
				BufferedReader reader=new BufferedReader(inputStreamReader);
			){
			
			 String str2=null;
			 while((str2=reader.readLine())!=null){
				 System.out.println(str2);
			
			 }
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		
		

	}

}
