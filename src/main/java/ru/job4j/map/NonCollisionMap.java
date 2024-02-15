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
        boolean result = false;
        if (count >= capacity * LOAD_FACTOR) {
            expand();
        }
        if (table[getIndex(key)] == null) {
            table[getIndex(key)] = new MapEntry<>(key, value);
            count++;
            modCount++;
            result = true;
        }
        return result;
    }

    private int hash(int hashCode) {
        return hashCode ^ hashCode >>> 16;
    }

    private int indexFor(int hash) {
        return hash & capacity - 1;
    }

    private int getIndex(Object key) {
        return indexFor(hash(Objects.hashCode(key)));
    }

    private void expand() {
        capacity *= 2;
        MapEntry<K, V>[] newTable = new MapEntry[capacity * 2];
        for (MapEntry<K, V> entry : table) {
            if (entry != null) {
                newTable[getIndex(entry.key)] = entry;
            }
        }
        table = newTable;
    }

    @Override
    public V get(K key) {
        return table[getIndex(key)] != null && table[getIndex(key)].hashCode() != hash(hashCode())
                && Objects.equals(table[getIndex(key)].key, key)
                ? table[getIndex(key)].value : null;
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        if (table[getIndex(key)] != null
                && table[getIndex(key)].hashCode() != hash(hashCode())
                && Objects.equals(table[getIndex(key)].key, key)) {
            table[getIndex(key)] = null;
            count--;
            modCount--;
            result = true;
        }
            return result;
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
