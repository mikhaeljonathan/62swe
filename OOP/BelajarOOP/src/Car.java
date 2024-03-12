import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Car implements Comparable<Car>{

    @Override
    public int compareTo(Car o) {
        // 0 - equal
        // 1 - this > o
        // -1 - this < o
        return this.year - o.year;
    }

    private String brand = "Tesla";
    private int year = 2023;

    static String ShapeOfWheel = "round";
    private String model = "X";
    private short seats = 4;

    static void drive() {
        System.out.println("Driving...");
    }

    static String shapeOfWheel = "round";
    // car is bought at 16 December 2023
    private LocalDateTime carBought = LocalDateTime.of(2023, 12, 16, 0, 0);

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        if (year < 0) {
            throw new IllegalArgumentException("Year cannot be negative");
        }
        this.year = year;
    }

    public String getCarBought(String formatString) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatString);
        return dtf.format(carBought);
    }



    Car() {

    }

    Car(String brand, int year, String model, short seats) {
        this.brand = brand;
        this.year = year;
        this.model = model;
        this.seats = seats;
    }


    public void stop() {
        System.out.println("Stopping...");
    }

    @Override
    public String toString() {
        return "The car's brand is " + this.brand + ", model " + this.model +
                ", year " + this.year + ", and have " + this.seats + " seats.";
    }

    public void testValue(int x) {
        x = 20;
    }

    public void testReference(Engine e) {
        e.setYear(2000);
    }


}
