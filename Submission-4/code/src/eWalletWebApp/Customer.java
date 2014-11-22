package eWalletWebApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


	public class Customer extends User{
		Seller seller;
		private Offer[] offers;
		
		public Customer(String userName, String password) {
			try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DBconf.DB_URL,DBconf.DB_User, DBconf.DB_Pass);
		    Statement st = conn.createStatement();
		    ResultSet rs;
		    rs = st.executeQuery("select * from users where userName='" + userName + "' and password='" + password + "'");
		     rs.next();
			    			
			this.setFirstName(rs.getString("firstName"));
			this.setLastName(rs.getString("lastName"));
			this.setUserName(rs.getString("userName"));
			this.setEmailID(rs.getString("email"));
			this.setWallet(new Wallet(rs.getDouble("balance")));
				} catch (Exception e) {
				 //TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
		}
		public boolean makePayment(String receiver, double amount) {
			if(VirtualBank.transferMoney(receiver,this.getUserName(),this.getWallet().getBalance(),amount))
			{
				this.getWallet().setBalance(this.getWallet().getBalance()-amount);
				return true;
			}						
		else 
			return false;
		
	}
	


		
	
}

