package Bank.MiniBank.Accounts;

import java.util.*;

class Customer{
	String name;
	int accountNumber;
	double balance;
	
	public Customer(String name, int accountNumber, double balance) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void credit(double balance) {
		this.balance += balance;
	}
	public void debit(double balance) {
		this.balance -= balance;
	}
	public void display() {
		System.out.println("\nAccount Number\t:\t" + accountNumber);
		System.out.println("Name\t:\t" + name);
		System.out.println("Balance\t:\t" + balance+"\n");
	}
}
public class MiniBank {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<Customer> customer = new ArrayList<>();
		int flag = 0;
		
		customer.add(new Customer("Pankhuri Goel", 102, 10000.0D));
		customer.add(new Customer("Rupanshi Goel", 103, 10000.0D));
		
		while(true) {
			
			System.out.println("1. Create Account");
			System.out.println("2. Debit Amount");
			System.out.println("3. Credt Amount");
			System.out.println("4. Display Account Details");
			System.out.println("5. Exit");
			System.out.print("Enter Your Choice : ");
			
			int ch = sc.nextInt();
			
			switch(ch) {
			
			case 1: {
				customer.add(new Customer("Mohak Goel", 101, 10000.0D));
				System.out.println("\nAccount created Successfully!\n");
				break;
				}
			case 2: {
				try{
					customer.stream().filter(c -> 101==c.getAccountNumber()).findAny().orElse(null).debit(500);
				}
				catch(NullPointerException n){
					System.out.println("Invalid Account Number!");
				}
				customer.get(0).debit(500.0D);
				System.out.println("\nAmount debitted Successfully!\n");
				break;
				}
			case 3: {
				try{
					customer.stream().filter(c -> 101==c.getAccountNumber()).findAny().orElse(null).credit(500);
				}
				catch(NullPointerException n){
					System.out.println("Invalid Account Number!");
				}
				System.out.println("\nAmount credited Successfully!\n");
				break;
				}
			case 4: {
				try{
					customer.stream().filter(c -> 101==c.getAccountNumber()).findAny().orElse(null).display();
				}
				catch(NullPointerException n){
					System.out.println("Invalid Account Number!");
				}
				//customer.get(0).display();
				break;
				}
			case 5: {
				flag = 1;
				break;
				}
			default: {
				System.out.println("Invalid Input!");
				}
			}
			
			if(flag == 1)
			{
				System.out.println("\nExit successful!\n");
				break;
			}
			
		}
		
		System.out.println("Thank You!");

	}

}
