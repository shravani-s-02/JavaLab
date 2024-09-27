package Q_1_Inheritance;

public class PermenantEmployee extends Employee {
	double epf = 25*salary/100;
	
	PermenantEmployee(int id, String name, double salary){
		super(id, name, salary);
	}
	
	public double calculateEPF(){
		return epf;
	}
}
