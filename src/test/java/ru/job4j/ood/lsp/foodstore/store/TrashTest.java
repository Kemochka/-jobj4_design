package ru.job4j.ood.lsp.foodstore.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.foodstore.ControlQuality;
import ru.job4j.ood.lsp.foodstore.food.Coffee;
import ru.job4j.ood.lsp.foodstore.food.Tea;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class TrashTest {
    @Test
    void whenTestTrash() {
        Trash trash = new Trash();
        Coffee coffee = new Coffee("Coffee", 1, 25, 100);
        Tea tea = new Tea("Tea", 1, 19, 100);
        List<Store> stores = new ArrayList<>();
        stores.add(trash);
        ControlQuality controlQuality = new ControlQuality(stores);
        controlQuality.distribute(coffee);
        controlQuality.distribute(tea);
        assertThat(trash.getAll()).doesNotContain(coffee);
        assertThat(trash.getAll()).contains(tea);
    }
}