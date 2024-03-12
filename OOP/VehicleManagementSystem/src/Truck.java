public class Truck extends Vehicle implements Mantainable{
    private double truckCapacityInTon;

    Truck(String make, String model, int year, double truckCapacityInTon) {
        super(make, model, year);
        this.truckCapacityInTon = truckCapacityInTon;
    }

    @Override
    public void start() {
        System.out.println(getMake() + " " + getModel() + " truck is starting");
    }

    @Override
    public void stop() {
        System.out.println(getMake() + " " + getModel() + " truck is stopping");
    }

    @Override
    public String toString() {
        return "Make: " + getMake() + "\nModel: " + getModel() + "\nYear: " + getYear() + "\n";
    }

    @Override
    public void performMaintenance() {
        System.out.println("Performing maintenance on " + getMake() + " " + getModel() + " truck");
    }
}
