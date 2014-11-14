import java.util.ArrayList;

import junit.framework.*;
import static org.easymock.EasyMock.*;
public class TestCustomer extends TestCase{
	Customer c;
	public void setUp(){
		c=createNiceMock(Customer.class);
	}
	public void testViewOffers(){
		ArrayList<Offer> a=new ArrayList<Offer>();
		expect(c.viewOffers()).andReturn(a);
		replay(c);
		assertEquals(a,c.viewOffers());
		verify(c);
		
	}
	public void testMoneyTransfer(){
		fail("no money to transfer");
		
		}//return 1 if transaction successful 0 otherwise 
	
	public void testPurcahseGiftCard(){
		fail("no gift to purchase");
	}
	
	public void tetsSendGiftCard(){
		fail("no giftcard to send");
	}

}
