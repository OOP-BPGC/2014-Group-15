import junit.framework.*;
import MAIN.*;
public class TestVirtualBank extends TestCase {
	public TestVirtualBank(String name){
		super(name);
	}
	public void testGiveCredit(){
		VirtualBank virb=new VirtualBank();
		try{
			virb.giveCredit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
