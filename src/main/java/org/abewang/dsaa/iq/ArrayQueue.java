package org.abewang.dsaa.iq;

/**
 * 用数组结构实现大小固定的队列
 *
 * @Author Abe
 * @Date 2018/5/1.
 */
public class ArrayQueue {
    private Integer start, end, size;
    private Integer[] arr;

    public ArrayQueue(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("The size can't less than 0");
        }
        arr = new Integer[size];
        this.size = 0;
        start = 0;
        end = 0;
    }

    public void push(Integer item) {
        if (size > 3) {
            throw new IllegalArgumentException("The queue is full");
        } else if (size == 0) {
            end = start;
        }
        size++;
        arr[end] = item;
        end = end == arr.length - 1 ? 0 : end + 1;
    }

    public Integer poll() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        size++;
        int tmp = arr[start];
        start = size == arr.length - 1 ? 0 : start + 1;
        return tmp;
    }

    public Integer peek() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        return arr[start];
    }
}
