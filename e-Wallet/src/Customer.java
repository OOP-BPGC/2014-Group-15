import java.util.ArrayList;


public class Customer extends User{
	
	public Customer(){
		//this.privlg=0;
	}
	public ArrayList<Offer> viewOffers(){
		return this.getOffers();
		}
	
	public void moneyTransfer(Customer receiver, double amount){
		receiver.getWallet.setBalance(receiver.getWallet.getBalance()+amount);
		
	}
	
	public void makePayment(Seller s,double amount){
		//transaction object created
		//transaction list of seller and customer updated
		//balance updated
		//optional applyOffer method
		//call confirmTransaction
		}
	//return 1 if transaction successful 0 otherwise 
	public double addCredit(double amount){
		wallet.setBalance(RechargePerson.r1.getCredits(amount) + wallet.getBalance()); 
		
		return wallet.getBalance();
	}
//	public void purcahseGiftCard(){}
//	
//	public void sendGiftCard(Customer s){}
	
}
