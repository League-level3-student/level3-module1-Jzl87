package _00_Intro_To_ArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class GuestBook implements ActionListener {
	
	 JFrame mainFrame;
	 JPanel mainPanel;
	  JButton addButton;
	  JButton viewButton;
	  
	  ArrayList <String> listOfNames = new ArrayList <String> () ;
	  
	  
	public GuestBook () {
		
		mainFrame = new JFrame("GuestBook");
		mainPanel = new JPanel();	
		addButton = new JButton ("Add Name");
		viewButton = new JButton("View Names");
		
		frameSetup(mainFrame, mainPanel);
		buttonSetup(mainPanel);
	}
	
	public void buttonSetup(JPanel panel) {
		
		panel.add(addButton);
		panel.add(viewButton);
		
		addButton.addActionListener(this);
		viewButton.addActionListener(this);
		mainFrame.pack();
	}

	public void frameSetup(JFrame frame, JPanel panel) {
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		
		if (buttonPressed == viewButton) {
			JPanel viewPanel = new JPanel();
			JFrame viewFrame = new JFrame("Previous guests");
			JLabel names = new JLabel();
			
			String labelText = "<HTML>";
			for (String s: listOfNames) {
				labelText += (s + "<br>");
			}
			
			names.setText(labelText);
			
			frameSetup(viewFrame, viewPanel);
			viewPanel.add(names);
			viewFrame.pack();
			
		} else if (buttonPressed == addButton ) {
			String addedName = JOptionPane.showInputDialog("Please enter a name to add to the guestbook.");
			listOfNames.add(addedName);
		}
	}
}
