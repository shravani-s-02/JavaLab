package Q2_TextDetails;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextDetailsDisplay {
	
	JButton displayButton;
	JTextField enterText; 
	JLabel characterCount, wordCount, longestWord, shortestWord;
	
	@SuppressWarnings("serial")
	public class DisplayTextDetails extends JFrame{
		DisplayTextDetails() {
			JFrame Display = new JFrame("Displays text details");
			
			displayButton = new JButton("Display");
			enterText = new JTextField();
			characterCount = new JLabel();
			wordCount = new JLabel();
			longestWord = new JLabel();
			shortestWord = new JLabel();
			
			//Setting the positions of the components
			enterText.setBounds(50, 100, 250, 20);
			displayButton.setBounds(300, 100, 100, 20);
			characterCount.setBounds(50, 150, 500, 20);
			wordCount.setBounds(50, 200, 500, 20);
			longestWord.setBounds(50, 250, 500, 20);
			shortestWord.setBounds(50, 300, 500, 20);
			
			displayButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FindTextDetails text = new FindTextDetails(enterText.getText());
					
					//The methods that find the details are called 
					characterCount.setText("Number of characters : " + String.valueOf(text.findCharCount()));
					wordCount.setText("Number of words : " + String.valueOf(text.findWordCount()));
					longestWord.setText("Longest word/s : " + text.findLongestWord());
					shortestWord.setText("Shortest word/s : " + text.findShortestWord());
				}
			});
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//Adding the components to the frame
			Display.add(displayButton);
			Display.add(enterText);
			Display.add(characterCount);
			Display.add(wordCount);
			Display.add(longestWord);
			Display.add(shortestWord);

			Display.setSize(500, 500);
			Display.setLayout(null);
			Display.setVisible(true);
		}
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		TextDetailsDisplay Q2 = new TextDetailsDisplay();
		
		DisplayTextDetails display = Q2.new DisplayTextDetails();
	}

}
