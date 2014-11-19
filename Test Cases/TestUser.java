package Test;


import junit.framework.*;
import MAIN.*;
public class TestUser extends TestCase{
	public TestUser(String name){
		super(name);
	}
	User use;
	Wallet w;
	public void setUp(){
		use=new User();
		w=new Wallet(0.0);
	}
public void testCheckBalance(){
	use.setWallet(w);
	w.setBalance(50.0);
	assertEquals(50.0,use.checkBalance());
}
public void testMoneyTransfer(){
	try{
		use.moneyTransfer();
	}catch(Exception e){
		e.printStackTrace();
	}
}
public void testViewTransactionHistory(){
	try{
		use.viewTransactionHistory();
	}catch(Exception e){
		e.printStackTrace();
	}
}

}
