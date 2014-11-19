package MAIN;
import java.sql.*;

public class Login {
	
//	private String securityAns;
	
	public static void signup(){
		String firstName,lastName, emailID, userName=null, password=null,status=null;
		String str=null;
		Statement s=null;
		Connection con=null;
		ResultSet rs=null;
		int flag=0;
		System.out.println("Enter First Name");
		firstName=Driver.scanner.next();
		System.out.println("Enter Last Name");
		lastName=Driver.scanner.next();
		try {
			con= DriverManager.getConnection(DBconf.DB_URL,DBconf.DB_User, DBconf.DB_Pass);
			s=con.createStatement();
		}catch(Exception e){}
		do{
			flag=0;
			str="SELECT Username,Email from users";
			System.out.println("Enter UserName");
			userName=Driver.scanner.next();
			System.out.println("Enter email address");
			emailID=Driver.scanner.next();
			
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
				int i=0;
				while(i<3){
					if(i!=0){
						System.out.println("PASSWORDS DO NOT MATCH...TRY AGAIN");
					}
					System.out.println("Enter Password");
					password=Driver.scanner.next();
					System.out.println("Re-enter Password");
					if (password.equals(Driver.scanner.next()))
						break;
					i++;
				}
				if(i==3){
					System.out.println("OUT OF ATTEMPTS");
				}
				else{
				System.out.println("Register as Customer(c)/Seller(s)/Recharge Person(r) :");
				status=Driver.scanner.next().toLowerCase();
				str="INSERT into users VALUES ('"+firstName+"','"+lastName+"','"+userName+"','"+emailID+"','"+password+"','"+status+"',0)";	
				s.executeUpdate(str);
				System.out.println("Signup Successful\n");
				}
				con.close();
			}
			catch(SQLException e) {
				System.out.println("ERROR: "+e);
			}
				String args[]={};
				Driver.main(args);
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
		String s1=null,s2=null;
		while(true)
		{
			System.out.println("Enter UserName ");
			 s1=Driver.scanner.next();
			System.out.println("Enter Password ");
			 s2=Driver.scanner.next();
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
		String str;
		
			try {
				con= DriverManager.getConnection(DBconf.DB_URL,DBconf.DB_User, DBconf.DB_Pass);
				s=con.createStatement();
				
				str="SELECT * from users where Username='"+s1+"'";
				rs=s.executeQuery(str);
				rs.next();
		switch(rs.getString("status").toLowerCase()){
		
		case "c":
						Customer customer=new Customer(rs.getString("First_Name"),rs.getString("Last_Name"),rs.getString("Username"),rs.getDouble("balance"));
						customer.use();
						break;
		case "s":
						Seller seller=new Seller(rs.getString("First_Name"),rs.getString("Last_Name"),rs.getString("Username"),rs.getDouble("balance"));
						seller.use();
						break;
		case "r":
						RechargePerson rp=new RechargePerson(rs.getString("First_Name"),rs.getString("Last_Name"),rs.getString("Username"),rs.getDouble("balance"));
						rp.use();
						break;
		case "v":
				VirtualBank.giveCredit();
				String args1[]={};
				Driver.main(args1);
			break;
		} 
			}catch(Exception e){
			System.out.println(e);
		}
			return;
	}
	public static boolean verifyLogin(String s1, String s2)
	{
		Statement s=null;
		Connection con=null;
		ResultSet rs=null;
		String str;
		
			try {
				con= DriverManager.getConnection(DBconf.DB_URL,DBconf.DB_User, DBconf.DB_Pass);
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
		String username=Driver.scanner.next();
		Statement s=null;
		Connection con=null;
		ResultSet rs=null;
		String str;
		
			try {
				con= DriverManager.getConnection(DBconf.DB_URL,DBconf.DB_User, DBconf.DB_Pass);
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
			String args[]={};
			Driver.main(args);
	}
}
