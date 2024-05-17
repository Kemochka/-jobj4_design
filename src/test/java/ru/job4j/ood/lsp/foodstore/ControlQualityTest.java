package ru.job4j.ood.lsp.foodstore;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.foodstore.food.*;
import ru.job4j.ood.lsp.foodstore.store.Shop;
import ru.job4j.ood.lsp.foodstore.store.Store;
import ru.job4j.ood.lsp.foodstore.store.Trash;
import ru.job4j.ood.lsp.foodstore.store.Warehouse;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class ControlQualityTest {
    @Test
    public void testDistributeAndResort() {
        Milk milk = new Milk("Milk", 1, 31, 100);
        Apple apple = new Apple("Apple", 19, 31, 100);
        Coffee coffee = new Coffee("Coffee", 1, 25, 100);
        Tea tea = new Tea("Tea", 1, 19, 100);
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();
        List<Store> stores = new ArrayList<>();
        stores.add(shop);
        stores.add(warehouse);
        stores.add(trash);
        ControlQuality controlQuality = new ControlQuality(stores);
        controlQuality.distribute(milk);
        controlQuality.distribute(apple);
        controlQuality.distribute(coffee);
        controlQuality.distribute(tea);
        controlQuality.resort();
        assertThat(shop.getAll()).contains(milk);
        assertThat(shop.getAll().get(0).getPrice()).isEqualTo(100);
        assertThat(shop.getAll()).contains(coffee);
        assertThat(warehouse.getAll()).contains(apple);
        assertThat(trash.getAll()).contains(tea);
    }
}