package serialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class InputSerialize {

	public static void main(String[] args) {
		
		try (FileInputStream file=new FileInputStream("employee.ser");
			 ObjectInputStream input =new ObjectInputStream(file);	
		){
			Employee empl=(Employee) input.readObject();
			System.out.println(empl.FirstName+" "+empl.lastName+" "+empl.salary);
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}catch (ClassNotFoundException e ) {
			System.out.println(e.getMessage());
		}
	}

}
