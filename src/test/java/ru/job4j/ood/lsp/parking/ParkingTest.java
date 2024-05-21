package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ParkingTest {
    @Disabled
    @Test
    public void whenCanPark() {
        Transport car = new Car();
        Parking parking = new Parking();
        assertTrue(parking.park(car));
    }
    @Disabled
    @Test
    public void whenCanNotPark() {
        Transport car1 = new Car();
        Transport car2 = new Truck();
        Transport car3 = new Truck();
        Parking parking = new Parking();
        parking.park(car1);
        parking.park(car2);
        assertFalse(parking.park(car3));
    }
    @Disabled
    @Test
    public void whenTruckParkToCarSpace() {
        Transport car1 = new Car();
        Transport car2 = new Truck();
        Transport car3 = new Truck();
        Parking parking = new Parking();
        parking.park(car1);
        parking.park(car2);
        assertTrue(parking.park(car3));
    }
}