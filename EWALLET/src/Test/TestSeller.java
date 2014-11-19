package Test;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.*;
import junit.framework.TestCase;
public class TestSeller extends TestCase {
Seller seller;
public void setUp(){
seller=createNiceMock(Seller.class);
}
public void testReceivePayment(){
expect(seller.receivePayment(5.0)).andReturn(0.0);
replay(seller);
assertEquals(0.0,seller.receivePayment(5.0));
verify(seller);
}
public void testAddOffer(){
fail("no offer to add");
}
}