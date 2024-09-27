package Q_2_Bank;

public class CheckingAccount extends BankAccount {
	int freeTransactionNum = 2, count = 0;
	//The transaction fees is fixed as 0.02 percent of the transaction amount
	double transactionRate = 0.02, transactionFees;
	
	CheckingAccount(double checkingBalance){
		super(checkingBalance);
	} 
	
	public int getFreeTransactionNum() {
		return freeTransactionNum;
	}
	
	public double getTransactionFees() {
		return transactionFees;
	}
	
	public void deductFees(double amount) {
		transactionFees = transactionRate*amount/100;
		balance -= transactionFees ;
	}
	
	public int credit(double amount) { 
		//If the amount to be credited is less than 0,  1 is returned
		if(amount < 0) {
			return 1;
		}
		//If the amount to be credited is valid it is added to the balance
		balance += amount;
		if(--freeTransactionNum <= 0) {
			deductFees(amount);
			return 3;
		}
		return 0;
	}
	
	public int withdraw(double amount) {
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
		if(--freeTransactionNum <= 0) {
			deductFees(amount);
			return 3;
		}
		return 0;
	}
	
}
