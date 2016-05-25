package io;

import java.io.BufferedReader;

import java.io.FileReader;


public class ReaderFileTest {

	public static void main(String[] args) {
		try(FileReader file=new FileReader("test2.txt");
			BufferedReader reader =new BufferedReader(file);
				
				
		){
			String str=null;
			while((str=reader.readLine())!=null){
				
				System.out.println(str);
			}
			
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
