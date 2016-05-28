package exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Error1 {

	Error1(){
		try {
			int n=  devideByZero();
		
		}catch (ArithmeticException e){
			System.out.println("Divide by Zero=" + e.getMessage());
		}finally {
			//JOptionPane.showInputDialog("Divide zero" );
		}
		
	
	}
		
public int devideByZero() throws ArithmeticException {
	
	try {
		FileInputStream input=new FileInputStream("test.txt");
		
		int t=input.read();
		System.out.println(t);
		input.close();
		}
	
	
	catch (IOException e){
		System.out.println("File not Found" + e.getMessage());
	}
	return(30);
}




public static void main(String[] args){
	new Error1();
}
}
