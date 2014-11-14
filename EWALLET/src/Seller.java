import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Scanner;

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
		Scanner in=new Scanner(System.in);
		double dis=in.nextDouble();
		Statement s=null;
		Connection con=null;
		String str;
		
			try {
				con= DriverManager.getConnection("jdbc:mysql://localhost/EWALLET","root", "abhi1204");
				s=con.createStatement();
				str="INSERT into offers values('"+userName+"',"+dis+")";
				s.executeUpdate(str);
				con.close();
			} catch(Exception e){
				System.out.println(e);
			}
			in.close();
	}
	
	
	public void use(){
		System.out.println("Welcome, "+this.userName);
		Scanner inp=new Scanner(System.in);
		int choice;
		do{	
			System.out.println("Enter 1 to check balance");
			System.out.println("Enter 2 to add offer");
			System.out.println("Enter 3 to logout");
			choice=inp.nextInt();
			switch(choice){
			case 1:
				System.out.println("Available balance is" + this.checkBalance());
				break;
			
			case 2:
				this.addOffer();
				break;
			case 3:
				logout();
				break;
				default:
					System.out.println("Invalid input");
			}
		}while(choice!=3);
		inp.close();
	}
		
}
