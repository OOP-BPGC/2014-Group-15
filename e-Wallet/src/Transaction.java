import java.util.Date;


public class Transaction {

	public static int transactionID;
	public Date date;
	//public int receiverID;
	public Seller seller;
	public Customer customer;
	public double amount;
	
//	public int getTransactionID() {
//		return transactionID;
//	}
//	public void setTransactionID(int transactionID) {
//		this.transactionID = transactionID;
//	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Transaction(Customer u1,Seller u2,double amount){}
	public Transaction(Customer u1,Seller u2,double amount,Offer o){}
	public Transaction(Customer u1,Seller u2,double amount,GiftCard gc){}
	public void confirmTransaction(){}
	
}
