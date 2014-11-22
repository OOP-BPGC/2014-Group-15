package MAIN;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


	public class Customer extends User{
		Seller seller;
		public Customer(String firstName2, String lastName2,String userName2,double balance) {
		
			this.firstName=firstName2;
			this.lastName=lastName2;
			this.userName=userName2;
			this.wallet=new Wallet(balance);
		}
//	public ArrayList<Offer> viewOffers(Seller seller){
//		return this.getOffers(seller);}
	
//	public void purcahseGiftCard(){}
	
//	public void sendGiftCard(Customer s){}
	
	
	public void use(){
		int choice;
		System.out.println("Welcome, "+this.userName);
	 do{
		 
		System.out.println("1. Check Balance");
		System.out.println("2. Make Payment");
		System.out.println("3. View Offers");
		System.out.println("4. Money Transfer");
		System.out.println("5. Logout");
		choice=Driver.scanner.nextInt();
		
		switch(choice){
		case 1:
			System.out.println("Available balance is " + wallet.getBalance() );
			break;
		case 2:
			this.makePayment();

		case 3:
			this.viewOffers();
			break;
		case 4:
			moneyTransfer();
			break;
		case 5:
			logout();
			break;
			default:
				System.out.println("Invalid input");
				break;
		
			}
		}while(choice!=5);
	}
	public void makePayment(){
		
		System.out.println("Enter username of Seller");
		String rec=Driver.scanner.next();
		System.out.println("Enter the amount to be Transferred");
		double amount=Driver.scanner.nextDouble();
		
		if(this.wallet.getBalance()<amount){
			System.out.println("\nInsufficient Balance\n");
			return;
		}
		else{
			System.out.println("Apply Offer? (Y/N)");
			String op=(Driver.scanner.next());
			if(op.equals("Y")){
				amount=Offer.applyOffer(rec,amount);
			}
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
				s.executeUpdate("insert into transactions (sender,receiver,date) values('"+this.userName+"','"+rec+"',CURDATE())");
				con.close();
			} catch(Exception e){
				System.out.println(e);
			}
	}
	public void viewOffers(){
		Statement s=null;
		Connection con=null;
		ResultSet rs=null;
		int flag=0;
			try {
				con= DriverManager.getConnection(DBconf.DB_URL,DBconf.DB_User, DBconf.DB_Pass);
				s=con.createStatement();
				String str="SELECT * from offers";
				rs= s.executeQuery(str);
				while(rs.next()){
					System.out.println("Seller: "+rs.getString("seller")+"   Offer:"+rs.getDouble("discount")+"%");
					flag=1;
				}
				con.close();
				if(flag==0){
					System.out.println("\nNo Offers Available :(");
				}
			} catch(Exception e){
				System.out.println(e);
			}
	
	}
	
	
}

