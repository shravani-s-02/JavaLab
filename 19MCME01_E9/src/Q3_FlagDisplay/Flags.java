package Q3_FlagDisplay;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Flags {
	JFrame display;
	JLabel flagLabel = new JLabel("Flag of France"), flag;
	
	@SuppressWarnings("serial")
	public class DisplayFlags extends JFrame {
		DisplayFlags() throws IOException {
			display = new JFrame("Switch between flags of France and Germany");
			JPanel flagPanel = new JPanel();
			flag = new JLabel("");
			
			//Intialize buffered images of the two flags
			BufferedImage france = ImageIO.read(this.getClass().getResource("FranceFlag.png"));
			BufferedImage germany = ImageIO.read(this.getClass().getResource("GermanyFlag.png"));
			flag.setIcon(new ImageIcon(france));
			//Add the label w
			flagPanel.add(flag);
			
			flag.setBounds(1, 1, 500, 300);
			flagLabel.setBounds(550, 150, 100, 20);
			
			ActionListener switchFlag = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//If the flagLabel is "Flag of France" then the flag icon is changed to Germany and the flagLabel is changed to "Flag of Germany"
					if (flagLabel.getText().equals("Flag of France")) {
						flag.setIcon(new ImageIcon(germany));
						flagLabel.setText("Flag of Germany");
					//If the flagLabel is "Flag of Germany" then the flag icon is changed to France and the flagLabel is changed to "Flag of France"
					} else if (flagLabel.getText().equals("Flag of Germany")) {
						flag.setIcon(new ImageIcon(france));
						flagLabel.setText("Flag of France");
					}
				}
			};
			
			//The switchFlag action will occur every 1000 milliseconds  
			Timer switchTime = new Timer(1000, switchFlag);
			switchTime.setRepeats(true);
			switchTime.start();

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//The flag panel and the label of the flag are added to the frame
			display.add(flagLabel);
			display.add(flagPanel);

			display.pack();
		    
			display.setSize(700, 350);
			display.setLayout(null);
			display.setVisible(true);
		}

	}

	public static void main(String[] args) {
		Flags Q3 = new Flags();

		try {
			@SuppressWarnings("unused")
			DisplayFlags display = Q3.new DisplayFlags();
		} catch (IOException e) {
			System.out.print(e.getClass().getName() + "\n");
			System.out.print(e.getMessage() + "\n");
		}
	}
}
