import junit.framework.*;
import MAIN.*;
public class TestCustomer extends TestCase{
public TestCustomer(String name){
	super(name);
}
Customer c;
public void setUp(){
	 c=new Customer("JOHN","KILL","JOKI",1);
}
public void testMakePayment(){
	try{
		c.makePayment();
	}catch(Exception e){
		e.printStackTrace();
	}
}
public void testViewOffers(){
	try{
		c.viewOffers();
	}catch(Exception e){
		e.printStackTrace();
	}
}
}
