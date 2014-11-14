import java.util.ArrayList;


public class User extends Login{
	
	//protected Wallet wallet;

	private ArrayList<GiftCard> giftCards;
	private ArrayList<Transaction> transactions;
	private ArrayList<Offer> offer;
	protected int privlg;
	public double amount=100;
	private String firstName,lastName, emailID, userName, password;
	protected Wallet wallet=new Wallet(amount);
	
	public User(){
		
	}
	public User(String firstName2, String lastName2, String emailID2,
			String userName2, String password2) {
		// TODO Auto-generated constructor stub
		this.firstName=firstName2;
		this.lastName=lastName2;
		this.emailID=emailID2;
		this.userName=userName2;
		this.password=password2;
		//this.wallet=new Wallet(amount);
	}
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
	public ArrayList<GiftCard> getGiftCards() {
		return giftCards;
	}
	public void setGiftCards(ArrayList<GiftCard> giftCards) {
		this.giftCards = giftCards;
	}
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public double checkBalance(){
		return wallet.getBalance();
		}
	
	public ArrayList<Offer> getOffers(Seller s){
		return s.offer();
	}
	
	
	/*
	 * Change the method to get the history from the database
	 */
	public ArrayList<Transaction> viewTransactionHistory(){
		return transactions;}
	
	
	
}
