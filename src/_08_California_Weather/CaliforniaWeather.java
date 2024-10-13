package _08_California_Weather;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import _06_Intro_To_Hash_Maps._02_LogSearch;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 �F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature �F = 65.0, max temperature �F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 * 
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api
 */

public class CaliforniaWeather implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();

	HashMap<Integer, String> log = new HashMap<Integer, String>();

	JButton button1 = new JButton("Find city's weather");
	JButton button2 = new JButton("Find weather condition");
	JButton button3 = new JButton("Find temperature");

	void start() {
		HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();

		// All city keys have the first letter capitalized of each word
		String cityName = Utilities.capitalizeWords("National City");
		WeatherData datum = weatherData.get(cityName);

		if (datum == null) {
			System.out.println("Unable to find weather data for: " + cityName);
		} else {
			System.out.println(
					cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
		}

		setup();
	}

	public void setup() {

		frame.setVisible(true);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel.add(button1);
		panel.add(button2);
		panel.add(button3);

		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);

		frame.pack();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();

		if (buttonPressed == button1) {

			String city = JOptionPane.showInputDialog(null, "Enter city name");

			if (city.equals()) {

			}

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
}
