package Test;


import MAIN.*;
import junit.framework.*;
public class TestLogin extends TestCase{
public TestLogin(String name){
	super(name);
}

public void testSignup(){
	try{
		System.out.println("TEST SIGNUP");
		Login.signup();
	}catch(Exception e){
		e.printStackTrace();
	}
}
public void testLoginMethod(){
	try{
		System.out.println("TEST LOGIN");
		Login.loginInMethod();
	}catch(Exception e){
		e.printStackTrace();
	}
}

public void testForgotPassword(){
	try{
		System.out.println("TEST FORGOT PASSWORD");
		Login.forgotPassword();
	}catch(Exception e){
		e.printStackTrace();
	}
}
}
