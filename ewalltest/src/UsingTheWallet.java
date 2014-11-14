import java.util.Scanner;


public class UsingTheWallet {
	public UsingTheWallet(String name){
		System.out.println("Welcome " + name);
	}
	public int choice;
	Scanner s=new Scanner(System.in);
	public void use(){
		System.out.println("Enter 1 to check balance");
		System.out.println("Enter 2 to make payment");
		System.out.println("Enter 3 to view offers");
		System.out.println("Enter 4 to log out");
		System.out.println("Make a choice");
		choice=s.nextInt();
		
		switch(choice){
		case 1:
			System.out.println();
			break;
			default:
				System.out.println("hiiiiiiiii");
		
			}
	}
	public static void main(String[] args){
		UsingTheWallet a=new UsingTheWallet("Aditya");
		a.use();
	}
}
