import BreezySwing.*;
import javax.swing.*;

public class CharacterGUI extends GBFrame{
	
	//instance class objects
	private JTextField inputField = addTextField("The dog and the cat ran and ran ..h.",1,1,6,1);
	private JButton enterButton = addButton("Enter",2,1,2,1);
	private JButton resetButton = addButton("Reset",2,5,2,1);
	private JButton exitButton = addButton("Exit",4,5,2,1);
	private JTextArea basicResultArea = addTextArea("",3,1,3,1);
	private JTextArea charsResultArea = addTextArea("",3,4,3,1);
	
	//button event listener
	public void buttonClicked(JButton button) {
		if(button == enterButton) {
			String input = inputField.getText();
			input = input.replace('\t',' ');
			if(input.length() == 0 || isEmpty(input)) {
				basicResultArea.setText("Error: empty input");
				charsResultArea.setText("");
				return;
			}
			StringParser p = new StringParser(inputField.getText());
			p.generate();
			basicResultArea.setText(p.toString());
			charsResultArea.setText(p.getCharacterCount());
		}else if(button == resetButton) {
			inputField.setText("");
			inputField.requestFocus();
			basicResultArea.setText("");
			charsResultArea.setText("");
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
	
	//constructor
	public CharacterGUI() {
		basicResultArea.setEditable(false);
		charsResultArea.setEditable(false);
	}
	
	//main
	public static void main(String[] args) {
		CharacterGUI frm = new CharacterGUI();
		frm.setTitle("Character Program");
		frm.setSize(400,400);
		frm.setVisible(true);
		
	}
	
}
