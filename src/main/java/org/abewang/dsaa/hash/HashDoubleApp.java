package org.abewang.dsaa.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 哈希表-二次探测
 *
 * @Author Abe
 * @Date 2018/3/28.
 */
public class HashDoubleApp {
    public static void main(String[] args) throws IOException {
        int size, keysPerCell, initNums;

        System.out.print("输入哈希表的容量：");
        size = getInt();
        System.out.print("输入哈希表数据的初始大小：");
        initNums = getInt();

        HashTable hashTable = new HashTable(size);

        keysPerCell = 10;
        for (int i = 0; i < initNums; i++) {
            int aKey = (int) (Math.random() * keysPerCell * size);
            DataItem dItem = new DataItem(aKey);
            hashTable.insert(dItem);
        }

        while (true) {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, delete, or find: ");
            char choice = getChar();
            switch (choice) {
                case 's':
                    hashTable.displayTable();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    DataItem dItem = new DataItem(getInt());
                    hashTable.insert(dItem);
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    hashTable.delete(getInt());
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    int key = getInt();
                    DataItem aDataItem = hashTable.find(key);

                    if(aDataItem != null)
                    {
                        System.out.println("Found " + key);
                    }
                    else
                        System.out.println("Could not find " + key);
                    break;
                default:
                    System.out.print("Invalid entry\n");
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
