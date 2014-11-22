package eWalletWebApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Seller extends User {
	Customer c;
	public Seller(String userName, String password) {
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
	
	
	
//	public Seller(String firstName2, String lastName2,String userName2,double balance) {
//		
//		this.firstName=firstName2;
//		this.lastName=lastName2;
////		this.emailID=emailID2;
//		this.userName=userName2;
//		this.wallet=new Wallet(balance);
//	}
//	
//	
//	public void addOffer(){
//		System.out.println("Enter the discount % : ");
//
//		double dis=Driver.scanner.nextDouble();
//		Statement s=null;
//		Connection con=null;
//		ResultSet rs=null;
//		String str;
//		
//			try {
//				con= DriverManager.getConnection(DBconf.DB_URL,DBconf.DB_User, DBconf.DB_Pass);
//				s=con.createStatement();
//				str="SELECT * from offers where seller='"+this.userName+"'";
//				rs=s.executeQuery(str);
//				if(rs.next())
//					str="UPDATE offers set discount="+dis+"where seller='"+this.userName+"'";
//				else
//					str="INSERT into offers values('"+this.userName+"',"+dis+")";
//				s.executeUpdate(str);
//				con.close();
//			} catch(Exception e){
//				System.out.println(e);
//			}
//	}
//	
//	
//	public void use(){
//		System.out.println("Welcome, "+this.userName);
//		int choice;
//		do{	
//			System.out.println("1. Check Balance");
//			System.out.println("2. Add Offer");
//			System.out.println("3. Money Transfer ");
//			System.out.println("4. View Transaction History");
//			System.out.println("5. Logout");
//			choice=Driver.scanner.nextInt();
//			switch(choice){
//			case 1:
//				System.out.println("Available balance is" + this.checkBalance());
//				break;
//			
//			case 2:
//				this.addOffer();
//				break;
//			case 3:
//					moneyTransfer();
//					break;
//			case 4:
//				viewTransactionHistory();
//				break;
//			case 5:
//			//	logout();
//				break;
//				default:
//					System.out.println("Invalid input");
//			}
//		}while(choice!=5);
//	}
		
}
