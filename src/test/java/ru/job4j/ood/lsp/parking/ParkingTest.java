package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParkingTest {
    @Test
    public void whenCanPark() {
        Transport car = new Car();
        Parking parking = new Parking(2, 2);
        assertTrue(parking.park(car));
    }

    @Test
    public void whenCanNotPark() {
        Transport car1 = new Car();
        Transport car2 = new Truck(2);
        Transport car3 = new Truck(2);
        Parking parking = new Parking(1, 1);
        parking.park(car1);
        parking.park(car2);
        assertFalse(parking.park(car3));
    }

    @Test
    public void whenTruckParkToCarSpace() {
        Transport car1 = new Car();
        Transport car2 = new Truck(2);
        Transport car3 = new Truck(2);
        Parking parking = new Parking(3, 1);
        parking.park(car1);
        parking.park(car2);
        assertTrue(parking.park(car3));
    }
}