package eWalletWebApp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
/**
 * Servlet implementation class login
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userName");    
	    String pwd = request.getParameter("password");
	    HttpSession session = request.getSession(true);
    	
    	
		    User currentUser=null;
		    String status=Login.verifyLogin(userid, pwd);
		    synchronized(session){
	   		    	switch(status){
	   			    case "customer":
	   			    {
	   			    	currentUser=
	   		    				(Customer)session.getAttribute("currentUser1");
	   		    		if(currentUser==null)
	   		    		{
	   		    			currentUser=new Customer(userid,pwd);
	   		    			session.setAttribute("currentUser1", currentUser);
	   		    			response.sendRedirect("loginsuccessC.jsp");
	   		    			
	   		    		}	
	   			    } 
	   			    //currentUser = new Customer(fname,lname,username,balance);
	   			    	 break;
	   			    case "seller":
	   			    {
	   			    	currentUser=
	   		    				(Seller)session.getAttribute("currentUser1");
	   		    		if(currentUser==null)
	   		    		{
	   		    			currentUser=new Seller(userid,pwd);
	   		    			session.setAttribute("currentUser1", currentUser);
	   		    			response.sendRedirect("loginsuccessS.jsp");
	   		    			
	   		    		}	
	   		    		
	   			    } 
	   			    break;
	   			    case "recharge":
	   			    {
	   			     currentUser=
	   		    				(RechargePerson)session.getAttribute("currentUser1");
	   		    		if(currentUser==null)
	   		    		{
	   		    			currentUser=new RechargePerson(userid,pwd);
	   		    			session.setAttribute("currentUser1", currentUser);
	   		    			response.sendRedirect("loginsuccessR.jsp");
	   		    			
	   		    		}	
	   			    } 
	   			    break;

	   		    	case "" :
	   		    		response.sendRedirect("loginfail.jsp");
   		    			break;
	    		
	   			    }

	    	}
	   		 
	    	
	   	}

}
