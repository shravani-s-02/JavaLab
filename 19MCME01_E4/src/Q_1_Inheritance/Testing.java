package Q_1_Inheritance;
import java.util.Scanner;

class Testing {
	
	public static void main(String[] args) {
		int i = 1, option = 0, probationaryPeriod = 0;
		double DailyWages = 0, salary = 0;
		
		Scanner enter = new Scanner(System.in);
		System.out.print("Enter employee details,\nEmployee Id:");
		int id = enter.nextInt();
		System.out.print("Employee name:");
		String name = enter.next();
		
		while(i == 1) {
			i = 0;
			System.out.print("\nIs the employee permenant(enter 1) or temporary(enter 2):");
			option = enter.nextInt();
			if(option > 2 || option < 1){
				System.out.print("Option entered is invalid, enter 1 or 2");
				i++;
				
			}
		}
		
		if(option == 1) {
			do{
				i = 0;
				System.out.print("\nEnter the employee's salary:");
				salary = enter.nextDouble();
				if(salary < 0) {
					System.out.print("Input entered is negetive enter a positive number");
					i++;
				}
			}while(i == 1);
			System.out.print("\nEnter the employee's salary:");
			salary = enter.nextDouble();
			PermenantEmployee test = new PermenantEmployee(id, name, salary);	
			test.display();
			System.out.print("\nEpf:"+ test.epf);
		}
		
		else {
			do{
				i = 0;
				System.out.print("\nEnter the daily wages of the temporary employee:");
				DailyWages = enter.nextDouble();
				if(DailyWages < 0) {
					System.out.print("Input entered is negetive enter a positive number");
					i++;
				}
			}while(i == 1);
			
			do{
				i = 0;
				System.out.print("\nEnter the temporary employee's probationary period progress(in days):");
				probationaryPeriod = enter.nextInt();
				if(probationaryPeriod < 0) {
					System.out.print("Input entered is negetive enter a positive number");
					i++;
				}
			}while(i == 1);
		
			salary = DailyWages*probationaryPeriod;
			TemporaryEmployee test = new TemporaryEmployee(id, name, salary,DailyWages, probationaryPeriod );
			test.display();
		}
		
		enter.close();
	}

}
