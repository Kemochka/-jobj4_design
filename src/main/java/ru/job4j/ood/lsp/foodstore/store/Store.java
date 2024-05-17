package ru.job4j.ood.lsp.foodstore.store;

import ru.job4j.ood.lsp.foodstore.food.Food;

import java.util.List;

public interface Store {
    void add(Food food);
    boolean condition(Food food);
    List<Food> getAll();
    void clear();
}
