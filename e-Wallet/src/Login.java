import java.util.Scanner;


public class Login {
	private String username;
	private static String password;
	public  static String forgotPassword(String username, String answer){
		return password;// when input answer matches securityAns
		}
	private String securityAns;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	Scanner in = new Scanner(System.in);
	public void Signup(){
		String firstName,lastName, emailID, userName, password;
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter First Name");
		firstName=in.next();
		System.out.println("Enter Last Name");
		lastName=in.next();
		System.out.println("Enter email address");
		emailID=in.next();
		System.out.println("Enter UserName");
		userName=in.next();
		
		while(true){
					System.out.println("Enter Password");
					password=in.next();
					System.out.println("Re-enter Password");
					if (password.equals(in.next()))
						break;
		}
		User u1= new User(firstName,lastName,emailID,userName,password);	
	}
	/*
	 * Take username, password.
	 * Verify login Details.
	 * Call a method of the user displaying the menu 
	 * (CheckBalance,view offers, view transaction history, make payment,transfer balance,logout)
	 * 
	 */
	public void LoginInMethod(){
		while(true)
		{
			System.out.println("Enter UserName ");
			String s1=in.next();
			System.out.println("Enter Password ");
			String s2=in.next();
			if(	verifyLogin(s1,s2)) 
			{	// ???????????????????????/
				break;
			} 
	}
	}
	public boolean verifyLogin(String s1, String s2)
	{
		return false;
		//search and match in database
		// ??????????????
		
	}
	}
