package com.example.reflection.data;

import com.example.reflection.Drivable;
import com.example.reflection.annotation.NotBlank;

public class Car implements Drivable {
    @NotBlank
    private String brand;
    @NotBlank(allowEmptyString = true)
    private String model;
    private int year;

    public Car() {
    }

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        return brand + " " + model + " (" + year + ")";
    }

    @Override
    public String getDriverName() {
        return "Jamal";
    }

    @Override
    public int getDriverAge() {
        return 30;
    }
}
