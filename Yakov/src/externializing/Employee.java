package externializing;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Employee implements Externalizable {
	public String firstName;
	public String lastName;
	public Integer salary;
	public Integer year; 

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
			firstName=in.readUTF();
			lastName=in.readUTF();
			year=in.readInt();
		
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeUTF(firstName);
		out.writeUTF(lastName);
		out.writeInt(year);
		
	}
	

}
