

public class Q_4_LuckyNumbers {

	class LuckyNumber{
		public int Count(int sum) {
			int count = 0, temp = 1;
			//The number of digits in the pin number are counted by counting the number of times the "temp" variable is multiplied by 10 until it's greater or equal to the number. 
			while (temp <= sum) {
			    count++;
			    temp*=10;
			}
			return count;
		}
		
		public int AddDigits(int number) {
			int sum = 0;
			while(number > 0) {
				//Remainder of a number divided by 10 is the last digit of the number.
				sum += number%10;
				//Divided by ten to remove the last digit of the number(number is an integer so the decimal point will be removed).
				//The next digit(now last digit) will be added.
				number /= 10;
			}
			return sum;
		}
		
		public int Order(int number) {
			int order = number;
			//The digits of the number are added together until there is only one digit remaining. 
			while(Count(order) > 1) {
				order = AddDigits(order);
			}
			
			return order;
			
		}
		
	}	
	
	public static void main(String[] args) {
		Q_4_LuckyNumbers Q4L = new Q_4_LuckyNumbers();
		LuckyNumber order1;
		order1 = Q4L.new LuckyNumber();
		int count = 0;
		
		//The number from 1 to 1000 are iterated through and if their order is 3 then the count is increased. 
		for(int i = 1; i < 1000; i++) {
			if(order1.Order(i) == 3){
				count++;
			}
		}
		
		System.out.print("Number of digits less than 1000 that have order 3:" + count);		
	}

}
