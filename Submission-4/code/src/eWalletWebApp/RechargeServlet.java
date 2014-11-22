package eWalletWebApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RechargeServlet
 */
@WebServlet("/recharge")
public class RechargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechargeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("rUserName");
		double amount=Double.valueOf(request.getParameter("amount"));
		HttpSession session=request.getSession();
		RechargePerson rp=(RechargePerson) session.getAttribute("currentUser1");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DBconf.DB_URL,DBconf.DB_User, DBconf.DB_Pass);
		    Statement st = conn.createStatement();
		    ResultSet rs;
		    rs = st.executeQuery("select * from users where userName='" + name + "' and status='customer'");
		     if(!rs.next()){
		    	 response.sendRedirect("invalidUserR.jsp");
		     }
		} catch (Exception e) {
				 //TODO Auto-generated catch block
				e.printStackTrace();
	}
		try{
		if(rp.recharge(name,amount))
			response.sendRedirect("rechargeSuccess.jsp");
		else
			response.sendRedirect("rechargeFailure.jsp");
		
		}catch(Exception e){
			e.printStackTrace();
		}		
	}


}
