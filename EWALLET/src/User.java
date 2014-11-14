import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class User{
	
	//protected Wallet wallet;

//	private ArrayList<GiftCard> giftCards;
	private Transaction transaction;
//	private ArrayList<Offer> offer;
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
		Scanner in=new Scanner(System.in);
		System.out.println("Enter username of receiver");
		String rec=in.next();
		System.out.println("Enter the amount to be Transferred");
		double amount=in.nextDouble();
		if(this.wallet.getBalance()<amount){
			System.out.println("\nInsufficient Balance\n");
			return 0;
		}
		Statement s=null;
		Connection con=null;
		ResultSet rs=null;
			try {
				con= DriverManager.getConnection("jdbc:mysql://localhost/EWALLET","root", "abhi1204");
				s=con.createStatement();
				this.wallet.setBalance(this.wallet.getBalance()-amount);
				s.executeQuery("update users set balance="+this.wallet.balance+" where username='"+this.userName+"'");
				String str="SELECT * from users where Username='"+rec+"'";
				rs= s.executeQuery(str);
				double tempbalance=rs.getDouble("balance");
				tempbalance+=amount;
				s.executeQuery("update users set balance="+tempbalance+" where username='"+rec+"'");
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
				con= DriverManager.getConnection("jdbc:mysql://localhost/EWALLET","root", "abhi1204");
				s=con.createStatement();
				String str="SELECT * from transactions where Username='"+this.userName+"'";
				rs= s.executeQuery(str);
				while(rs.next()){
					flag=1;
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
		String[] args = {};
		Driver.main(args);
	}
	
}