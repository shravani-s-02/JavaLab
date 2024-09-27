package Q_2_Bank;

import java.util.Scanner;

class Bank {
	
	static Scanner enter = new Scanner(System.in);
			
	public static int  optionEnter1() {
		int number = 0, i = 0;
		do {
			i = 0;
			//User is prompted enter what option they wish to view
			System.out.print("\n\nDo you wish to view the account details(enter 1), perform a transaction(enter 2), transfer money between accounts(enter 3) or end the banking session(enter 4):" );
			number = enter.nextInt();	
			//If the input is invalid an error message is displayed
			if(number > 4 || number < 1) {
				System.out.print("\nThe number entered is invalid; enter 1, 2, 3 or 4 ");
				i++;
			}	
			//If the input is invalid it loops back to prompt the user to re enter, otherwise it exits the loop
		}while(i == 1);
		return number;
	}
	
	
	public static void view(String first, String sur, String address, long phone, double savingsBalance, double checkingBalance, double credit, double withdraw, double transfer) { 
		int i = 0, number = 0;
		
		do {
			i = 0;
			//User is prompted enter what option they wish to view
			System.out.print("\nDo you wish to view the, \n Account holders user details(enter 1) \nAccount holders banking details(enter 2) \nAll details(enter 3)"
					+ "\nEnter number:");
			number = enter.nextInt();
			
			System.out.print("\n-------------------------\n");
			if( number == 1) {
				System.out.print("The account holders firstname:" + first + "\nThe account holders surname:" + sur + "\nThe account holders address:" + address 
						+"\nThe account holders phone number :" + phone);
			}
			else if( number == 2) {
				System.out.print("The last amount credited:" + credit + "\nThe last amount withdrawn:" + withdraw
						+ "\nThe last amount transferred:" + transfer + "\nThe savings balance of the account:" + savingsBalance 
						+ "\nThe checking balance of the account:" + checkingBalance);
			}
			else if( number == 3) {
				System.out.print("The account holders firstname:" + first + "\nThe account holders surname:" + sur + "\nThe account holders address:" + address 
						+"\nThe account holders phone number :" + phone + "\nThe savings balance of the account:" + savingsBalance
						+"\nThe checking balance of the account:" + checkingBalance + "\nThe last amount credited:" + credit 
						+ "\nThe last amount withdrawn:" + withdraw + "\nThe last amount transferred:" + transfer);
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
	
	public static int optionEnter2(int option) {
		int number = 0, i = 0;
		
		do {
			if(option == 1) {
				System.out.print("\nDo you wish to perform the transaction for the savings account(enter 1) or checking account(enter 2):");
			}
			else {
				System.out.print("\nDo you wish to transfer money to the savings account(enter 1) or checking account(enter 2):");
			}
			//User is prompted enter what option they wish to proceed with
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
		//User is prompted to enter their account details
		System.out.print("Create your account.\n");
		System.out.print("\nEnter the account holder's first name:" );
		String first = enter.next();
		System.out.print("Enter the account holder's surname:");
		String sur = enter.next();
		System.out.print("Enter the account holder's address:");
		String address = enter.next();
		String temp = enter.nextLine();
		System.out.print("Enter the account holder's phone number:");
		long phone = enter.nextLong();
		System.out.print("Enter the intial deposit to be transfered into the savings account:");
		double savingsBalance = enter.nextDouble();
		System.out.print("Enter the intial deposit to be transfered into the checking account:");
		double checkingBalance = enter.nextDouble();
		
		System.out.print("\n-------------------------\nYour account has been created.\n-------------------------\n");
		
		//The bank account details are set
		BankAccount account = new BankAccount(1.0);
		account.setFirstName(first);
		account.setSurname(sur);
		account.setAddress(address);
		account.setPhoneNumber(phone);
		
		SavingsAccount savingsAccount = new SavingsAccount(savingsBalance);
		CheckingAccount checkingAccount = new CheckingAccount(checkingBalance);
		
		double amount = savingsAccount.interestAdd();
		System.out.print("\nSavings Balance after interest is added:" + savingsAccount.getBalance() + "\nAmount added: " + amount +"\n");
		
		int number1 = 1, number3 = 0, number2 = 0, j = 1;
		double input_credit = 0, input_withdraw = 0, transferAmount = 0, balance = 0, output1 = 0;
		
		while( number1 != 4 ){
			
			//If the option entered is 4 then it exits the while loop, otherwise it continue
			number1 = optionEnter1();
			
			//If option 1 is chosen then the account details of choice are displayed
			if( number1 == 1) {
				view(account.getFirstName(), account.getSurname(), account.getAddress(), account.getPhoneNumber(),  savingsAccount.getBalance(), checkingAccount.getBalance(), input_credit, input_withdraw, transferAmount);
			}
			
			
			//If option 2 is chosen then the user prompted to enter the transaction details 
			else if( number1 == 2) {
				
				number2 = optionEnter2(1);
				
				if(number2 == 1) {
					balance = savingsAccount.getBalance();
				}
				else {
					balance = checkingAccount.getBalance();
				}
				
				
				number3 = optionEnter3();
				
				if( number2 == 1) {
					
					if( number3 == 1) {
						do {
							j = 0;
							//User is prompted enter the amount they wish to credit
							System.out.print("\nEnter the amount you wish to credit to the account:");
							input_credit = enter.nextDouble();
							output1 = savingsAccount.credit(input_credit);
							//If the input is invalid an error message is displayed
							if( output1 == 1) {
								System.out.print("Amount entered is invalid, enter a positive number.\n");
								j++;
							}
							//If the input is invalid (return value is 1)it loops back to prompt the user to re enter, otherwise it exits the loop	
						}while( j == 1);
					}
					
					else if( number3 == 2) {
						do {
							j = 0;
							//User is prompted enter the amount they wish to withdraw
							System.out.print("\nEnter the amount you wish to withdraw from the account:");
							input_withdraw = enter.nextDouble();
							output1 = savingsAccount.withdraw(input_withdraw);
							//If the input is invalid an error message is displayed
							if(output1 == 1) {
								System.out.print("Amount entered is invalid, enter a positive number.\n");
								j++;
							}
							if(output1 == 2) {
								System.out.print("Balance is " + balance + ". Funds are insufficent.\n");
								j ++ ;
							}
							//If the input is invalid(return is 1 or 2) it loops back to prompt the user to re enter, otherwise it exits the loop	
						}while( j == 1);
					}
					System.out.print("Savings account "); 
					savingsAccount.displayBalance();
				}
				
				else if(number2 == 2) {
					if( number3 == 1) {
						do{
							j = 0;
							//User is prompted enter the amount they wish to credit
							System.out.print("\nEnter the amount you wish to credit to the account:");
							input_credit = enter.nextDouble();
							output1 = checkingAccount.credit(input_credit);
							//If the input is invalid an error message is displayed
							if( output1 == 1) {
								System.out.print("Amount entered is invalid, enter a positive number.\n");
								j++;
							}
							//If the input is invalid (return value is 1)it loops back to prompt the user to re enter, otherwise it exits the loop	
						}while( j == 1);
					}
					
					else if( number3 == 2) {
						do {
							j = 0;
							//User is prompted enter the amount they wish to withdraw
							System.out.print("\nEnter the amount you wish to withdraw from the account:");
							input_withdraw = enter.nextDouble();
							output1 = checkingAccount.withdraw(input_withdraw); 
							//If the input is invalid an error message is displayed
							if(output1 == 1) {
								System.out.print("Amount entered is invalid, enter a positive number.\n");
								j++;
							}
							if(output1 == 2) {
								System.out.print("Balance is " + balance + ". Funds are insufficent.\n");
								j ++ ;
							}
							//If the input is invalid(return is 1 or 2) it loops back to prompt the user to re enter, otherwise it exits the loop	
						}while( j == 1);
					}
					
					if(output1 == 0) {
						System.out.print("\nNumber of free transactions left:" + checkingAccount.getFreeTransactionNum() + "\nChecking account ");
					}
					else {
						System.out.print("Transaction fees:"+ checkingAccount.getTransactionFees() + "\nChecking account ");
					}
					checkingAccount.displayBalance();
				}
			}
			
			else if(number1 == 3){
				number2 = optionEnter2(2);
				
				do{
					j = 0;
					System.out.print("Enter amount to transfer:");
					transferAmount = enter.nextDouble();
					
					if(number2 == 1) {
						output1 = savingsAccount.transfer(checkingAccount, transferAmount);
					} 
					else {
						output1 = checkingAccount.transfer(savingsAccount, transferAmount);
					}
					
					if(output1 == 1) {
						System.out.print("Amount entered is invalid, enter a positive number.\n");
						j++;
					}
					else if(output1 == 2) {
						System.out.print("Balance is " + balance + ". Funds are insufficent.\n");
						j ++ ;
					}
					
				}while(j == 1);
				
				System.out.print("Savings account ");
				savingsAccount.displayBalance();
				System.out.print("\nChecking account ");
				checkingAccount.displayBalance();
			}
		}
	
		System.out.print("\n-------------------------\nSavings account " );
		savingsAccount.displayBalance();
		System.out.print("\nChecking account ");
		checkingAccount.displayBalance();
		System.exit(0);
	}
}
	

