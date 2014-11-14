
public class Wallet {
	public double balance;
	
	public Wallet(double x){
		this.balance=x;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}
	public void sellerNewBalance(double amount){
		balance=balance+amount;
	}
	public void customerNewBalance(double amount){
		balance=balance-amount;
	}
//	public int[] getGiftcards() {
//		return giftcards;
//	}
//	public void setGiftcards(int[] giftcards) {
//		this.giftcards = giftcards;
//	}
//	public int[] giftcards;
	
}
