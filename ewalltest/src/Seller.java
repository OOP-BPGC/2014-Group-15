import java.util.ArrayList;
import java.util.Scanner;


public class Seller extends User {
	Customer c;
	public Seller(Customer c){
		this.c=c;
		this.privlg=1;
	}

	public Seller(){
		
	}
	Offer o=new Offer();
	private ArrayList<Offer> offers;
	Scanner inp=new Scanner(System.in);
	
	public void receivePayment(double amount){
		
		wallet.sellerNewBalance(amount);
		} 
	
	public void addOffer(Offer o){}
	public ArrayList<Offer> offer(){
		return offers;
	}
	public void use(){
		System.out.println("Enter 1 to check balance");
		
		System.out.println("Enter 2 to add offer");
		System.out.println("Enter 3 to logout");
		int choice=inp.nextInt();
		switch(choice){
		case 1:
			System.out.println("Available balance is" + this.checkBalance());
			break;
		
			
			
		case 2:
			this.addOffer(o);
			break;
		case 3:
			//logout procedure
			break;
			default:
				System.out.println("Invalid input");
		}
		
	}
}
