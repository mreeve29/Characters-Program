import BreezySwing.*;
import javax.swing.*;

public class CharacterGUI extends GBFrame{
	
	private JTextField inputField = addTextField("The dog and the cat ran and ran ..h.",1,1,3,1);
	private JButton enterButton = addButton("Enter",2,1,1,1);
	private JButton resetButton = addButton("Reset",2,2,1,1);
	private JButton exitButton = addButton("Exit",2,3,1,1);
	private JTextArea resultArea = addTextArea("",3,1,3,1);
	
	public void buttonClicked(JButton button) {
		if(button == enterButton) {
			String input = inputField.getText();
			if(input.length() == 0 || isEmpty(input)) {
				resultArea.setText("Error: empty input");
				return;
			}
			if(isInvalid(input)) {
				resultArea.setText("Error: All punctuation");
				return;
			}
			StringParser p = new StringParser(inputField.getText());
			p.generate();
			resultArea.setText(p.toString());
		}else if(button == resetButton) {
			inputField.setText("");
			inputField.requestFocus();
			resultArea.setText("");
		}else if(button == exitButton) {
			System.exit(1);
		}
	}
	
	private boolean isEmpty(String str) {
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) != ' ' || str.charAt(0) == '\t')return false;
		}
		return true;
	}
	
	private boolean isInvalid(String str) { 
		for(int i = 0; i < str.length(); i++) {
			if(!StringParser.isPunctuation(str.charAt(i)))return false;
		}
		return true;
	}
	
	public CharacterGUI() {
		resultArea.setEditable(false);
	}
	
	public static void main(String[] args) {
		CharacterGUI frm = new CharacterGUI();
		frm.setTitle("Character Program");
		frm.setSize(400,400);
		frm.setVisible(true);
		
	}
	
}
