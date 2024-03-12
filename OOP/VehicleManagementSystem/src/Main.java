public class Main {
    public static void main(String[] args) {

        System.out.println(Vehicle.getVehicleCount());

        Car car1 = new Car("Honda", "Civic", 2012, "Sedan");
        Truck truck1 = new Truck("Ford", "F-150", 2018, 2.5);
        Car car2 = new Car("Toyota", "Camry", 2015, "Sedan");
        Truck truck2 = new Truck("Chevrolet", "Silverado", 2017, 3.5);

        Vehicle[] vehicles = {car1, truck1, car2, truck2};
        for (int i = 0; i < vehicles.length; i++) {
            vehicles[i].start();
            vehicles[i].stop();
        }

        Mantainable[] mantainables = {car1, truck1, car2, truck2};
        // perform maintenance
        for (int i = 0; i < mantainables.length; i++) {
            mantainables[i].performMaintenance();
        }
    }
}