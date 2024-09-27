

import java.util.Scanner;

public class Q_5_PrintVisitingCard {

	static Scanner enter = new Scanner(System.in);
	
	class VistingCard{
		String firstName, surname, companyName, companyPosition, email, website, address ;
		long phoneNum;
		
		public VistingCard(String firstName, String surname, String companyName, String companyPosition, long phoneNum, String email, String website, String address) {
			this.firstName = firstName;
			this.surname = surname;
			this.companyName = companyName;
			this.companyPosition = companyPosition;
			this.phoneNum = phoneNum;
			this.email = email;
			this.website = website;
			this.address = address;
		}
		
		public String getFirstName() {
			return firstName;
		}
		
		public String getSurname() {
			return surname;
		}
		
		public String getCompanyName() {
			return companyName;
		}
		
		public String getCompanyPosition() {
			return companyPosition;
		}
		
		public long getPhoneNum() {
			return phoneNum;
		}
		
		public String getEmail() {
			return email;
		}
		
		public String getWebsite() {
			return website;
		}

		public String getAddress() {
			return address;
		}
	}
	
	public static void print(String firstName, String surname, String companyName, String companyPosition, long phoneNum, String email, String website, String address) {
		System.out.print("\n--------------------------------------\n|\t\t" + companyName + "\n|\t\t" + firstName + " " + surname + " \n|\t\t"+companyPosition 
				+ "\n|\n| Phone number:"+phoneNum + "\n| Email id:" + email + "\n| Website:"+website + "\n| Company address:"+address
				+ "\n--------------------------------------\n");
	}

	public static void main(String[] args) {
		Q_5_PrintVisitingCard Q5P = new Q_5_PrintVisitingCard();
		VistingCard user;
		
		System.out.print("Enter the details to be printed onto the visting card.");
		System.out.print("\nFirst Name:");
		String firstName = enter.next();
		System.out.print("Surname:");
		String surname = enter.next();
		System.out.print("Company Name:");
		String companyName = enter.next();
		System.out.print("Company Position:");
		String companyPosition = enter.next();
		System.out.print("Phone Number:");
		long phoneNum = enter.nextLong();
		System.out.print("Email Id:");
		String email = enter.next();
		System.out.print("Website:");
		String website = enter.next();
		System.out.print("Company Address:");
		String address = enter.next();
		
		//The user data is set.
		user = Q5P.new VistingCard(firstName, surname, companyName, companyPosition, phoneNum, email, website, address);
		
		//The user's data is obtained and the output is printed in a pre built format.
		print(user.getFirstName(), user.getSurname(), user.getCompanyName(), user.getCompanyPosition(), user.getPhoneNum(), user.getEmail(), user.getWebsite(), user.getAddress());
	}

}
