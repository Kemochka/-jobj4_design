package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking implements ParkingInterface {
    private int carSpace;
    private int truckSpace;
    private final List<Transport> transports = new ArrayList<>();

    public Parking(int carSpace, int truckSpace) {
        this.carSpace = carSpace;
        this.truckSpace = truckSpace;
    }

    @Override
    public boolean park(Transport transport) {
        boolean result = false;
        if (transport.getSize() == 1 && this.carSpace > 0) {
            this.carSpace--;
            transports.add(transport);
            result = true;
        } else if (transport.getSize() > 1 && this.truckSpace > 0) {
            this.truckSpace--;
            transports.add(transport);
            result = true;
        } else if (transport.getSize() <= this.carSpace) {
            this.carSpace -= transport.getSize();
            transports.add(transport);
            result = true;
        }
        return result;
    }
}
