package eWalletWebApp;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Payment
 */
@WebServlet("/pay")
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("sellerUserName");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DBconf.DB_URL,DBconf.DB_User, DBconf.DB_Pass);
		    Statement st = conn.createStatement();
		    ResultSet rs;
		    rs = st.executeQuery("select * from users where userName='" + name + "' and status='seller'");
		     if(!rs.next()){
		    	 response.sendRedirect("invalidUserC.jsp");
		     }
		} catch (Exception e) {
				 //TODO Auto-generated catch block
				e.printStackTrace();
	}
		double amount=Double.valueOf(request.getParameter("amountToBePaid"));
		HttpSession session=request.getSession();
		Customer customer=(Customer) session.getAttribute("currentUser1");
//	
		try{
		if(customer.makePayment(name,amount))
			response.sendRedirect("paymentSuccess.jsp");
		else
			response.sendRedirect("paymentFailure.jsp");
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
}