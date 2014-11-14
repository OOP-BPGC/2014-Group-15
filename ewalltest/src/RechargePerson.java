
public class RechargePerson extends User {
	
	
	
	private double TotalCredits;
	private double bankBalance;
	public static RechargePerson r1= new RechargePerson();
	
	public double getCredits(double credits){
		if(TotalCredits>credits){
				return credits;
		}else
			return 0;
	}
}
