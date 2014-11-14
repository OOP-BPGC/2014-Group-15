import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Offer {
	private int offerID;
	private int discount;
	private Seller s;
	public static double applyOffer(String seller,double amount){
		Statement s=null;
		Connection con=null;
		ResultSet rs=null;
		double disc=0;
		try {
			con= DriverManager.getConnection("jdbc:mysql://localhost/EWALLET","root", "abhi1204");
			s=con.createStatement();
			String str="SELECT discount from offers where seller='"+seller+"'";
			rs= s.executeQuery(str);
			disc=rs.getDouble("discount");
		}catch (Exception e){
			System.out.println(e);
		}
		return (amount-((amount)*disc/100));
	}
}
