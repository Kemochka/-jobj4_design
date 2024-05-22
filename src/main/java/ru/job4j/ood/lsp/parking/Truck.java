package ru.job4j.ood.lsp.parking;

public class Truck implements Transport {
    private final int truckSize;

    public Truck(int truckSize) {
        this.truckSize = truckSize;
    }

    @Override
    public int getSize() {
        return this.truckSize;
    }
}
