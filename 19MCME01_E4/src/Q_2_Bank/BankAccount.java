package Q_2_Bank;

public class BankAccount {
	String first = "a";
	String sur = "a";
	String address = "a";
	long phone = 0;
	double balance = 0;
	
	BankAccount(double balance){
		this.balance = balance;
	}
	
	public void setFirstName(String first) {
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
	
	public int credit(double amount) {
		//If the amount to be credited is less than 0,  1 is returned
		if(amount < 0) {
			return 1;
		}
		//If the amount to be credited is valid it is added to the balance
		balance += amount;
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
		return 0;
	}
	
	public void displayBalance() {
		System.out.print("balance:" + balance);
	}
	
	public int transfer(BankAccount transferFrom, double amount) {
		if(amount < 0) {
			return 1;
		}
		if( transferFrom.getBalance() < amount) {
			return 2;
		}
		transferFrom.setBalance(transferFrom.getBalance() - amount);
		balance += amount;
		return 0;
		
	}
}
