package MAIN;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Seller extends User {
	Customer c;
	public Seller(String firstName2, String lastName2,String userName2,double balance) {
		
		this.firstName=firstName2;
		this.lastName=lastName2;
//		this.emailID=emailID2;
		this.userName=userName2;
		this.wallet=new Wallet(balance);
	}
	
	
	public void addOffer(){
		System.out.println("Enter the discount % : ");

		double dis=Driver.scanner.nextDouble();
		Statement s=null;
		Connection con=null;
		ResultSet rs=null;
		String str;
		
			try {
				con= DriverManager.getConnection(DBconf.DB_URL,DBconf.DB_User, DBconf.DB_Pass);
				s=con.createStatement();
				str="SELECT * from offers where seller='"+this.userName+"'";
				rs=s.executeQuery(str);
				if(rs.next())
					str="UPDATE offers set discount="+dis+"where seller='"+this.userName+"'";
				else
					str="INSERT into offers values('"+this.userName+"',"+dis+")";
				s.executeUpdate(str);
				con.close();
			} catch(Exception e){
				System.out.println(e);
			}
	}
	
	
	public void use(){
		System.out.println("Welcome, "+this.userName);
		int choice;
		do{	
			System.out.println("1. Check Balance");
			System.out.println("2. Add Offer");
			System.out.println("3. Money Transfer ");
			System.out.println("4. Logout");
			choice=Driver.scanner.nextInt();
			switch(choice){
			case 1:
				System.out.println("Available balance is" + this.checkBalance());
				break;
			
			case 2:
				this.addOffer();
				break;
			case 3:
					moneyTransfer();
					break;
			case 4:
				logout();
				break;
				default:
					System.out.println("Invalid input");
			}
		}while(choice!=4);
	}
		
}
