package MAIN;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class VirtualBank {

	public static void giveCredit(){
		System.out.println("Enter username of User");
		String rec=Driver.scanner.next();
		System.out.println("Enter the amount to Credit");
		double amount=Driver.scanner.nextDouble();
		Statement s=null;
		Connection con=null;
		ResultSet rs=null;
			try {
				con= DriverManager.getConnection("jdbc:mysql://localhost/EWALLET","root", "abhi1204");
				s=con.createStatement();
				String str="SELECT * from users where Username='"+rec+"'";
				rs= s.executeQuery(str);
				rs.next();
				double tempbalance=rs.getDouble("balance");
				tempbalance+=amount;
				s.executeUpdate("update users set balance="+tempbalance+" where username='"+rec+"'");
				con.close();
			} catch(Exception e){
				System.out.println(e);
			}
		}
}
