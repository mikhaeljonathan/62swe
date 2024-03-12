public abstract class Vehicle {
    private String make;
    private String model;
    private int year;

    private static int vehicleCount = 0;

    public static int getVehicleCount() {
        return vehicleCount;
    }
    Vehicle() {
        vehicleCount++;
    }

    Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
        vehicleCount++;
    }

    public abstract void start();

    public abstract void stop();

    public void setDetails(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public void setDetails(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Make: " + make + "\nModel: " + model + "\nYear: " + year + "\n";
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}
