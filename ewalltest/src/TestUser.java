import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.*;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TestUser extends TestCase{
	User user;
	public void setUp(){
		user=createNiceMock(User.class);
	}
	public void testCheckBalance(){
		expect(user.checkBalance()).andReturn(0.0);
		replay(user);
		assertEquals(0.0,user.checkBalance());
		verify(user);
		}
	
	public void testAddCredit(){
		
		expect(user.addCredit(0.0)).andReturn(0.0);
		replay(user);
		assertEquals(0.0,user.addCredit(0.0));
		verify(user);
		
	}
	public void testViewTransactionHistory(){
		
		ArrayList<Transaction> t= new ArrayList<Transaction>();
		expect(user.viewTransactionHistory()).andReturn(t);
		replay(user);
		assertEquals(t,user.viewTransactionHistory());
		verify(user);
		}
	public void testGetOffers() {
	
		ArrayList<Offer> a=new ArrayList<Offer>();
		expect(user.getOffers()).andReturn(a);
		replay(user);
		assertEquals(a,user.getOffers());
		verify(user);
	}

}
