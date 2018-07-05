package org.abewang.dsaa.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author Abe
 * @Date 2018/3/31.
 */
public class HeapApp {
    public static void main(String[] args) throws IOException {
        Heap heap = new Heap(31);

        for (int i = 0; i < 20; i++) {
            int ele = (int) (Math.random() * (100 + 1));
            heap.insert(ele);
        }

        while (true) {
            System.out.print("Enter first letter of show, insert, remove, change: ");
            switch (getChar()) {
                case 's':
                    heap.displayHeap();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    heap.insert(getInt());
                    break;
                case 'r':
                    heap.remove();
                    break;
                case 'c':
                    System.out.print("Enter index to change: ");
                    int index = getInt();
                    System.out.print("Enter value to change: ");
                    int value = getInt();
                    boolean success = heap.change(index, value);
                    if (!success) {
                        System.out.println("Invalid Index");
                    }
                    break;
                default:
                    System.out.println("Invalid entry\n");
            }
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    public static int getInt() throws IOException {
        return Integer.valueOf(getString());
    }

    public static char getChar() throws IOException {
        return getString().charAt(0);
    }
}
