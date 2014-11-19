package Test;
import junit.framework.*;
import MAIN.*;
public class TestOffer extends TestCase {
	public TestOffer(String name){
		super(name);
	}
	public void testApplyOffer(){
		try{
			Offer.applyOffer("Johnny",50);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
