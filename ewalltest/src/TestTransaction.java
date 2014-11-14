import static org.easymock.EasyMock.createNiceMock;
import junit.framework.*;
public class TestTransaction extends TestCase {
	Transaction t;
	
	public void setUp(){
		t=createNiceMock(Transaction.class);
	}
	public void testConfirmTransaction(){
		fail("no transaction done");
	}

}
