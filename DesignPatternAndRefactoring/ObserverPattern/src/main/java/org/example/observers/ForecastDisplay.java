package org.example.observers;

public class ForecastDisplay implements Observer, DisplayElement{

    private float temperature;

    @Override
    public void display() {
        System.out.println("Forecast: " + temperature + "F degrees");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        display(); // refresh the screen
    }
}
