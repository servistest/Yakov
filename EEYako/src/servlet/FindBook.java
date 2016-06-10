package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

/**
 * Servlet implementation class FindBook
 */
@WebServlet(
		urlPatterns={"/book","/FindBook"},
		name="FindBook",
		description="My first servlet",
		asyncSupported=true
		)
public class FindBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public FindBook() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		PrintWriter out=response.getWriter();
		out.println("Test 4");
		out.append("ALL ALL ALLL " );
		
		response.getWriter().append("Served at: ").append(request.getContextPath()).append(request.getParameter("name"));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
