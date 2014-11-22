package eWalletWebApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User{
	
	
	private String firstName;
	private String lastName;
	private String emailID;
	private String userName;
	private String password;
	private Wallet wallet;
	private ArrayList<Transaction> transactions= new ArrayList<Transaction>();
	
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
	public boolean transferMoney(String receiver, double amount) {
		if(VirtualBank.transferMoney(receiver,this.getUserName(),this.getWallet().getBalance(),amount))
		{
			this.getWallet().setBalance(this.getWallet().getBalance()-amount);
			return true;
		}						
	else 
		return false;
	
}
	public ArrayList<Transaction> viewTransactionHistory(){
		Statement s=null;
		Connection con=null;
		ResultSet rs=null;
		int flag=0;
			try {
				con= DriverManager.getConnection(DBconf.DB_URL,DBconf.DB_User, DBconf.DB_Pass);
				s=con.createStatement();
				String str="SELECT * from transactions where sender='"+this.userName+"' or receiver='"+this.userName+"'";
				
				rs= s.executeQuery(str);
				
				Transaction transaction=new Transaction();
				while(rs.next()){
					transaction.id=rs.getInt("id");
					transaction.sender=rs.getString("sender");
					transaction.receiver=rs.getString("receiver");
					transaction.amount=rs.getDouble("amount");
					transaction.date=rs.getDate("date");
					transactions.add(transaction);
					System.out.println(transaction.id);
					System.out.println(rs.getDate("date"));
					System.out.println(transaction);
					
					flag=1;
				}
				if(flag==0){
					System.out.println("No transactions yet");
				}
				for(int i=0;i<transactions.size();i++)
			  	{
			  		System.out.println("ID: "+transactions.get(i).id+"\nReceiver: "+transactions.get(i).receiver+"\nAmount: "+transactions.get(i).amount+"\nDate: "+transactions.get(i).date+"\n\n");
			  	}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return transactions;
	}			
}			
	
	
	
	

