package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Car {

    private String carName;
    private String carModel;
    private int carYear;

    public void drive() {
        System.out.println("Car is driving");
    }

}
