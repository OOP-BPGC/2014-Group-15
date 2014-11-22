import java.sql.SQLException;

import MAIN.*;
import junit.framework.*;
public class TestLogin extends TestCase{
public TestLogin(String name){
	super(name);
}
Login log;
public void setUp(){
	 log=new Login();
	
}
public void testSignup(){
	try{
		log.signup();
	}catch(Exception e){
		e.printStackTrace();
	}
}
public void testLoginMethod(){
	try{
		log.loginInMethod();
	}catch(Exception e){
		e.printStackTrace();
	}
}

public void testForgotPassword(){
	try{
		log.forgotPassword();
	}catch(Exception e){
		e.printStackTrace();
	}
}
}
