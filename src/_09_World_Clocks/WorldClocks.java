package _09_World_Clocks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/*
 * You task is to create a java program that:
 * 1. Displays the time for multiple cities around the world on one display.
 * 2. Gives the user the ability to add a city to the display. One possible
 *    way to do this is to create a HashMap of city names and their
 *    corresponding time zones, e.g. HashMap<String, TimeZone>, then use each
 *    city's TimeZone to get the current date/time every second using a
 *    Timer object (see example code below).
 * 
 * The code below is an example of how to print out a clock for San Diego.
 * Use the ClockUtilities class to find the time zone of each city, then use
 * Calendar.getInstance to return a Calendar object to get the current time for
 * that city. Example:
 *   TimeZone timeZone = clockUtil.getTimeZoneFromCityName("San Diego, US");
 *   Calendar c = Calendar.getInstance(timeZone);
 *   System.out.println("Full date and time: " + calendar.getTime());
 * 
 * NOTE: The program may take a second or two to execute
 * 
 * Calendar class:
 * https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
 */

public class WorldClocks implements ActionListener {
	ClockUtilities clockUtil;
	Timer timer;
	TimeZone timeZone;

	JFrame frame;
	JPanel panel;
	JButton addButton = new JButton("add time");
	
	String dateStr;
	
	
	static int clockCounter = 1;
	
	ArrayList<JTextArea> textAreas = new ArrayList <JTextArea>();
	HashMap <String, TimeZone> times = new HashMap <String, TimeZone>();
	
	public WorldClocks() {
		clockUtil = new ClockUtilities();

		// The format for the city must be: city, country (all caps)
		
		times.put("Chicago, US", clockUtil.getTimeZoneFromCityName("Chicago, US"));
	
		Calendar calendar = Calendar.getInstance(times.get("Chicago, US"));
		String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
		String dayOfWeek = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
		dateStr = dayOfWeek + " " + month + " " + calendar.get(Calendar.DAY_OF_MONTH) + " "
				+ calendar.get(Calendar.YEAR);

		System.out.println(dateStr);

		// Sample starter program
		frame = new JFrame();
		panel = new JPanel();
		textAreas.add(new JTextArea());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(100, 100);
		frame.add(panel);
		panel.add(addButton);
		addButton.addActionListener(this);
		panel.add(textAreas.get(0));
		textAreas.get(0).setText("Chicago, US" + "\n" + dateStr);

		// This Timer object is set to call the actionPerformed() method every
		// 1000 milliseconds
		timer = new Timer(1000, this);
		timer.start();
	}
	
	public void addTime(String place, int index) {
		
		textAreas.add(new JTextArea());
		times.put(place, clockUtil.getTimeZoneFromCityName(place));
		
		panel.add(textAreas.get(index));
		

		Calendar calendar = Calendar.getInstance(times.get(place));
		String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
		String dayOfWeek = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
		dateStr = dayOfWeek + " " + month + " " + calendar.get(Calendar.DAY_OF_MONTH) + " "
				+ calendar.get(Calendar.YEAR);

		textAreas.get(index).setText(place + "\n" + dateStr);
		
		clockCounter++;
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		int whichText = 0;
		for (String x : times.keySet()) {
			Calendar c = Calendar.getInstance(times.get(x));
			String militaryTime = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
			String twelveHourTime = " [" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":"
					+ c.get(Calendar.SECOND) + "]";
			
			textAreas.get(whichText).setText(x + "\n" + dateStr + "\n" + militaryTime + twelveHourTime);
			whichText++;
		}
		
		frame.pack();
		
		if (arg0.getSource() instanceof JButton) {
			JButton buttonPressed = (JButton) arg0.getSource();

			if (buttonPressed.equals(addButton)) {
				String place = JOptionPane.showInputDialog("What time would you like to add the world clock?");
				addTime(place, clockCounter);
			}
		}
	}
}