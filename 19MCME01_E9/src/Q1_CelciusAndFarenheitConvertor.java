
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Q1_CelciusAndFarenheitConvertor {

	Label temperatureEnterUnit, titleText, result;
	Button convert, mode;
	TextField enterTemperature;
	String ctof = "C->F";
	String ftoc = "F->C";

	@SuppressWarnings("serial")
	public class TempUnitConvertor extends Frame implements WindowListener, ActionListener {
		TempUnitConvertor() {
			Frame UnitConvertor = new Frame("Temperature unit converter");

			mode = new Button(ctof);
			convert = new Button("Convert");
			enterTemperature = new TextField(10);
			result = new Label();
			titleText = new Label();
			temperatureEnterUnit = new Label("Enter in Celcius:");

			//Setting the positions of the components
			titleText.setBounds(175, 75, 150, 20);
			mode.setBounds(200, 100, 100, 20);
			temperatureEnterUnit.setBounds(70, 150, 100, 20);
			enterTemperature.setBounds(200, 150, 100, 20);
			convert.setBounds(200, 200, 100, 20);
			result.setBounds(200, 250, 100, 20);

			mode.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//If the label of the button is currently F->C when pressed it is changed to C->F
					if (e.getActionCommand().equals(ftoc)) {
						mode.setLabel(ctof);
						temperatureEnterUnit.setText("Enter in Celcius:");
						result.setText("");
					}
					//If the label of the button is currently C->F when pressed it is changed to F->C
					else if (e.getActionCommand().equals(ctof)) {
						mode.setLabel(ftoc);
						temperatureEnterUnit.setText("Enter in Fareinheit:");
						result.setText("");
					}
				}
			});

			convert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String conv = mode.getLabel();
					Double temp = Double.valueOf(enterTemperature.getText());
					String resultTemp = "";
					//When the button convert is pressed
					//If it the button label is C->F it converts the value entered in the text field from celsius to fahrenheit
					if (conv.equals(ctof)) {
						temp = ((9 * temp) / 5) + 32;
						resultTemp = "In Farenheit : " + Math.rint(temp*100)/100;
					}
					//If it the button label is F->C it converts the value entered in the text field from fahrenheit to celsius
					else if (conv.equals(ftoc)) {
						temp = (temp - 32) * (5.0 / 9);
						resultTemp = "In Celcius : " + Math.rint(temp*100)/100;
					}
					result.setText(resultTemp.toString());
				}
			});
			
			UnitConvertor.addWindowListener((WindowListener) new WindowAdapter() {
		        public void windowClosing(WindowEvent we) {
		        	UnitConvertor.dispose();
		            System.exit(0);
		     	}
			});
			
			//Adding the components to the frame
			UnitConvertor.add(titleText);
			UnitConvertor.add(convert);
			UnitConvertor.add(mode);
			UnitConvertor.add(enterTemperature);
			UnitConvertor.add(temperatureEnterUnit);
			UnitConvertor.add(result);

			UnitConvertor.setSize(400, 300);
			UnitConvertor.setLayout(null);
			UnitConvertor.setVisible(true);
		}

		public void windowClosing(WindowEvent e) {}
		public void windowOpened(WindowEvent e) {}
		public void windowActivated(WindowEvent e) {}
		public void windowIconified(WindowEvent e) {}
		public void windowDeiconified(WindowEvent e) {}
		public void windowDeactivated(WindowEvent e) {}
		public void windowClosed(WindowEvent e) {}
		public void actionPerformed(ActionEvent e) {}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Q1_CelciusAndFarenheitConvertor Q1 = new Q1_CelciusAndFarenheitConvertor();

		TempUnitConvertor convert = Q1.new TempUnitConvertor();

	}

}
