package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;
import java.util.Iterator;
import java.util.Objects;

public class SimpleArraySet<T> implements SimpleSet<T> {
    private SimpleArrayList<T> set = new SimpleArrayList<>(0);

    @Override
    public boolean add(T value) {
        if (!contains(value)) {
            set.add(value);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(T value) {
        for (T item : set)
            if (Objects.equals(item, value)) {
                return true;
            }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
