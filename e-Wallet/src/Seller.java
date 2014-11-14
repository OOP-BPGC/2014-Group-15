import java.util.ArrayList;


public class Seller extends User {

	private ArrayList<Offer> offers;
	public Seller(){
		this.privlg=1;
	}
	public double receivePayment(double amount){
		return this.getBalance();} 
	
	public void addOffer(Offer o){}
}
