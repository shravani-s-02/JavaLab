package Q_1_CompanyEmployees;

public class PartTimeEmployee extends Employee {
	int hours = 0, hourlyRate = 100;
	
	PartTimeEmployee(int hours){
		this.hours = hours;
	}
	
	public void computePay() {
		yearToDateEarnigs = hours*hourlyRate;
	}
}
