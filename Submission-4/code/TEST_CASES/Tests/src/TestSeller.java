import junit.framework.*;
import MAIN.*;
public class TestSeller extends TestCase{
	public TestSeller(String name){
		super(name);
	}
public void testAddOffer(){
	Seller sel=new Seller("Sam","Kumar","saku",50);
	try{
		sel.addOffer();
	}catch(Exception e){
		e.printStackTrace();
	}
}
}
