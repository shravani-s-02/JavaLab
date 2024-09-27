package Q_1_Inheritance;

public class TemporaryEmployee extends Employee {
	int probationaryPeriod;
	double DailyWages;
	
	TemporaryEmployee(int id, String name, double salary, double DailyWages, int probationaryPeriod) {
		super(id, name, salary);
		this.DailyWages = DailyWages;
		this.probationaryPeriod = probationaryPeriod;
	}
		
	public void viewProgress() {
		System.out.print("\nProbationary Period Progress:" + probationaryPeriod );
	}
	
	public double March2021() {
		return 31*DailyWages;
	}
	
	public void display() {
		System.out.print("\nId:" + id + "\nName:" + name ); 
		viewProgress() ;
		System.out.print("\nSalary during probationary period progressed:" + salary + "\nSalary for March 2021:" + March2021());
	}
}
