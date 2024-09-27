import java.util.Scanner;

public class Q_7_Bank {
	
	static Scanner enter = new Scanner(System.in);
	
	public class Bank{
		String first = "a";
		String sur = "a";
		String address = "a";
		long phone = 0;
		double balance = 0;
		
		public void setFirstName(String first ) {
			this.first = first;
		}
		public String getFirstName() {
			return first;
		}
		
		public void setSurname(String sur) {
			this.sur = sur;
		}
		public String getSurname() {
			return sur;
		}
		
		public void setAddress(String address) {
			this.address = address;
		}
		public String getAddress() {
			return address;
		}
		
		public void setPhoneNumber(long phone) {
			this.phone = phone;
		}
		public long getPhoneNumber() {
			return phone;
		}
		
		public void setBalance(double balance) {
			this.balance = balance;
		}
		public double getBalance() {
			return balance;
		}
		
		public int Credit(double amount) {
			//If the amount to be credited is less than 0,  1 is returned
			if(amount < 0) {
				return 1;
			}
			//If the amount to be credited is valid it is added to the balance
			balance += amount;
			System.out.print("Balance:" + balance +"\n");
			return 0;
		}
		
		public int Withdraw(double amount) {
			//If the amount to be withdrawn is less than 0,  1 is returned
			if(amount < 0) {
				return 1;
			}
			//If the amount to be withdrawn is less than 0,  2 is returned
			else if (balance - amount < 0 ) {
				return 2;
			}
			//If the amount to be withdrawn is valid it is removed from the balance
			balance -= amount; 
			System.out.print("Balance:" + balance + "\n");
			return 0;
		}
		
			
	}
	
	public static int  optionEnter1() {
		int number = 0, i = 0;
		do {
			i = 0;
			//User is prompted enter what option they wish to view
			System.out.print("\nDo you wish to view the account details(enter 1), perform a transaction(enter 2) or end the banking session(enter 3):" );
			number = enter.nextInt();	
			//If the input is invalid an error message is displayed
			if(number >3 || number < 1) {
				System.out.print("\nThe number entered is invalid; enter 1, 2, or 3");
				i++;
			}	
			//If the input is invalid it loops back to prompt the user to re enter, otherwise it exits the loop
		}while(i == 1);
		return number;
	}
	
	public static void optionEnter2(String first, String sur, String address, long phone, double balance, double credit, double withdraw) { 
		int i = 0, number = 0;
		
		do {
			i = 0;
			//User is prompted enter what option they wish to view
			System.out.print("\nDo you wish to view the, \n Account holders firstname(enter 1) \nAccount holders surname(enter 2) \nAccount holders address(enter 3)"
				+ "\nAccount holders phone number(enter 4) \nAccount holders balance(enter 5) \nAccount holders last credit(enter 6) \nAccount holders last withdraw(enter 7) "
				+ "\nAll details(enter8) \nEnter number:");
			number = enter.nextInt();
			
			System.out.print("\n-------------------------\n");
			if( number == 1) {
				System.out.print("The account holders firstname:" + first);
			}
			else if( number == 2) {
				System.out.print("The account holders surname:" + sur);
			}
			else if( number == 3) {
				System.out.print("The account holders address:" + address);
			}
			else if( number == 4) {
				System.out.print("The account holders phone number :" + phone);
			}
			else if( number == 5) {
				System.out.print("The balance of the account:" + balance);
				
			}
			else if( number == 6) {
				System.out.print("The last amount credited to  the account:" + credit);
			}
			else if( number == 7) {
				System.out.print("The last amount withdrawn from the account:" + withdraw);
			}
			else if( number == 8) {
				System.out.print("The account holders firstname:" + first + "\nThe account holders surname:" + sur + "\nThe account holders address:" + address 
						+"\nThe account holders phone number :" + phone + "\nThe balance of the account:" + balance 
						+ "\nThe last amount credited to the account:" + credit + "\nThe last amount withdrawn from the account:" + withdraw);
			}
			//If the input is invalid an error message is displayed
			else {
				System.out.print("\nThe number entered is invalid; enter a number between 1 and 8");
				i++;
			}
			//If the input is invalid it loops back to prompt the user to re enter, otherwise it exits the loop	
		}while(i == 1);
		System.out.print("\n-------------------------\n");
	}
	
	public static int optionEnter3() {
		int number = 0, i = 0;
		
		do {
			
			//User is prompted enter what option they wish to proceed with
			System.out.print("\nDo you wish to credit(enter 1) or withdraw(enter 2):");
			number = enter.nextInt();
			i = 0;
			//If the input is invalid an error message is displayed
			if(number < 1 || number > 2 ){
				System.out.print("The number entered is invalid, enter 1 or 2\n");
				i++;
			}
			//If the input is invalid it loops back to prompt the user to re enter, otherwise it exits the loop	
		}while(i == 1);
		return number;
	}
	
	public static void main(String[] args) {
		Q_7_Bank Q7C = new Q_7_Bank();
		Bank account; 
		
		//User is prompted to enter their account details
		System.out.print("Create your account.\n");
		System.out.print("\nEnter the account holder's first name:" );
		String first = enter.next();
		System.out.print("Enter the account holder's surname:");
		String sur = enter.next();
		System.out.print("Enter the account holder's address:");
		String address = enter.next();
		System.out.print("Enter the account holder's phone number:");
		long phone = enter.nextLong();
		System.out.print("Enter the intial deposit to be transfered into the account:");
		double balance = enter.nextDouble();
		
		System.out.print("\n-------------------------\nYour account has been created.\n-------------------------\n");
		
		account = Q7C.new Bank();
		
		//The bank account details are set
		account.setFirstName(first);
		account.setSurname(sur);
		account.setAddress(address);
		account.setPhoneNumber(phone);
		account.setBalance(balance);
		
		int number1 = 1, i = 0, number2 = 0;
		Double[] transaction = new Double[100];
		double input_credit = 0, input_withdraw = 0;
		
		while( number1 == 1 || number1 == 2){
			//If the option entered is 3 then it exits the while loop, otherwise it continue
			number1 = optionEnter1();
			
			//If option 1 is chosen then the account details of choice are displayed
			if( number1 == 1) {
				optionEnter2(account.getFirstName(), account.getSurname(), account.getAddress(), account.getPhoneNumber(), account.getBalance(), input_credit, input_withdraw);
			}
			
			//If option 2 is chosen then the user prompted to enter the transaction details 
			else if( number1 == 2) {
				int j = 0;
				double output = 0;
				i++;
				
				number2 = optionEnter3();
				
				//If the user wishes to credit then they're prompted to enter the credit amount
				if( number2 == 1) {
					do {
						j = 0;
						//User is prompted enter the amount they wish to credit
						System.out.print("\nEnter the amount you wish to credit to the account:");
						input_credit = enter.nextDouble();
						transaction[i] = input_credit;
						output = account.Credit(input_credit);
						//If the input is invalid an error message is displayed
						if( output == 1) {
							System.out.print("Amount entered is invalid, enter a positive number.\n");
							j++;
						}
						//If the input is invalid (return value is 1)it loops back to prompt the user to re enter, otherwise it exits the loop	
					}while( j == 1);
				}
				
				//If the user wishes to credit then they're prompted to enter the withdraw amount
				else if( number2 == 2) {
					do {
						j = 0;
						//User is prompted enter the amount they wish to withdraw
						System.out.print("\nEnter the amount you wish to withdraw from the account:");
						input_withdraw = enter.nextDouble();
						transaction[i] = -input_withdraw;	
						output = account.Withdraw(input_withdraw);
						//If the input is invalid an error message is displayed
						if(output == 1) {
							System.out.print("Amount entered is invalid, enter a positive number.\n");
							j++;
						}
						if(output == 2) {
							System.out.print("Balance is " + account.getBalance() + ". Funds are insufficent.\n");
							j += 2 ;
						}
						//If the input is invalid(retirn is 1 or 2) it loops back to prompt the user to re enter, otherwise it exits the loop	
					}while( j == 1 || j == 2);
				}
			}
		}
		
		System.out.print("\n-------------------------\nTransactions done:");
		//The transaction array is iterated through and the transaction values are displayed 
		for(int k = 1; k < i+1 ; k++) {
			if(transaction[k] < 0) {
				System.out.print("\n" + k + ") " + transaction[k]);
			}
			else {
				System.out.print("\n" + k + ") +" + transaction[k]);
			}
		}
		System.out.print("\n-------------------------\nBalance:" + account.getBalance());
		System.exit(0);
	}
}
	
