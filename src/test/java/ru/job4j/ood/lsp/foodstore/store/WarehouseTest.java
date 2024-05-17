package ru.job4j.ood.lsp.foodstore.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.foodstore.ControlQuality;
import ru.job4j.ood.lsp.foodstore.food.Apple;
import ru.job4j.ood.lsp.foodstore.food.Milk;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WarehouseTest {
    @Test
    void whenTestWarehouse() {
        Warehouse warehouse = new Warehouse();
        Milk milk = new Milk("Milk", 1, 31, 100);
        Apple apple = new Apple("Apple", 19, 31, 100);
        List<Store> stores = new ArrayList<>();
        stores.add(warehouse);
        ControlQuality controlQuality = new ControlQuality(stores);
        controlQuality.distribute(milk);
        controlQuality.distribute(apple);
        assertThat(warehouse.getAll()).contains(apple);
        assertThat(warehouse.getAll()).doesNotContain(milk);
    }
}