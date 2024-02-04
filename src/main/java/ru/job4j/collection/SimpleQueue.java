package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> input = new SimpleStack<>();
    private final SimpleStack<T> output = new SimpleStack<>();
    private int countIn;
    private int countOut;

    public T poll() {
        if (countIn == 0 && countOut == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        if (countOut == 0) {
            while (countIn != 0) {
                output.push(input.pop());
                countOut++;
                countIn--;
            }
        }
        countOut--;
        return output.pop();
    }

    public void push(T value) {
        input.push(value);
        countIn++;
    }
}
