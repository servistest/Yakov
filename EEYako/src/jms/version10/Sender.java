package jms.version10;
import javax.jms.*;
import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.ConnectionConfiguration;


public class Sender {
 public static void main(String[] args){
	 Session session=null;
	 ConnectionFactory connectionFactory;
	 QueueConnection queueConnection=null;
	 
	 try{
	      connectionFactory = new com.sun.messaging.ConnectionFactory();  
	      connectionFactory.setProperty(ConnectionConfiguration.imqAddressList, "mq://127.0.0.1:7676,mq://127.0.0.1:7676");
	      queueConnection = connectionFactory.createQueueConnection("admin","admin");
	      
	      queueConnection.start();

	      session = queueConnection.createQueueSession( 
	                          false, Session.AUTO_ACKNOWLEDGE);
	      Queue queue = session.createQueue("TestQueue");
	      MessageProducer messageProducer = session.createProducer(queue);
	      
	      // Buy 200 shares of IBM at market price	      
	      TextMessage message = session.createTextMessage("IBM 121200 Mkt");
	     
	      messageProducer.send(message);
	      messageProducer.close();
	      
	      System.out.println("Sucsess send  200 shares of IBM");
	    }
	    catch (JMSException e){
	           System.out.println("Error: " + e.getMessage());
	    } 
	    finally{
	       try{
	          session.close();
	          queueConnection.close();
	       } catch (Exception e) {
	          System.out.println("Can’t close JMS connection/session " + e.getMessage());
	      }
	    }	
}	
	
}
