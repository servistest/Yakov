package testEJB;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloBean
 */
@Stateless
@LocalBean
public class HelloBean implements HelloBeanLocal {

    /**
     * Default constructor. 
     */
    public HelloBean() {
      
    }
    public String returnString(){
    	return "Test - OK";
    }

}
