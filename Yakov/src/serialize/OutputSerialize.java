package serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OutputSerialize {

	public static void main(String[] args) {
		Employee emp=new Employee();
		emp.FirstName="Alex";
		emp.lastName="Smirnov";
		emp.salary=100;

		try (
			FileOutputStream file=new FileOutputStream("employee.ser");
			ObjectOutputStream out=new ObjectOutputStream(file);	
		){
			out.writeObject(emp);
			
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
