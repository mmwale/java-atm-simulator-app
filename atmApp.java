import java.util.Scanner;
public class atmApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Account object = new Account("Medan","5552471");//object that contains the customer's details (name and id)
		object.showMenu();//calling the showMenu via the object and the parameters it carries from the atmApp class through to the Account class
	}

}

 class Account{
	int balance; //variable to store the customer's balance
	int previousTransaction; //variable to store and showcase the value of the previous transaction
	String customerName; //variable of the customer's name
	String customerId; //variable of the customer id
	
	Account(String name, String id){ // constructor for the class Account that takes in the name and id from the main method in the object
		customerName = name;
		customerId = id;
	}
	
	 void deposit(int amount) {//method that deposits the amount to the user's balance
		if(amount!= 0) {
			balance+=amount;
			previousTransaction = amount;
		}
	}
	 
	 void withdraw(int amount) { //method that withdraws from the user's balance
		 if(amount!=0) {
			 balance-=amount;
			 previousTransaction = -amount;//gives the amount a negative value to be shown as withdrawn in the getPreviousTransaction method
		 }
	 }
	 
	 void getPreviousTransaction() { //method that displays the previous transaction
		 if(previousTransaction > 0) {
			 System.out.println("Deposited: " +previousTransaction);
			 System.out.println("Current balance is: " +balance );
		 }
		 else if(previousTransaction < 0) {
			 System.out.println("Withdrawn: "+Math.abs(previousTransaction));
			 System.out.println("Current balance is: " +balance );
		 }
		 else
			 System.out.println("No transaction occured");
	 }
	 
	 void showMenu() {//method that shows the atm menu
		 char option = '0';
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.println("Welcome: "+customerName);
		 System.out.println("Your ID is: "+customerId);
		 System.out.println("\n");
		 System.out.println("A. Check Balance");
		 System.out.println("B. Deposit");
		 System.out.println("C. Withdraw");
		 System.out.println("D. Previous transaction");
		 System.out.println("E. Exit");

		 do {
			 System.out.println("===============================================");
			 System.out.println("Enter an option");
			 System.out.println("===============================================");
			 option = sc.next().charAt(0);
			 System.out.println("\n");
			 
			 switch(option) {
			 
			 case 'A':
				 System.out.println("---------------------------------");
				 System.out.println("Balance = "+balance);
				 System.out.println("---------------------------------");
				 System.out.println("\n");
				 break;
				 
			 case 'B':
				 System.out.println("---------------------------------");
				 System.out.println("Enter an amount to deposit:");
				 System.out.println("---------------------------------");
				 int amount = sc.nextInt();
				 deposit(amount);
				 System.out.println("\n");
				 break;
				 
			 case 'C':
				 System.out.println("---------------------------------");
				 System.out.println("Enter an amount to withdraw:");
				 System.out.println("---------------------------------");
				 int amount2 = sc.nextInt();
				 withdraw(amount2);
				 System.out.println("\n");
				 break;
				 
			 case 'D':
				 System.out.println("---------------------------------");
				 getPreviousTransaction();
				 System.out.println("---------------------------------");
				 System.out.println("\n");
				 break;
				 
			 case 'E':
				 System.out.println("*********************************");
				 break;
				 
			 default:
				 System.out.println("Invalid Option! Please enter again");
				 break;
			 }
		 }while(option != 'E');
		 
		 System.out.println("Thank You! Have a great day!");
	 }
}
