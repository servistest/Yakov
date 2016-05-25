package externializing;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OutEmployee {

	public static void main(String[] args) {
		Employee emp=new Employee();
		emp.firstName="Alex";
		emp.lastName="Smirnov";
		emp.salary=100;
		emp.year=1999;
		
	 try (FileOutputStream file=new FileOutputStream("empl.ser");
		  ObjectOutputStream out =new ObjectOutputStream(file);	 
		){
		 	out.writeObject(emp);
		 
	 }catch (IOException e) {
		System.out.println(e.getMessage());
	}

	}

}
