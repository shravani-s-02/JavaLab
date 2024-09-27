package Q_2_Bank;

public class SavingsAccount extends BankAccount {
	
	double interestRate = 3.5, interestAmount = 0;
	SavingsAccount(double savingBalance){
		super(savingBalance);
	}
	
	public double interestAdd() {
		interestAmount = interestRate*balance/100;
		balance += interestAmount;
		return interestAmount;
	}
}
