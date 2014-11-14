import java.util.ArrayList;
import java.util.Scanner;


public class Customer extends User{
	Seller seller;
	public Customer(Seller s){
		//this.privlg=0;
		this.seller=s;
		
		}
		
		
	
	double amount;
	public ArrayList<Offer> viewOffers(Seller seller){
		return this.getOffers(seller);}
	public void moneyTransfer(Seller s,double amount){
		this.amount=amount;
		seller.receivePayment(amount);
		//transaction object created
		//transaction list of seller and customer updated
		//balance updated
		//optional applyOffer method
		//call confirmTransaction
		wallet.customerNewBalance(amount);
		
		}//return 1 if transaction successful 0 otherwise 
	
	public void purcahseGiftCard(){}
	
	public void sendGiftCard(Customer s){}
	public int choice,i;
	Scanner a=new Scanner(System.in);
	public void use(){
		System.out.println("Enter 1 to check balance");
		System.out.println("Enter 2 to make payment");
		System.out.println("Enter 3 to view offers");
		System.out.println("Enter 4 to log out");
		choice=a.nextInt();
		
		switch(choice){
		case 1:
			System.out.println("Available balance is " + wallet.getBalance() );
			break;
		case 2:
			System.out.println("Select the seller you want to pay" );
			
			System.out.println("Enter 1 for seller");
			
			
			i=a.nextInt();
			switch(i){
			
		
			case 1: System.out.println(seller.offer());
			System.out.println("Enter the amount to pay");
			amount=a.nextDouble();
			this.moneyTransfer(seller, amount);
			//seller.receivePayment();
			break;
		
			

			default:
				System.out.println("Invalid input");
			break;
			}
			break;
		case 3:
			
			System.out.println(this.viewOffers(seller));
			break;
		case 4:
			//logout procedure
			break;
			
			default:
				System.out.println("Invalid input");
				break;
		
			}
	}
}

