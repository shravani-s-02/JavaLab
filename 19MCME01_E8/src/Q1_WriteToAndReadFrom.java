import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q1_WriteToAndReadFrom {

	static Scanner enter = new Scanner(System.in);
	
	static void write(String file) throws IOException {
		String FirstName, LastName, Position, Institute; 
		double Salary = 0;
		
		//Enter the data
		System.out.print("\nEnter the details,\nEnter the First name:");
		FirstName = enter.next();
		
		System.out.print("Enter the Last name:");
		LastName = enter.next();
		
		@SuppressWarnings("unused")
		String aString = enter.nextLine();
		System.out.print("Enter the Position:");
		Position = enter.nextLine();
		
		System.out.print("Enter the Institute:");
		Institute = enter.nextLine();
		
		System.out.print("Enter the Salary:");
		Salary = enter.nextInt();
		
		//Data is appended to the file using buffered writer
		BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
		writer.newLine();
		
		writer.append(addSpaces(FirstName));
		writer.append(addSpaces(LastName));
		writer.append(addSpaces(Position));
		writer.append(addSpaces(Institute));
		writer.append(addSpaces(Double.toString(Salary)));
		
		writer.close();
	}
	
	static String addSpaces(String input) {
		StringBuilder sb = new StringBuilder(input);
		
		//Spaces are added to the end of data in each field 
		for(int i = 0 ; i < 23 - input.length(); i++) {
			sb.append(' ');
		}
		
		return sb.toString();
	}
	
	static void display(String file) throws IOException{
		String line;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
		//The field heading is read first so it is skipped and not displayed
		bufferedReader.readLine(); 
		
		//Lines of the file are read and displayed accordingly
	    while ((line = bufferedReader.readLine()) != null){
	    	System.out.print(line.charAt(0) + ". " + line.substring(23, 45).trim() + ", " + line.substring(46, 68).trim() + ", " + line.substring(69, 91).trim() + "\n");
	    }
	    
	    bufferedReader.close();
	}
	
	public static void main (String args[]) {
		int i = 0;
		String option1; 
		boolean cont = true;
		String file ="src/Q1_Data.txt";
		
		while(cont == true) {
			cont = false;
			do {
				i = 0;
				System.out.print ("Do you wish to enter data(Data) or Exit(Done):");
				option1 = enter.next();
				if(!(option1.equalsIgnoreCase("Data") || option1.equalsIgnoreCase("Done"))) {
					System.out.print("Option entered is invalid\n");
					i++;
				}
			}while(i == 1);
			
			if(option1.equalsIgnoreCase("Data")) {
				cont = true;
				
				try {
					write(file);
				} catch (IOException e) {
					System.out.print(e.getClass().getName() + "\n");
					System.out.print(e.getMessage() + "\n");
				}
			}
			
		}
		enter.close();
		
		try {
			display(file);
		} catch (IOException e) {
			System.out.print(e.getClass().getName() + "\n");
			System.out.print(e.getMessage() + "\n");
		}
	}
}
