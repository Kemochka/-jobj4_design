package ru.job4j.map;

import java.util.*;

public class NonCollisionMap<K, V> implements SimpleMap<K, V> {
    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count >= capacity * LOAD_FACTOR) {
            expand();
        }
        int index = indexFor(hash(Objects.hashCode(key)));
        if (table[index] != null) {
            return false;
        } else {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
            return true;
        }
    }

    private int hash(int hashCode) {
        return hashCode ^ hashCode >>> table.length;
    }

    private int indexFor(int hash) {
        return hash & capacity - 1;
    }

    private void expand() {
        MapEntry<K, V>[] newTable = new MapEntry[capacity * 2];
        capacity *= 2;
        for (MapEntry<K, V> entry : table) {
            if (entry != null) {
                int index = indexFor(hash(Objects.hashCode(entry.key)));
                newTable[index] = entry;
            }
        }
        table = newTable;
    }

    @Override
    public V get(K key) {
        int index = indexFor(hash(Objects.hashCode(key)));
        if (table[index] != null && Objects.equals(table[index].key, key)) {
            return table[index].value;
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        int index = indexFor(hash(Objects.hashCode(key)));
        if (table[index] != null && Objects.equals(table[index].key, key)) {
            table[index] = null;
            count--;
            modCount--;
            return true;
        }
            return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            int cursor = 0;
            int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (cursor < capacity && table[cursor] == null) {
                    cursor++;
                }
                return cursor < capacity;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[cursor++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
