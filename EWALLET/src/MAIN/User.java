package MAIN;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User{
	
	protected int privlg;
	protected String firstName,lastName, emailID, userName, password;
	protected Wallet wallet;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
//	public ArrayList<GiftCard> getGiftCards() {
//		return giftCards;
//	}
//	public void setGiftCards(ArrayList<GiftCard> giftCards) {
//		this.giftCards = giftCards;
//	}
	
	public double checkBalance(){
		return wallet.getBalance();
		}

	
	/*
	 * Change the method to get the history from the database
	 */
	public int moneyTransfer(){
		System.out.println("Enter username of receiver");
		String rec=Driver.scanner.next();
		System.out.println("Enter the amount to be Transferred");
		double amount=Driver.scanner.nextDouble();
		if(this.wallet.getBalance()<amount){
			System.out.println("\nInsufficient Balance\n");
			return 0;
		}
		Statement s=null;
		Connection con=null;
		ResultSet rs=null;
			try {
				con= DriverManager.getConnection(DBconf.DB_URL,DBconf.DB_User, DBconf.DB_Pass);
				s=con.createStatement();
				this.wallet.setBalance(this.wallet.getBalance()-amount);
				s.executeUpdate("update users set balance="+this.wallet.balance+" where username='"+this.userName+"'");
				String str="SELECT * from users where Username='"+rec+"'";
				rs= s.executeQuery(str);
				rs.next();
				double tempbalance=rs.getDouble("balance");
				tempbalance+=amount;
				s.executeUpdate("update users set balance="+tempbalance+" where username='"+rec+"'");
				s.executeUpdate("insert into transactions(sender,receiver,amount,date) values('"+this.userName+"','"+rec+"',"+amount+",CURDATE())");
			} catch(Exception e){
				System.out.println(e);
			}
		return 1;			
		
		}//return 1 if transaction successful 0 otherwise 
	
	public void viewTransactionHistory(){
		Statement s=null;
		Connection con=null;
		ResultSet rs=null;
		int flag=0;
			try {
				con= DriverManager.getConnection(DBconf.DB_URL,DBconf.DB_User, DBconf.DB_Pass);
				s=con.createStatement();
				String str="SELECT * from transactions where sender='"+this.userName+"'";
				rs= s.executeQuery(str);
				while(rs.next()){
					System.out.println("Transferred to: "+rs.getString("receiver")+"\nAmount: "+rs.getDouble("amount")+"\n Date: "+rs.getDate("date"));
					System.out.println();
				}
				if(flag==0){
					System.out.println("No transactions yet");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}			
	
	public void logout(){
		System.out.println("Logging Out...");
		String args[]={};
		Driver.main(args);
	}
	
}
