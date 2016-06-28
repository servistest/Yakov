package testEJB;

import javax.ejb.Local;

@Local
public interface HelloBeanLocal {
	public String returnString();

}
