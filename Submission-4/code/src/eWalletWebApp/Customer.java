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
//
//
//public void makePayment(String rec,double amount){
//		
//		//System.out.println("Enter username of Seller");
//		//String rec=Driver.scanner.next();
//		//System.out.println("Enter the amount to be Transferred");
//		//double amount=Driver.scanner.nextDouble();
//		
//		if(this.wallet.getBalance()<amount){
//			System.out.println("\nInsufficient Balance\n");
//			return;
//		}
//		else{
//			System.out.println("Apply Offer? (Y/N)");
//			String op=(Driver.scanner.next());
//			if(op.equals("Y")){
//				amount=Offer.applyOffer(rec,amount);
//			}
//		}
//		Statement s=null;
//		Connection con=null;
//		ResultSet rs=null;
//			try {
//				con= DriverManager.getConnection(DBconf.DB_URL,DBconf.DB_User, DBconf.DB_Pass);
//				s=con.createStatement();
//				this.wallet.setBalance(this.wallet.getBalance()-amount);
//				s.executeUpdate("update users set balance="+this.wallet.balance+" where username='"+this.userName+"'");
//				String str="SELECT * from users where Username='"+rec+"'";
//				rs= s.executeQuery(str);
//				rs.next();
//				double tempbalance=rs.getDouble("balance");
//				tempbalance+=amount;
//				s.executeUpdate("update users set balance="+tempbalance+" where username='"+rec+"'");
//				s.executeUpdate("insert into transactions(sender,receiver,amount,date) values('"+this.userName+"','"+rec+"',"+amount+",CURDATE())");
//				con.close();
//			} catch(Exception e){
//				System.out.println(e);
//			}
//	}
//	public void viewOffers(){
//		Statement s=null;
//		Connection con=null;
//		ResultSet rs=null;
//		int flag=0;
//			try {
//				con= DriverManager.getConnection(DBconf.DB_URL,DBconf.DB_User, DBconf.DB_Pass);
//				s=con.createStatement();
//				String str="SELECT * from offers";
//				rs= s.executeQuery(str);
//				while(rs.next()){
//					System.out.println("Seller: "+rs.getString("seller")+"   Offer:"+rs.getDouble("discount")+"%");
//					flag=1;
//				}
//				con.close();
//				if(flag==0){
//					System.out.println("\nNo Offers Available :(");
//				}
//			} catch(Exception e){
//				System.out.println(e);
//			}
//	
//	}
//
		public boolean makePayment(String receiver, double amount) {
				if(VirtualBank.transferMoney(receiver,this.getUserName(),this.getWallet().getBalance(),amount))
				{
					this.getWallet().setBalance(this.getWallet().getBalance()-amount);
					return true;
				}						
			else 
				return false;
			
		}
		
	
		
		public Offer[] viewOffers(){
			Statement s=null;
			Connection con=null;
			ResultSet rs=null;
			int flag=0;
				try {
					con= DriverManager.getConnection(DBconf.DB_URL,DBconf.DB_User, DBconf.DB_Pass);
					s=con.createStatement();
					String str="SELECT * from offers";
					rs= s.executeQuery(str);
					while(rs.next()){
						System.out.println("Seller: "+rs.getString("seller")+"   Offer:"+rs.getDouble("discount")+"%");
						flag=1;
					}
					con.close();
					if(flag==0){
						System.out.println("\nNo Offers Available :(");
					}
				} catch(Exception e){
					System.out.println(e);
				}
				return offers;
		
		}

		
	
}

