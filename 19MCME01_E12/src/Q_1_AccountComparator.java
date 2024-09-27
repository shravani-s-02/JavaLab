import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class BankAccount{
	String first = "a";
	String sur = "a";
	String address = "a";
	long phone = 0;
	double balance = 0;
	
	public BankAccount(String first, String sur, String address, long phone, double balance) {
		this.first = first;
		this.sur = sur;
		this.address = address;
		this.phone = phone;
		this.balance = balance;
	}
}

class AccountComparator implements Comparator<BankAccount>{
	//Compares the account's balance
	public int compare(BankAccount Account1, BankAccount Account2) {
		return Double.valueOf(Account1.balance).compareTo(Double.valueOf(Account2.balance));
	}
	
}

public class Q_1_AccountComparator {
	public static void main(String[] args) {
			List<BankAccount> AccountList = new ArrayList<BankAccount>();
			
			//Creating bank accounts and adding them to the list
			AccountList.add(new BankAccount("Qwe", "Rty", "Hyderabad", 908775432, 125000));
			AccountList.add(new BankAccount("Asd", "Fgh", "Dehli", 912345678, 200000));
			AccountList.add(new BankAccount("Zxc", "Vbn", "Banglore", 809335432, 100000));
			AccountList.add(new BankAccount("Uio", "Jkl", "Pune", 973325678, 150000));
			AccountList.add(new BankAccount("Plm", "Qaz", "Hyderabad", 817345658, 2250000));
			AccountList.add(new BankAccount("Vfr", "Bhu", "Chennai", 912345345, 115000));
	
			//Printing unsorted
			System.out.print("Unsorted bank accounts:\nAccount Holder Name, Balance\n");
			for(BankAccount Account : AccountList) {
				System.out.print(Account.first + " " + Account.sur + ", "  + Account.balance + "\n");
			}
			
			//Sorting the accounts in the list with the comparator which compares based on the account balance
			Collections.sort(AccountList, new AccountComparator());
			
			//Printing sorted
			System.out.print("\nSorted bank accounts:\nAccount Holder Name, Balance\n");
			for(BankAccount Account : AccountList) {
				System.out.print(Account.first + " " + Account.sur + ", "  + Account.balance + "\n");
			}

	}
}

