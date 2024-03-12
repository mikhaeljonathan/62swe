public class Car extends Vehicle implements Mantainable{
    private String carType;

    Car(String make, String model, int year, String carType) {
        super(make, model, year);
        this.carType = carType;
    }

    @Override
    public void start() {
        System.out.println(getMake() + " " + getModel() + " car is starting");
    }

    @Override
    public void stop() {
        System.out.println(getMake() + " " + getModel() + " car is stopping");
    }

    @Override
    public String toString() {
        return "Make: " + getMake() + "\nModel: " + getModel() + "\nYear: " + getYear() + "\n";
    }

    @Override
    public void performMaintenance() {
        System.out.println("Performing maintenance on " + getMake() + " " + getModel() + " car");
    }
}
