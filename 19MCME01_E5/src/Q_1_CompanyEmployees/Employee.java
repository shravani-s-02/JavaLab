package Q_1_CompanyEmployees;

abstract class Employee {
	
	int yearToDateEarnigs = 0;
	
	public int getYearToDateEarnings() {
		return yearToDateEarnigs;
	}
	
	public abstract void computePay();
	
	
}
