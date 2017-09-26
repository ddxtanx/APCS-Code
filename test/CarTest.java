import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
//Using JUnit5 for testing
class CarTest {
    @Test
    void getMake() {
        Car car = new Car("Ford", 100, 200, 100);
        assertTrue(car.getMake().equals("Ford"), "getMake() incorrectly returns the make of the car");
    }

    @Test
    void getMileage() {
        Car car = new Car("Ford", 100, 200, 100);
        assertEquals(car.getMileage(), 100, "getMileage() incorrectly returns the mileage of the car");
    }

    @Test
    void getTankSize() {
        Car car = new Car("Ford", 100, 200, 100);
        assertEquals(car.getTankSize(), 200, "getTankSize() incorrectly returns the tank size of the car");
    }

    @Test
    void getGas() {
        Car car = new Car("Ford", 100, 200, 150);
        assertEquals(car.getGas(), 150, "getGas() incorrectly returns the gas of the car");
    }

    @Test
    void getFillUpCost() {
        Car car = new Car("Ford", 100, 200, 150);
        assertEquals(car.getFillUpCost(1.2), 50*1.2, "getFillUpCost() incorrectly calculates the fill up cost");
    }

    @Test
    void getCostOfOwnership() {
        Car car = new Car("Ford", 100, 200, 150);
        assertEquals(car.getCostOfOwnership(), 100.0*.47, "getCostOfOwnership() incorrectly calculates the cost of ownership.");
    }

    @Test
    void drive() {
        Random rand = new Random();
        Car car = new Car("Ford", 100, 200, 150);
        //Mile increment is some natural number < 500
        int randomMiles = rand.nextInt(500);
        car.drive(randomMiles);
        assertEquals(car.getMileage(), 100+randomMiles, "drive() incorrectly mutates the car object.");
    }

    @Test
    void addFuel() {
        Car car = new Car("Ford", 100, 200, 150);
        //Check that is works for fuel values that don't overflow the tank
        car.addFuel(30);
        assertEquals(car.getGas(), 180, "addFuel() incorrectly mutates the car object without an overflow");
        //Check that it works for fuel values that do overflow the tank
        car.addFuel(299);
        assertEquals(car.getGas(), 200, "addFuel() incorrectly mutates the car object with an overflow");
    }

}