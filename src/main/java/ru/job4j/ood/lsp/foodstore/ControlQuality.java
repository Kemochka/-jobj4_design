package ru.job4j.ood.lsp.foodstore;

import ru.job4j.ood.lsp.foodstore.food.Food;
import ru.job4j.ood.lsp.foodstore.store.Store;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    private final List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void distribute(Food food) {
        for (Store store: stores) {
            store.add(food);
        }
    }

    public  void resort() {
        List<Food> foodList = new ArrayList<>();
        for (Store s: stores) {
            foodList.addAll(s.getAll());
            s.clear();
        }
        foodList.forEach(this::distribute);
    }
}
