import model.Car;
import model.Motor;
import model.Bicycle;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Corrola", 2020);
        System.out.println(car1.getCarName());

        Motor motor1 = new Motor();
        motor1.drive();

        Bicycle bicycle1 = new Bicycle();
        bicycle1.drive();
    }
}
