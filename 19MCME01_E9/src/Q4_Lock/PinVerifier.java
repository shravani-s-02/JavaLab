package Q4_Lock;

public class PinVerifier {
	private String pin = "32174";
	
	public boolean Verify(String enteredPin) {
		return pin.equals(enteredPin);
	}
}
