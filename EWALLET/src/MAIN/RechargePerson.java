package MAIN;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class RechargePerson extends User {
	
	
	
//	private double TotalCredits;
//	private double bankBalance;
	public static RechargePerson r1= new RechargePerson();
	
	public RechargePerson(){}
	public RechargePerson(String firstName2, String lastName2,String userName2,double balance) {
		
		this.firstName=firstName2;
		this.lastName=lastName2;
//		this.emailID=emailID2;
		this.userName=userName2;
		this.wallet=new Wallet(balance);
	}
	
	public int Recharge(){
		System.out.println("Enter username of User");
		String rec=Driver.scanner.next();
		System.out.println("Enter the amount of Recharge");
		double amount=Driver.scanner.nextDouble();
		if(this.wallet.getBalance()<amount){
			System.out.println("Insufficient Balance");
			return 0;
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
				s.executeUpdate("insert into transactions(sender,receiver,amount,date) values('"+this.userName+"','"+rec+"',"+amount+",CURDATE())");
				con.close();
			} catch(Exception e){
				System.out.println(e);
			}
		return 1;
	}

	
	public void use(){
		int choice;
		System.out.println("Welcome, "+this.userName);
	 do{
		
		System.out.println("1. Check Balance");
		System.out.println("2. Recharge an Account");
		System.out.println("3. View Transaction History");
		System.out.println("4. Logout");
		choice=Driver.scanner.nextInt();
		switch(choice){
		case 1:
			System.out.println("Available balance is " + wallet.getBalance() );
			break;
		case 2:
			Recharge();
			break;
		case 3:
			viewTransactionHistory();
			break;
		case 4:
			logout();
			break;
		default:
			System.out.println("Wrong Option");
			break;
		}
	 }while(choice!=4);
	}
}
	
	
//	public double getCredits(double credits){
//		if(TotalCredits>credits){
//				return credits;
//		}else
//			return 0;
//	}

