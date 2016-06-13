package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;




/**
 * Servlet implementation class FindBookSocket
 */
@WebServlet(
		urlPatterns={"/Find","/FindBook2"},
		asyncSupported=true,
		name="FindBookSocket",
		description="My first Socket"
		)
@WebListener
public class FindBookSocket extends HttpServlet implements HttpSessionListener {
	static PrintWriter out;
	 
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
    private static void addBookToCart(HttpSession session,HttpServletRequest request){
    	
    	ArrayList<Book> myShopingCart=(ArrayList<Book>)session.getAttribute("myShopingCart");
		if (myShopingCart==null){
			myShopingCart=new ArrayList<>();
		}
    	Book book=new Book();
		book.setName(request.getParameter("name"));
		book.setPrice(Double.parseDouble(request.getParameter("price")));	
		myShopingCart.add(book);
		session.setAttribute("myShopingCart", myShopingCart);
		printBookInCart(myShopingCart);
		
    	
    }
    private static void printBookInCart(ArrayList<Book> myShopingCart){
    	for(int i=0;i<myShopingCart.size();i++){
			//out.append((myShopingCart.get(i)).toString());
			out.append(" i = "+i);
			Book tempBook=myShopingCart.get(i);
			out.append(" Name Book =" + tempBook.getName()+" Price book = "+tempBook.getPrice());
		}
    }
    private void createCookies(HttpServletRequest request, HttpServletResponse response) {
    	Cookie cookie=new Cookie(request.getParameter("name"),request.getParameter("pice"));
    	cookie.setMaxAge(24*24*10);
    	response.addCookie(cookie);
		
	}
    private void printCookies(HttpServletRequest request, HttpServletResponse response) {
    	
    		Cookie[] cookies=request.getCookies();
    		if(cookies!=null){
    			for(int i=0;i<cookies.length;i++){	
        			out.append(cookies[i].getName()+" = "+cookies[i].getValue());
        		}
    		}else{
    			out.append("Cookies = null");
    		}

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		out=response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session=request.getSession(true);
		out.append(" Counter= "+prepareSessionCounter(session));
		addBookToCart(session,request);
		createCookies(request, response);
		printCookies(request, response);
		out.close();
	//	request.getSession().invalidate();
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		HttpSession session=arg0.getSession();
		System.out.println(" Session active id= "+session.getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		HttpSession session=arg0.getSession();
		System.out.println("Close session id = "+session.getId());
	}

}
