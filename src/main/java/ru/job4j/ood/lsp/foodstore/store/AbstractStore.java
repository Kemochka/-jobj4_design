package ru.job4j.ood.lsp.foodstore.store;

import ru.job4j.ood.lsp.foodstore.food.Food;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    private final List<Food> products = new ArrayList<>();

    @Override
    public void add(Food food) {
        if (condition(food)) {
            products.add(food);
        }
    }

    @Override
    public boolean condition(Food food) {
        return false;
    }

    @Override
    public List<Food> getAll() {
        return products;
    }

    @Override
    public void clear() {
    }
}
