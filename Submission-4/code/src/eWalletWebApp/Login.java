package eWalletWebApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;

public class Login {
	public static String verifyLogin( String userid,String pwd){
		try {
	    	 //System.out.println(userid);	
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection conn = DriverManager.getConnection(DBconf.DB_URL,DBconf.DB_User, DBconf.DB_Pass);
       Statement st = conn.createStatement();
	    ResultSet rs;
	     rs = st.executeQuery("select * from users where userName='" + userid + "' and password='" + pwd + "'");
	    String address;
	    RequestDispatcher dispatcher;
	    if (rs.next()) {
	    	String status=rs.getString("status");
		    String email = rs.getString("email");
		    return status;
	    }
		}
	    catch (Exception e)
	    {
	    	}
		return "";
	    
		}	
}
