package Q_1_CompanyEmployees;

import java.util.Scanner;

public class TestingQ1 {

	public static void main(String[] args) {
		int i = 1, option = 0, workingPeriod = 0;
		
		Scanner enter = new Scanner(System.in);
		System.out.print("Enter employee details,\nEmployee Id:");
		int id = enter.nextInt();
		System.out.print("Employee name:");
		String name = enter.next();
		
		while(i == 1) {
			i = 0;
			System.out.print("\nDoes the employee work full time(enter 1) or part time(enter 2):");
			option = enter.nextInt();
			if(option > 2 || option < 1){
				System.out.print("Option entered is invalid, enter 1 or 2");
				i++;
				
			}
		}
		
		if(option == 1) {
			do{
				i = 0;
				System.out.print("\nEnter the number of months the employee has worked for:");
				workingPeriod = enter.nextInt();
				if(workingPeriod < 0) {
					System.out.print("Input entered is negetive enter a positive number");
					i++;
				}
			}while(i == 1);
			
			FullTimeEmployee test = new FullTimeEmployee (workingPeriod);
			test.computePay();
			System.out.print("\nEmployee ID:" +  id + "\nName of employee:" + name);
			System.out.print("\nYear to date earnings of the employee:" + test.getYearToDateEarnings());
		}
		
		else {
			do{
				i = 0;
				System.out.print("\nEnter the number of hours the employee has worked for:");
				workingPeriod = enter.nextInt();
				if(workingPeriod < 0) {
					System.out.print("Input entered is negetive enter a positive number");
					i++;
				}
			}while(i == 1);
		
			PartTimeEmployee test = new PartTimeEmployee(workingPeriod);
			test.computePay();
			System.out.print("\nEmployee ID:" +  id + "\nName of employee:" + name);
			System.out.print("\nYear to date earnings of the employee:" + test.getYearToDateEarnings());
		}
		
		enter.close();
	}

}
