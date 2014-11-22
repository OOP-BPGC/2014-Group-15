package eWalletWebApp;
import java.io.IOException;

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
@WebServlet("/payment")
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("rUserName");
		double amount=Double.valueOf(request.getParameter("amount"));
		HttpSession session=request.getSession();
		User custom=(User) session.getAttribute("currentUser1");
		
		try{
		if(custom.transferMoney(name,amount))
			response.sendRedirect("paymentSuccess.jsp");
		else
			response.sendRedirect("paymentFailure.jsp");
		
		}catch(Exception e){
			e.printStackTrace();
		}		
	}

	
}