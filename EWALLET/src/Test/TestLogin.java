package Test;

import static org.easymock.EasyMock.*;
import junit.framework.*;

public class TestLogin extends TestCase{
Login l;
public void setUp(){
l=createNiceMock(Login.class);
}
public void testForgotPassword(){
expect(Login.forgotPassword("a","b")).andReturn("c");
replay(l);
assertEquals("c",Login.forgotPassword("a","b"));
verify(l);
}
}