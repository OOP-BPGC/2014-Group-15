package Test;

import junit.framework.*;
import static org.easymock.EasyMock.createNiceMock;
public class TestOffer extends TestCase {
Offer o;
public void setUp(){
o=createNiceMock(Offer.class);
}
public void testAddOffer(){
fail("no offer to apply yet");
}
}