package com.wmy;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class DynamicArray1<E> {

    private E[] data;

    private int size;

    private static final int DEFAULT_CAPACITY = 1;

    public DynamicArray1() {
        this(DEFAULT_CAPACITY);
    }

    public DynamicArray1(int initCapacity) {
        data = (E[]) new Object[initCapacity];
        size = 0;
    }

    public void addLast(E e) {
        int cap = data.length;

        if (cap == size) {
            resize(cap * 2);
        }

        data[size] = e;
        size++;
    }

    public void add(int index, E e) {
        checkPositionIndex(index);

        int cap = data.length;

        if (cap == size) {
            resize(cap * 2);
        }

        for (int i = size - 1; i>= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public E removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        int cap = data.length;

        if (size == cap / 4) {
            resize(cap / 2);
        }

        E deletedVal = data[size - 1];
        data[size - 1] = null;
        size--;
        return deletedVal;
    }

    public E remove(int index) {
        checkPositionIndex(index);

        int cap = data.length;

        if (size == cap / 4) {
            resize(cap / 2);
        }

        E deletedVal = data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size - 1] = null;
        size--;
        return deletedVal;
    }

    public E removeFirst() {
        return remove(0);
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private void resize(int newCap) {
        E[] newData = (E[]) new Object[newCap];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
