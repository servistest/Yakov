package jms.version10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "The servlet that Sends a message to a queue", urlPatterns = { "/recieve" }, name="QuoteRecieve")
public class QuoteRecieve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get or create the session
		request.getSession(true);
		
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor=yellow>");
		out.println("<h2>Hello from QuoteRecieve</h2>");
		
		
		
		MessageReciever mySender=new MessageReciever();
		mySender.recieveMessage();
		out.println("Recieve message...");
		
		//Destroy the session
		request.getSession(true).invalidate();
	}
	
}

