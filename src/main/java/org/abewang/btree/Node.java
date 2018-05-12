package org.abewang.btree;

/**
 * 二叉树节点
 *
 * @Author Abe
 * @Date 2018/3/16.
 */
public class Node<T> {
    public int key;
    public T data;
    public Node leftChild;
    public Node rightChild;

    public Node(int key, T data) {
        this.key = key;
        this.data = data;
    }

    public void display() {
        System.out.println("{");
        System.out.println(key);
        System.out.println(", ");
        System.out.println(data);
        System.out.println("}");
    }
}
