package eWalletWebApp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrationServlet() {
        super();
       }
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("userName");   
	    String pwd = request.getParameter("password");
	    String repwd = request.getParameter("repassword");
	    if(!pwd.equals(repwd)){
	    	response.sendRedirect("regpwdfail.jsp");
	    	return;
	    }
	    		
	    String fname = request.getParameter("firstName");
	    String lname = request.getParameter("lastName");
	    String email = request.getParameter("email");

	    String status = request.getParameter("status");
	    final Pattern p1 = Pattern.compile("\\b[sS]mall[Tt]alk\\b");
	    Matcher m1 = p1.matcher(email);
	    if(!m1.find())
	    {
	    	response.sendRedirect("regemailfail.jsp");
	    	return;
	    }Statement s=null;
		Connection con=null;
		ResultSet rs=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con= DriverManager.getConnection(DBconf.DB_URL,DBconf.DB_User, DBconf.DB_Pass);
				s=con.createStatement();
				System.out.println("here");
				String str="SELECT * from users where userName='"+user+"' or email='"+email+"'";
				rs=s.executeQuery(str);
				if(rs.next()){
					response.sendRedirect("regunamefail.jsp");
					return;
				}
			}catch(Exception e){}
		
//	    response.setContentType("text/html");
 
		try {
			eWalletWebApp.AddToDB.addToUSER(fname,lname,email,user,pwd,status);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		 
		String address="RegSuccess.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(address);
		dispatcher.forward(request,response);
				
	}

	
	

}