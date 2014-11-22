import MAIN.*;
import junit.framework.*;
public class TestGiftCard extends TestCase{
	public TestGiftCard(String name){
		super(name);
	}
	public void testApplyGiftCard(){
		GiftCard ob=new GiftCard();
		assertEquals(0.0,ob.applyGiftCard(50.0));
	}

}
