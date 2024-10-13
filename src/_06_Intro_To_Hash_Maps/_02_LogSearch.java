package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();

	HashMap<Integer, String> log = new HashMap<Integer, String>();

	JButton button1 = new JButton("Add Entry");
	JButton button2 = new JButton("Search By ID");
	JButton button3 = new JButton("View List");
	JButton button4 = new JButton("Remove Entry");

	public static void main(String[] args) {
		_02_LogSearch search = new _02_LogSearch();
		search.setup();
	}

	public void setup() {

		frame.setVisible(true);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);

		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);

		frame.pack();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();

		if (buttonPressed == button1) {

			String IDString = JOptionPane.showInputDialog(null, "Enter ID");
			Integer ID = Integer.parseInt(IDString);
			String stringy = JOptionPane.showInputDialog(null, "Enter name");
			log.put(ID, stringy);

		} else if (buttonPressed == button2) {

			String IDString = JOptionPane.showInputDialog(null, "Enter ID to find");
			Integer ID = Integer.parseInt(IDString);

			if (log.containsKey(ID)) {
				JOptionPane.showMessageDialog(null, log.get(ID));
			} else {
				JOptionPane.showMessageDialog(null, "that doesnt exist. loser.");

			}
		} else if (buttonPressed == button3) {

			String result = "";
			for (Integer i : log.keySet()) {
				result += "ID: " + i + " Name: " + log.get(i) + "\n";
			}

			JOptionPane.showMessageDialog(null, result);

		} else {

			String IDString = JOptionPane.showInputDialog(null, "Enter ID to find");
			Integer ID = Integer.parseInt(IDString);

			log.remove(ID);
		}

	}
	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons.
	 * 
	 * Button 1: Add Entry When this button is clicked, use an input dialog to ask
	 * the user to enter an ID number. After an ID is entered, use another input
	 * dialog to ask the user to enter a name. Add this information as a new entry
	 * to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 */

}
