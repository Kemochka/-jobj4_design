package ru.job4j.ood.lsp.foodstore.store;

import ru.job4j.ood.lsp.foodstore.food.Food;
import java.util.ArrayList;
import java.util.List;

public class Warehouse extends AbstractStore {
    private final List<Food> store = new ArrayList<>();

    @Override
    public void add(Food food) {
        if (condition(food)) {
            store.add(food);
        }
    }

    @Override
    public boolean condition(Food food) {
        return food.getPercentFresh() <= 100 && food.getPercentFresh() > 75;
    }

    @Override
    public List<Food> getAll() {
        return store;
    }

    @Override
    public void clear() {
        store.clear();
    }
}
