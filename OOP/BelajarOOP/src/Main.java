import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Tesla", 2023, "X", (short) 4));
        cars.add(new Car("Toyota", 2020, "Camry", (short) 5));
        cars.add(new Car("BMW", 2021, "X5", (short) 5));
        cars.add(new Car("Audi", 2022, "A8", (short) 5));
        cars.add(new Car("Mercedes", 2023, "S500", (short) 5));
        Collections.sort(cars, new CarComparator());

        System.out.println(cars);
    }
}