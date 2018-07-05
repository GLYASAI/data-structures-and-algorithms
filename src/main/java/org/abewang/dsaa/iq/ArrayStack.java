package org.abewang.dsaa.iq;

/**
 * 用数组结构实现大小固定的栈
 *
 * @Author Abe
 * @Date 2018/5/1.
 */
public class ArrayStack {
    private int size;
    private int[] arr;

    public ArrayStack(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("The init size is less than 0");
        }

        arr = new int[size];
        this.size = 0;
    }

    public void push(int item) {
        if (size > arr.length) {
            throw new ArrayIndexOutOfBoundsException("The stack is full");
        }
        arr[size++] = item;
    }

    public int pop() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("The stack is empty");
        }
        return arr[--size];
    }

    public int peek() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("The stack is empty");
        }
        return arr[size - 1];
    }
}
