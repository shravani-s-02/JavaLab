package Q_2_Numbers;

public class IMTechComplex implements IMTechNumber {
	float real = 0, imag = 0; 
	
	IMTechComplex(float real, float imag){
		this.real = real;
		this.imag = imag;
	}
	
	public float getReal() {
		return real;
	}
	
	public float getImag() {
		return imag;
	}
	
	public double getMag() {
		return Math.sqrt(Math.pow(real, 2) + Math.pow(imag, 2));
	}

	public boolean equalsTo(Object num) {
		IMTechComplex compare = (IMTechComplex) num;

		if(this.getMag() == compare.getMag()) {
			return true; 
		}
		return false;
	}

	public int compareTo(Object num) {
		IMTechComplex compare = (IMTechComplex) num;
		
		if(this.getMag() == compare.getMag()) {
			return 0;
		}
		else if(this.getMag() > compare.getMag()) {
			return -1;
		}
		return 1;
	}

	public IMTechNumber addTo(Object num) {
		
		float compareReal;
		float compareImag;
		
		//If the object is an integer the complex part is 0
		if (num.getClass().equals(IMTechInteger.class)) {
			IMTechInteger numInteger = (IMTechInteger) num;			
			compareReal = numInteger.getNum();
			compareImag = 0;
		}
		else {
			IMTechComplex compare;
			compare = (IMTechComplex) num;
			compareReal = compare.getReal();
			compareImag = compare.getImag();
		}

		return new IMTechComplex(this.real + compareReal, this.imag + compareImag);
	}

	public IMTechNumber subFrom(Object num) {
		IMTechComplex compare = (IMTechComplex) num;
		float compareReal = compare.getReal();
		float compareImag = compare.getImag();

		return new IMTechComplex(this.real - compareReal, this.imag - compareImag);
	}

	public IMTechNumber multWith(Object num) {
		IMTechComplex compare = (IMTechComplex) num;
		float compareReal = compare.getReal();
		float compareImag = compare.getImag();

		//Formula of multiplication of 2 complex numbers is (a+bi).(c+di) = (ac−bd) + (ad+bc)i
		return new IMTechComplex(this.real*compareReal - this.imag*compareImag, this.real*compareImag + this.imag*compareReal);
	}

	public IMTechNumber divideBy(Object num) {
		IMTechComplex compare = (IMTechComplex) num;
		float compareReal = compare.getReal();
		float compareImag = compare.getImag();
		
		//Formula of division of 2 complex numbers is (a+bi)/(c+di) = ((ac−bd)/c^2+d^2) + ((bc-ad)//c^2+d^2)i
		float denom = compareReal*compareReal + compareImag*compareImag;
		float numReal = this.real*compareReal + this.imag*compareImag;
		float numImag = this.imag*compareReal - this.real*compareImag;
		
		return new IMTechComplex(numReal/denom, numImag/denom);
	}
}