package externializing;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;



public class InEmployee {

	public static void main(String[] args) {
		
		try (
			FileInputStream file=new FileInputStream("empl.ser");
			ObjectInputStream in= new ObjectInputStream(file);
		){
			Employee emp =(Employee)in.readObject();
			System.out.println(emp.firstName+emp.lastName+emp.salary+emp.year);
			
		}catch (IOException | ClassNotFoundException e) {
			e.getMessage();
		}

	}

}
