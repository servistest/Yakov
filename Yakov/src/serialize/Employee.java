package serialize;

import java.io.Serializable;

public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String FirstName;
	public String lastName;
	transient public Integer salary;
	
	

}
