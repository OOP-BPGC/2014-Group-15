package eWalletWebApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddToDB {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void addToUSER(String fname,String lname,String email,String uname,String pwd,String status) throws ClassNotFoundException{
		try{
			//System.out.println("i am in addtouser");
			Class.forName("com.mysql.jdbc.Driver");
	        Connection conn = DriverManager.getConnection(DBconf.DB_URL,DBconf.DB_User, DBconf.DB_Pass);
	        PreparedStatement stmt = null;
		       String sql = "insert into users values(?,?,?,?,?,?,0)";
		       stmt = conn.prepareStatement(sql);
		       stmt.setString(1, fname);
		       stmt.setString(2, lname);
		       stmt.setString(3, email);
		       stmt.setString(4, uname);
		       stmt.setString(5, pwd);
		      stmt.setString(6, status);
		       stmt.execute();
		       stmt.close();
		       conn.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}

}