package org.example.observers;

public class ThirdPartyDisplay implements Observer, DisplayElement{

    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void display() {

    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display(); // refresh the screen
    }
}
