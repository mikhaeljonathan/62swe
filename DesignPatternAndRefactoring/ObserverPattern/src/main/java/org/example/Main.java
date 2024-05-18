package org.example;

import org.example.observers.CurrentConditionDisplay;
import org.example.observers.Observer;
import org.example.observers.StatisticDisplay;
import org.example.subject.WeatherData;

public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        Observer currentConditionDisplay = new CurrentConditionDisplay();
        Observer statisticDisplay = new StatisticDisplay();

        weatherData.registerObserver(currentConditionDisplay);
        weatherData.registerObserver(statisticDisplay);
        weatherData.setMeasurements(80, 65, 30.4f);
        System.out.println("=====================================");
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.removeObserver(currentConditionDisplay);
        System.out.println("=====================================");
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}