package Q_2_Numbers;

public class IMTechInteger implements IMTechNumber {
	float num = 0; 
	int num_digits = 0;
	boolean is_prime;
	
	IMTechInteger(float num){
		this.num = num;
		
		is_prime = true;
		//It's only possible for a number to be divisible by a number that is at least half of it   
		for(int i = 2; i <= num/2; i++) {
			//If a number is divisible by a number division with the number will result with a reminder equal to 0
			if(num % i == 0) {
				 is_prime = false;
				 break;
			}
		}
	}
	
	public float getNum() {
		return num;
	}
	
	public int getNumDigits() {
		num_digits = String.valueOf(num).length();
		return num_digits;
	}
	
	public boolean isPrime() {
		return is_prime;
	}
	
	public float getDigit(int dnum) {
		//Return integer value of substring of converted string num from dnum to dnum+1, i.e, at dnum(value returned withput interger value of is the ascii value of the digit) 
		return Integer.valueOf(String.valueOf(num).substring(dnum, dnum+1));
	}

	public boolean equalsTo(Object num) {
		IMTechInteger compare = (IMTechInteger)num;
		float compareInt = compare.getNum();
		boolean result = (this.num == compareInt);
		return result;
	}

	public int compareTo(Object num) {
		IMTechInteger compare = (IMTechInteger)num;
		float compareInt = compare.getNum();
		if (this.num > compareInt) {
			return -1;
		}
		else if (this.num < compareInt) {
			return 1;
		}
		return 0;
	}

	public IMTechNumber addTo(Object num) {
		IMTechInteger compare = (IMTechInteger)num;
		float compareInt = compare.getNum();
		return new IMTechInteger(this.num + compareInt);
	}

	public IMTechNumber subFrom(Object num) {
		IMTechInteger compare = (IMTechInteger)num;
		float compareInt = compare.getNum();
		return new IMTechInteger(this.num - compareInt);
	}

	public IMTechNumber multWith(Object num) {
		IMTechInteger compare = (IMTechInteger)num;
		float compareInt = compare.getNum();
		return new IMTechInteger(this.num * compareInt);
	}

	public IMTechNumber divideBy(Object num) {
		IMTechInteger compare = (IMTechInteger)num;
		float compareInt = compare.getNum();
		return new IMTechInteger(this.num / compareInt);
	}
}
