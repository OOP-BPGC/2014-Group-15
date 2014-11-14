import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


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
		this.wallet=new Wallet(1000);
	}
	
	public int Recharge(){
		Scanner in=new Scanner(System.in);
		System.out.println("Enter username of User");
		String rec=in.next();
		System.out.println("Enter the amount of Recharge");
		double amount=in.nextDouble();
		if(this.wallet.getBalance()<amount){
			System.out.println("Insufficient Balance");
			in.close();
			return 0;
		}
		Statement s=null;
		Connection con=null;
		ResultSet rs=null;
			try {
				con= DriverManager.getConnection("jdbc:mysql://localhost/EWALLET","root", "abhi1204");
				s=con.createStatement();
				this.wallet.setBalance(this.wallet.getBalance()-amount);
				s.executeQuery("update users set balance="+this.wallet.balance+" where username='"+this.userName+"'");
				String str="SELECT * from users where Username='"+rec+"'";
				rs= s.executeQuery(str);
				double tempbalance=rs.getDouble("balance");
				tempbalance+=amount;
				s.executeUpdate("update users set balance="+tempbalance+" where username='"+rec+"'");
				con.close();
			} catch(Exception e){
				System.out.println(e);
			}
			in.close();
		return 1;
	}

	
	public void use(){
		int choice;
		Scanner a=new Scanner(System.in);
		System.out.println("Welcome, "+this.userName);
	 do{
		
		System.out.println("Enter 1 to check balance");
		System.out.println("Enter 2 to recharge");
		System.out.println("Enter 3 to Logout");
		choice=a.nextInt();
		switch(choice){
		case 1:
			System.out.println("Available balance is " + wallet.getBalance() );
			break;
		case 2:
			Recharge();

		case 3:
			logout();
			break;
		default:
			System.out.println("Wrong Option");
			break;
		}
	 }while(choice!=3);
	}
}
	
	
//	public double getCredits(double credits){
//		if(TotalCredits>credits){
//				return credits;
//		}else
//			return 0;
//	}

