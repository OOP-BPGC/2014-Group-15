package MAIN;
import java.util.Scanner;


public class Driver {
	public static Scanner scanner=new Scanner(System.in);
	public static void main(String args[]){
		int op=0;
		
		System.out.println("\n\tE-WALLET\n\n");
		System.out.println("1.Login");
		System.out.println("2.Signup");
		System.out.println("3.Forgot Password");
		System.out.println("4.Exit");
		op = scanner.nextInt();
	
		switch(op){
		case 1:
				Login.loginInMethod();
				break;
		case 2:
				Login.signup();
				break;
		case 3:
				Login.forgotPassword();
				break;
		case 4: 
				System.out.println("EXITING...");
				break;
		default:
				System.out.println("Wrong option");
				String args1[]={};
				Driver.main(args1);
		}
	}
}
