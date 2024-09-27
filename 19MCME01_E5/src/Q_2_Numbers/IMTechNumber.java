package Q_2_Numbers;

public interface IMTechNumber{
	String toString();
	boolean equalsTo(Object num);
	int compareTo(Object num);
	IMTechNumber addTo(Object num);
	IMTechNumber subFrom(Object num);
	IMTechNumber multWith(Object num);
	IMTechNumber divideBy(Object num);
}