package ru.job4j.ood.lsp.parking;

public class Car implements Transport {
    private final int carSize;

    public Car() {
        this.carSize = 1;
    }

    @Override
    public int getSize() {
        return this.carSize;
    }
}
