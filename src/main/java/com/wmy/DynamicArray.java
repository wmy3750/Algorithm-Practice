package com.wmy;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class DynamicArray<E> {

    // 存储数据的底层数组
    private E[] data;

    // 记录当前数组中元素的个数
    private int size;

    // 默认初始数组容量为1
    private static final int DEFAULT_CAPACITY = 1;

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    public DynamicArray(int initCapacity) {
        data = (E[]) new Object[initCapacity];
        size = 0;
    }

    //增
    public void addLast(E e) {
       int cap = data.length;
       // 看 data数组容量够不够
        if (size == cap) {
            resize(2 * cap);
        }
        // 在尾部插入元素
        data[size] = e;
        size++;
    }

    public void add(int index, E e) {
        // 检查索引越界
        checkPositionIndex(index);

        int cap = data.length;
        // 看 data数组容量够不够
        if (size == cap) {
            resize(2 * cap);
        }

        // 搬移数据 data[index..] -> data[index+1..]
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        // 插入新元素
        data[index] = e;
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    // 删
    public E removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        int cap = data.length;

        // 可以缩容，节约空间
        if (size == cap / 4) {
            resize(cap / 2);
        }

        // 删除最后一个元素
        // 必须给最后一个元素赋值为 null，避免内存泄漏
        E deletedVal = data[size - 1];
        data[size - 1] = null;
        size--;

        return deletedVal;
    }

    public E remove(int index) {
        // 检查索引越界
        checkPositionIndex(index);

        int cap = data.length;
        // 可以缩容，节约空间
        if (size == cap / 4) {
            resize(cap / 2);
        }

        E deletedVal = data[index];

        // 搬移数据 data[index+1..] -> data[index..]
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

    // 查
    public E get(int index) {
        // 检查索引越界
        checkPositionIndex(index);

        return data[index];
    }

    // 改
    public E set(int index, E e) {
        // 检查索引越界
        checkPositionIndex(index);

        // 修改数据
        E oldVal = data[index];
        data[index] = e;
        return oldVal;
    }

    //工具方法
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int newCap) {
        E[] newData = (E[]) new Object[newCap];

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    // 检查 index 索引位置是否可以存在元素
    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    // 检查 index 索引位置是否可以添加元素
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void display() {
        System.out.println("size = " + size + " cap = " + data.length);
        System.out.println(Arrays.toString(data));
    }

    public static void main(String[] args) {
        // 初始容量设置为 3
        DynamicArray<Integer> arr = new DynamicArray<>(3);

        // 添加 5 个元素
        for (int i = 1; i <= 5; i++) {
            arr.addLast(i);
        }

        arr.remove(3);
        arr.add(1, 9);
        arr.addFirst(100);
        int val = arr.removeLast();

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}
