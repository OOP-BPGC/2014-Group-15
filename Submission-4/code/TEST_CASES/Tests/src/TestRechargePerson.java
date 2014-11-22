import junit.framework.*;
import MAIN.*;
public class TestRechargePerson extends TestCase{
	public TestRechargePerson(String Name){
		super(Name);
	}
	public void testRecharge(){
		RechargePerson per=new RechargePerson();
		try{
			per.Recharge();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

}
