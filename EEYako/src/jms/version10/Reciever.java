package jms.version10;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.sun.messaging.ConnectionConfiguration;


public class Reciever implements MessageListener{
	
	 com.sun.messaging.ConnectionFactory connectionFactory;
	 QueueConnection queueConnection=null;
	 MessageConsumer messageConsumer=null;
	
	  Reciever() {
		
		try {
			connectionFactory =new com.sun.messaging.ConnectionFactory();
			connectionFactory.setProperty(ConnectionConfiguration.imqAddressList, "mq://localhost:7676,mq://localhost:7676");
			queueConnection =connectionFactory.createQueueConnection("admin", "admin");
			queueConnection.start();
	
			Session session=queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue queue =session.createQueue("TestQueue");
			messageConsumer=session.createConsumer(queue);
			messageConsumer.setMessageListener(this);
			System.out.println("Listening TestQueue...");
			Thread.sleep(10000);
			
		} catch (JMSException | InterruptedException e) {
		
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new Reciever();
	}

	@Override
	public void onMessage(Message message) {
		String msg;
		try {
			if(message instanceof TextMessage){
				msg= ((TextMessage)message).getText();
				System.out.println("Message reciever = " + msg);
			}else {
				System.out.println("Is not text message reciever...");
			}
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
		
	}

}
