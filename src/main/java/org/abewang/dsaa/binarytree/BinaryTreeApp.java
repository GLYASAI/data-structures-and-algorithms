package org.abewang.dsaa.binarytree;

/**
 * @Author Abe
 * @Date 2018/4/12.
 */
public class BinaryTreeApp {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();

        tree.insert(50, 2 * 50);
        tree.insert(30, 2 * 30);
        tree.insert(60, 2 * 60);
        tree.insert(20, 2 * 20);
        tree.insert(40, 2 * 40);
        tree.insert(10, 2 * 10);
        tree.insert(70, 2 * 70);
        tree.insert(80, 2 * 80);
        tree.insert(75, 2 * 75);
        tree.insert(90, 2 * 90);
        tree.insert(79, 2 * 79);
        tree.insert(100, 2 * 100);
        tree.insert(91, 2 * 91);

        BinaryTreePrinter.printNode(tree.find(50));
    }
}
