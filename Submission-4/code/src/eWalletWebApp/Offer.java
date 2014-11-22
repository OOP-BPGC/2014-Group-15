package eWalletWebApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Offer {
//	private int offerID;
	private int discount;
	private String seller;
	public static double applyOffer(String seller,double amount){
		Statement s=null;
		Connection con=null;
		ResultSet rs=null;
		double disc=0;
		try {
			con= DriverManager.getConnection(DBconf.DB_URL,DBconf.DB_User, DBconf.DB_Pass);
			s=con.createStatement();
			String str="SELECT discount from offers where seller='"+seller+"'";
			rs= s.executeQuery(str);
			if(rs.next())
			disc=rs.getDouble("discount");
			else{
				System.out.println("No offers from Seller");
			}
		}catch (Exception e){
			System.out.println(e);
		}
		return (amount-((amount)*disc/100));
	}
}
