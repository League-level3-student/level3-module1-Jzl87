package _09_World_Clocks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	JButton button;
	HashMap<Integer, JTextArea> textArea = new HashMap<Integer, JTextArea>();

	
	public static int currentKey = 0;

	HashMap<Integer, String> city = new HashMap<Integer, String>();
	HashMap<Integer, String> dateStr = new HashMap<Integer, String>();
	HashMap<Integer, String> timeStr = new HashMap<Integer, String>();

	public WorldClocks() {
		clockUtil = new ClockUtilities();

		// Sample starter program

		city.put(currentKey, "Chicago, US");
		timeZone = clockUtil.getTimeZoneFromCityName(city.get(currentKey));

		Calendar calendar = Calendar.getInstance(timeZone);
		String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
		String dayOfWeek = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
		dateStr.put(currentKey, dayOfWeek + " " + month + " " + calendar.get(Calendar.DAY_OF_MONTH) + " "
				+ calendar.get(Calendar.YEAR));

		frame = new JFrame();
		panel = new JPanel();
		textArea.put(currentKey, new JTextArea());
		button = new JButton("Add time");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(100, 100);
		frame.add(panel);

		panel.add(button);
		panel.add(textArea.get(currentKey));
		button.addActionListener(this);

		textArea.get(currentKey).setText(city.get(currentKey) + "\n" + dateStr.get(currentKey));
		// This Timer object is set to call the actionPerformed() method every
		// 1000 milliseconds
		timer = new Timer(1000, this);
		timer.start();
		
		System.out.println("-----------------------------------------------------------");
		System.out.println(city.get(currentKey));
		System.out.println(dateStr.get(currentKey));
		System.out.println("-----------------------------------------------------------");
		
		currentKey ++;
	}

	public void addTime(String place) {
		// The format for the city must be: city, country (all caps)
		textArea.put(currentKey, new JTextArea());

		panel.add(textArea.get(currentKey));

		city.put(currentKey, place);
		timeZone = clockUtil.getTimeZoneFromCityName(city.get(currentKey));

		Calendar calendar = Calendar.getInstance(timeZone);
		String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
		String dayOfWeek = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
		dateStr.put(currentKey, dayOfWeek + " " + month + " " + calendar.get(Calendar.DAY_OF_MONTH) + " "
				+ calendar.get(Calendar.YEAR));

		Timer newTimer = new Timer(1000, this);
		newTimer.start();

		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Calendar c = Calendar.getInstance(timeZone);
		String militaryTime = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
		String twelveHourTime = " [" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":"
				+ c.get(Calendar.SECOND) + "]";
		timeStr.put(currentKey, militaryTime + twelveHourTime);

		System.out.println(timeStr.get(currentKey));
		
		System.out.println("-----------------------------------------------------------");
		System.out.println(city.get(currentKey));
		System.out.println(dateStr.get(currentKey));
		System.out.println(timeStr.get(currentKey));
		
		textArea.get(currentKey).setText(city.get(currentKey) + "\n" + dateStr.get(currentKey) + "\n" + timeStr.get(currentKey));
		frame.pack();

		if (arg0.getSource() instanceof JButton) {
			JButton buttonPressed = (JButton) arg0.getSource();

			if (buttonPressed.equals(button)) {
				String place = JOptionPane.showInputDialog("What time would you like to add the world clock?");
				addTime(place);
			}
		}
	}
}
