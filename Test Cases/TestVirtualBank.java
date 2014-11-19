package Test;
import junit.framework.*;
import MAIN.*;
public class TestVirtualBank extends TestCase {
	public TestVirtualBank(String name){
		super(name);
	}
	public void testGiveCredit(){
		try{	
			VirtualBank.giveCredit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
