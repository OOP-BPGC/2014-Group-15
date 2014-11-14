import java.util.Scanner;
import java.sql.*;

public class Login {
	
	private String securityAns;
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	
	public static boolean signup(){
		String firstName,lastName, emailID, userName=null, password=null,status=null;
		Scanner in = new Scanner(System.in);
		String str=null;
		System.out.println("Enter First Name");
		firstName=in.next();
		System.out.println("Enter Last Name");
		lastName=in.next();
		Statement s=null;
		Connection con=null;
		ResultSet rs=null;
		int flag=0;
		try {
			con= DriverManager.getConnection("jdbc:mysql://localhost/EWALLET","root", "abhi1204");
			s=con.createStatement();
		}catch(Exception e){}
		do{
			flag=0;
			str="SELECT Username,Email from users";
			System.out.println("Enter UserName");
			System.out.println("Enter email address");
			emailID=in.next();
			userName=in.next();
			try{
				
					
					rs= s.executeQuery(str);
					while(rs.next()){
						if(userName.equals(rs.getString("Username"))||emailID.equals(rs.getString("Email"))){
							System.out.println("Username/emailID already taken");
							flag=1;
							break;
						}
					}
					rs.close();
				}catch(SQLException e) {
						System.out.println("ERROR: "+e);
				}
			}while(flag==1);
			
			try{
				while(true){
					System.out.println("Enter Password");
					password=in.next();
					System.out.println("Re-enter Password");
					if (password.equals(in.next()))
						break;
				}
				System.out.println("Register as Customer/Seller/Recharge Person/Virtual Bank ? :");
				status=in.next().toLowerCase();
				str="INSERT into users "+ "VALUES ('"+firstName+"','"+lastName+"','"+userName+"','"+emailID+"','"+password+"','"+status+"',0)";	
				s.executeUpdate(str);
				System.out.println("Signup Successful\n");
				con.close();
			}
			catch(SQLException e) {
				System.out.println("ERROR: "+e);
			}
			if(flag==1)return false;
			else {
				String args1[]={};
				Driver.main(args1);
				in.close();
				return true;
			}
			
	}
		
	 
//		
	/*
	 * Take username, password.
	 * Verify login Details.
	 * Call a method of the user displaying the menu 
	 * (CheckBalance,view offers, view transaction history, make payment,transfer balance,logout)
	 * 
	 */
	public static void loginInMethod(){
		Scanner in = new Scanner(System.in);
		String s1=null,s2=null;
		while(true)
		{
			System.out.println("Enter UserName ");
			 s1=in.next();
			System.out.println("Enter Password ");
			 s2=in.next();
			if(verifyLogin(s1,s2)) 
			{	
			
				break;
			} 
			else
				System.out.println("Username password incorrect\n");
		}
		Statement s=null;
		Connection con=null;
		ResultSet rs=null;
		String str,st;
		
			try {
				con= DriverManager.getConnection("jdbc:mysql://localhost/EWALLET","root", "abhi1204");
				s=con.createStatement();
				
				str="SELECT * from users where Username='"+s1+"'";
				rs=s.executeQuery(str);
				rs.next();
		switch(rs.getString("status").toLowerCase()){
		
		case "customer":
						Customer customer=new Customer(rs.getString("First Name"),rs.getString("Last Name"),rs.getString("Username"),rs.getDouble("balance"));
						customer.use();
						break;
		case "seller":
						Seller seller=new Seller(rs.getString("First Name"),rs.getString("Last Name"),rs.getString("Username"),rs.getDouble("balance"));
						seller.use();
						break;
		case "recharge person":
						RechargePerson rp=new RechargePerson(rs.getString("First Name"),rs.getString("Last Name"),rs.getString("Username"),1000);
						rp.use();
						break;
		case "virtual bank":
				VirtualBank.giveCredit();
				String args1[]={};
				Driver.main(args1);
			break;
		} 
			}catch(Exception e){
			System.out.println(e);
		}
			in.close();
	}
	public static boolean verifyLogin(String s1, String s2)
	{
		Statement s=null;
		Connection con=null;
		ResultSet rs=null;
		String str;
		
			try {
				con= DriverManager.getConnection("jdbc:mysql://localhost/EWALLET","root", "abhi1204");
				s=con.createStatement();
				str="SELECT Username,Password from users";
				rs=s.executeQuery(str);
				while(rs.next()){
					if(s1.equals(rs.getString("Username"))&&s2.equals(rs.getString("Password"))){
						return true;
					}
				}
				rs.close();
			}  catch (SQLException e) {		
				
				 System.out.println("ERROR: "+e);
			   }
		return false;	
	}
	public static void forgotPassword(){
		System.out.println("Enter usernmae: ");
		Scanner in = new Scanner(System.in);
		String username=in.next();
		Statement s=null;
		Connection con=null;
		ResultSet rs=null;
		String str;
		
			try {
				con= DriverManager.getConnection("jdbc:mysql://localhost/EWALLET","root", "abhi1204");
				s=con.createStatement();
				str="SELECT Username,Password from users";
				rs=s.executeQuery(str);
				while(rs.next()){
					if(username.equals(rs.getString("Username"))){
						System.out.println("Your password is "+rs.getString("Password")); //Add method to verify person's ID
					}
				}
			}  catch (SQLException e) {		
				 System.out.println("ERROR: "+e);
			   }
		
	}
}
