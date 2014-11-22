package eWalletWebApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class VirtualBank {
	private static double bankBalance;
	
	
		
	
	
	public static boolean giveCredit(String receiver,double amount){
		Statement s=null;
		Connection con=null;
		ResultSet rs=null;
		try {
			con= DriverManager.getConnection(DBconf.DB_URL,DBconf.DB_User, DBconf.DB_Pass);
			s=con.createStatement();
						
			rs=s.executeQuery("select balance from users where userName='virtualbank'");
			rs.next();
			bankBalance=rs.getDouble("balance");
			con.close();
		}catch(Exception e){System.out.println("Virtual Bank Error");}
	
		if(bankBalance >=amount)
		{
			
			try {
				con= DriverManager.getConnection(DBconf.DB_URL,DBconf.DB_User, DBconf.DB_Pass);
				s=con.createStatement();
							
				s.executeUpdate("update users set balance="+(bankBalance-amount)+" where userName='virtualBank'");
				String str="SELECT * from users where userName='"+receiver+"'";
				rs= s.executeQuery(str);
				rs.next();
				double tempbalance=rs.getDouble("balance");
				tempbalance+=amount;
				s.executeUpdate("update users set balance="+tempbalance+" where userName='"+receiver+"'");
				s.executeUpdate("insert into transactions(sender,receiver,amount,date) values('Virtual Bank','"+receiver+"',"+amount+",CURDATE())");
				con.close();
				
			} catch(Exception e){
				System.out.println(e);
			}
			return true;
	}
	else 
		return false;
		
	}	
	public static boolean transferMoney(String receiver, String sender, double balance, double amount) 
	{
			if(balance >=amount)
			{
				Statement s=null;
				Connection con=null;
				ResultSet rs=null;
				try {
					con= DriverManager.getConnection(DBconf.DB_URL,DBconf.DB_User, DBconf.DB_Pass);
					s=con.createStatement();
								
					s.executeUpdate("update users set balance="+(balance-amount)+" where userName='"+sender+"'");
					String str="SELECT * from users where userName='"+receiver+"'";
					rs= s.executeQuery(str);
					rs.next();
					double tempbalance=rs.getDouble("balance");
					tempbalance+=amount;
					s.executeUpdate("update users set balance="+tempbalance+" where userName='"+receiver+"'");
					s.executeUpdate("insert into transactions(sender,receiver,amount,date) values('"+sender+"','"+receiver+"',"+amount+",CURDATE())");
					con.close();
					
				} catch(Exception e){
					System.out.println(e);
				}
				return true;
		}
		else 
			return false;
		
		
	}


	


}