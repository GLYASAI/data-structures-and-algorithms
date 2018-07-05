package org.abewang.dsaa.tree234;

/**
 * @Author Abe
 * @Date 2018/3/24.
 */
public class Tree234App {
    public static void main(String[] args) {
        long value;
        Tree234 theTree = new Tree234();

        theTree.insert(50);
        theTree.insert(40);
        theTree.insert(60);
        theTree.insert(30);
        theTree.insert(70);

        theTree.displayTree();
    }
}
