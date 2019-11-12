import BreezySwing.*;
import javax.swing.*;

public class CharacterGUI extends GBFrame{
	
	JTextField inputField = addTextField("The dog and the cat ran and ran ..h.",1,1,1,1);
	JButton enterButton = addButton("Enter",2,1,1,1);
	JTextArea resultArea = addTextArea("",3,1,1,1);
	
	public void buttonClicked(JButton button) {
		if(button == enterButton) {
			String input = inputField.getText();
			System.out.println(Character.valueOf(input.charAt(0)));
			if(input.length() == 0) {
				resultArea.setText("Error: empty input");
				return;
			}
			StringParser p = new StringParser(inputField.getText());
			p.generate();
			resultArea.setText(p.toString());
		}
	}
	
	public static void main(String[] args) {
		CharacterGUI frm = new CharacterGUI();
		frm.setTitle("Character Program");
		frm.setSize(400,400);
		frm.setVisible(true);
		
	}
	
}
