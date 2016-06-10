package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.corba.se.impl.orb.ParserTable.TestAcceptor1;
import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.Static;

/**
 * Servlet implementation class FindBookSocket
 */
@WebServlet(
		urlPatterns={"/Find","/FindBook2"},
		asyncSupported=true,
		name="FindBookSocket",
		description="My first Socket"
		)
public class FindBookSocket extends HttpServlet implements Serializable {
	 
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindBookSocket() {
        super();
        // TODO Auto-generated constructor stub
    }

    private static int prepareSessionCounter(	HttpSession session) {
    		Integer counter =		(Integer)session.getAttribute("counter");
    		if (counter == null) {
    			session.setAttribute("counter", 1);
    		return 1;
    		} else {
    			counter++;
    			session.setAttribute("counter", counter);
    			return counter;
    		}
    		
   }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session=request.getSession(true);
		
		Integer kol =(Integer)session.getAttribute("kol");
		if(kol==null){
			session.setAttribute("kol", 1);
			out.append(" Koliczestwo= "+kol);
			kol=1;
		}else{
			kol++;
			session.setAttribute("kol", kol);
			out.append(" Koliczestwo= " + kol);
		}

		out.append(" Counter= "+prepareSessionCounter(session));
		
		ArrayList<Book> myShopingCart=(ArrayList<Book>)session.getAttribute("myshopingCart");
		if (myShopingCart==null){
			myShopingCart=new ArrayList<>();
		}
		
		Book book=new Book();
		book.setName(request.getParameter("name"));
		book.setPrice(Double.parseDouble(request.getParameter("price")));	
		myShopingCart.add(book);
		session.setAttribute("myShopingCart", myShopingCart);
		
		//print parameters
		out.append(" Session id= "+session.getId());
		out.append(" name= " +request.getParameter("name"));
		out.append(" price= " + request.getParameter("price"));
	
		
		for(int i=0;i<myShopingCart.size();i++){
			//out.append((myShopingCart.get(i)).toString());
			out.append(" i = "+i);
			Book tempBook=myShopingCart.get(i);
			out.append(" Name Book =" + tempBook.getName()+" Price book = "+tempBook.getPrice());
		}
	
		out.close();   
		//session.invalidate();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
