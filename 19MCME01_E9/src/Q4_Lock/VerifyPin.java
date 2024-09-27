package Q4_Lock;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerifyPin {
	JFrame pinVerification;
	JTextField displayEnter;
	JButton[] button = new JButton[10];
	JButton clear = new JButton("CLEAR"), enter = new JButton("Enter");
	String enteredPin = "";
	boolean isLocked = true;

	@SuppressWarnings("serial")
	public class VerifyPinEntered extends JFrame {
		VerifyPinEntered() {
			PinVerifier PIN = new PinVerifier();
			pinVerification = new JFrame("Lock(Locked)");
			displayEnter = new JTextField("");

			// TItle of the frame will display the status
			if (isLocked == true) {
				pinVerification.setTitle("Lock(Locked)");
			} else {
				pinVerification.setTitle("Lock(Unlocked)");
			}
			
			//The alignment and the position of the text field is set
			displayEnter.setHorizontalAlignment(JTextField.RIGHT);			
			displayEnter.setBounds(1, 1, 285, 40);

			ActionListener pinEnterListener = new ActionListener() {
				@Override
				//When a button is pressed
				public void actionPerformed(ActionEvent e) {
					//Clears the display text for re entry of pin
					if (displayEnter.getText().equals("CLOSE") || displayEnter.getText().equals("WRONG PIN")) {
						displayEnter.setText("");
					}
					
					//The number of the button pressed is added to the string holding th estring value
					enteredPin += String.valueOf(e.getActionCommand());

					//Asterisk are displayed in place of the numbers
					displayEnter.setText(displayEnter.getText() + "*");
				}
			};

			for (int i = 0; i < 10; i++) {
				button[i] = new JButton(String.valueOf(i));
				button[i].addActionListener(pinEnterListener);
			}

			enter.addActionListener(new ActionListener() {
				//When the enter button is pressed
				public void actionPerformed(ActionEvent e) {
					// If the pin is correct the text OPEN is displayed and isLocked is set to false
					if (PIN.Verify(enteredPin)) {
						displayEnter.setText("OPEN");
						isLocked = false;
						pinVerification.setTitle("Lock(Unlocked)");
					}
					// Otherwise WRONG PIN is displayed
					else {
						displayEnter.setText("WRONG PIN");
					}
					enteredPin = "";
				}
			});

			clear.addActionListener(new ActionListener() {
				//If the clear button is clicked the display text is et to CLOSE and the it is locked
				public void actionPerformed(ActionEvent e) {
					displayEnter.setText("CLOSE");
					isLocked = true;
					pinVerification.setTitle("Lock(Locked)");
					enteredPin = "";
				}
			});

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// Setting the bounds of the button
			button[1].setBounds(1, 41, 95, 40);
			button[2].setBounds(96, 41, 95, 40);
			button[3].setBounds(191, 41, 95, 40);
			button[4].setBounds(1, 81, 95, 40);
			button[5].setBounds(96, 81, 95, 40);
			button[6].setBounds(191, 81, 95, 40);
			button[7].setBounds(1, 121, 95, 40);
			button[8].setBounds(96, 121, 95, 40);
			button[9].setBounds(191, 121, 95, 40);
			clear.setBounds(1, 161, 95, 40);
			button[0].setBounds(96, 161, 95, 40);
			enter.setBounds(191, 161, 95, 40);

			// Adding the buttons to the frame
			pinVerification.add(enter);
			pinVerification.add(clear);
			for (int i = 0; i < 10; i++) {
				pinVerification.add(button[i]);
			}
			pinVerification.add(displayEnter);

			pinVerification.setSize(300, 240);
			pinVerification.setLayout(null);
			pinVerification.setVisible(true);
		}

	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		VerifyPin Q2 = new VerifyPin();

		VerifyPinEntered display = Q2.new VerifyPinEntered();
	}

}
