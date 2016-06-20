package jms.version10;

import javax.jms.*;
import javax.naming.*;


public class MessageReciever implements MessageListener{
 
    void recieveMessage(){
	 Session session=null;
	 ConnectionFactory factory=null;
	 Connection connection=null;
	 
	 try{  
	      // Find the JNDI context
	      Context jndiContext = new InitialContext();
	      // Look up the factory and the queue
	      factory = (ConnectionFactory) jndiContext.lookup("jms/QCF1");
	      Queue ioQueue = (Queue) jndiContext.lookup("jms/MyQueue");
	      
	      connection = factory.createConnection();
	
	      connection.start();

	      session = connection.createSession( 
	                          false, Session.AUTO_ACKNOWLEDGE);
	      MessageConsumer consumer=session.createConsumer(ioQueue);
	      consumer.setMessageListener(this);
	      Thread.sleep(10000);
	      System.out.println("Recieve message..");
	    }
	    catch (JMSException | NamingException e){
	           System.out.println("Error: " + e.getMessage());
	   
	    } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
	       try{
	          session.close();
	          connection.close();
	       } catch (Exception e) {
	          System.out.println("Can’t close JMS connection/session " + e.getMessage());
	      }
	    }	
}	
	
//    public static void	main(String[] args) {
//    	MessageReciever messageReciever=new MessageReciever();
//    	messageReciever.recieveMessage();
//    }

    @Override
    public void onMessage(Message message) {
    	
				try {
					if (message instanceof TextMessage){
						String msg = ((TextMessage) message).getText();
						System.out.println("Recieve message = " +msg);
					}else {
				    		System.out.println("No text message ..");
					}
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
     		
    	}
    	
   	
    }




