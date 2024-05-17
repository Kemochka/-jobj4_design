package ru.job4j.ood.lsp.foodstore.store;

import ru.job4j.ood.lsp.foodstore.food.Food;

import java.util.ArrayList;
import java.util.List;

public class Shop extends AbstractStore {
    private final List<Food> store = new ArrayList<>();

    @Override
    public void add(Food food) {
        if (condition(food)) {
            if (conditionDiscount(food)) {
                food.setDiscount(food.getDiscount() + 20);
                food.setPrice(food.getPrice() - food.getDiscount());
            }
            store.add(food);
        }
    }

    @Override
    public boolean condition(Food food) {
        return food.getPercentFresh() <= 75 && food.getPercentFresh() > 0;
    }

    public boolean conditionDiscount(Food food) {
        return food.getPercentFresh() <= 25 && food.getPercentFresh() > 0;
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
