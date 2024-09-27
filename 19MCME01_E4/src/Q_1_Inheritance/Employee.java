package Q_1_Inheritance;

public class Employee {
	int id;
	String name;
	double salary;
	
	Employee(int id, String name, double salary){
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public void display() {
		System.out.print("\nId:" + id + "\nName:" + name + "\nSalary:" + salary);
	}
}
