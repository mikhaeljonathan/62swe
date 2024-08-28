package sixtytwo.swe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import sixtytwo.swe.data.Car;
import sixtytwo.swe.repository.CarRepository;
import sixtytwo.swe.service.CarService;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
@MockitoSettings(strictness = Strictness.LENIENT)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    private CarService carService;

    @BeforeEach
    void setUp() {
        carService = new CarService(carRepository);
        Mockito.when(carRepository.selectById("3")).thenReturn(new Car("Toyota", "Camry"));
    }

    @Test
    public void testGetNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carService.get("2");
        });
    }

    @Test
    public void testGetFound() {
        Assertions.assertNotNull(carService.get("3"));
    }

//     we can't use this because it's still valid if carRepository.insert() is deleted in CarService class
//     this can happen because the carRepository.insert() is void
    @Test
    public void testInsertBad() {
        Car car = carService.insert("Toyota", "Camry");
        Assertions.assertEquals("Toyota", car.getBrand());
        Assertions.assertEquals("Camry", car.getType());
    }

    @Test
    public void testInsertGood() {
        Car car = carService.insert("Toyota", "Camry");
        Assertions.assertEquals("Toyota", car.getBrand());
        Assertions.assertEquals("Camry", car.getType());

        Mockito.verify(carRepository, Mockito.times(1))
                .insert(car);
    }

}
