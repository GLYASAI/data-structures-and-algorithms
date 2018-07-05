package org.abewang.dsaa.heap;

/**
 * @Author Abe
 * @Date 2018/3/31.
 */
public class Node {
    private int iData;

    public Node(int key) {
        this.iData = key;
    }

    public int getKey() {
        return iData;
    }

    public void setKey(int key) {
        this.iData = key;
    }
}
