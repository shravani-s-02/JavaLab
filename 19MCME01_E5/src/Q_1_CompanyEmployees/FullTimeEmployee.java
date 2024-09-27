package Q_1_CompanyEmployees;

public class FullTimeEmployee extends Employee {
	int monthlyRate = 10000, months = 0;
	
	FullTimeEmployee(int months){
		this.months = months;
	}
	
	public void computePay() {
		yearToDateEarnigs = months*monthlyRate;
	}
}
