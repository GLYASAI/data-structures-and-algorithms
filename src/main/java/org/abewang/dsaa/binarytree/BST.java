package org.abewang.dsaa.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉搜索树
 *
 * @Author Abe
 * @Date 2018/3/16.
 */
public class BST<T> {
    private Node<T> root;

    public BST() {
        root = null;
    }

    public Node<T> find(int key) {  // 假设树不为空
        Node current = root;

        while (key != current.key) {
            if (key < current.key) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }

            if (current == null) {
                return null;
            }
        }

        return current;
    }

    /**
     * 插入节点
     */
    public void insert(int iData, T data) {
        // 创建一个新的节点
        Node<T> newNode = new Node<>(iData, data);

        // 分两种情况：1.根节点，2.非根节点
        if (root == null) {
            root = newNode;
        } else {
            // 从根节点开始，比较新节点和当前节点的大小，然后选择相应的子节点
            Node current = root;
            Node parent;
            while (current != null) {
                parent = current;
                if (iData < parent.key && (current = current.leftChild) == null) {   // 左子节点
                    parent.leftChild = newNode;
                } else if (iData >= parent.key && (current = current.rightChild) == null) { // 右子节点
                    parent.rightChild = newNode;
                }
            }
        }
    }

    /**
     * 中序遍历, 左中右
     *
     * @param node 根节点
     */
    public void inOrder(Node node) {
        if (null != node) {
            inOrder(node.leftChild);

            System.out.print(node.key + " ");

            inOrder(node.rightChild);
        }
    }

    /**
     * 中序遍历，非递归
     *
     * @param node 根节点
     */
    public void inOrderNonRec(Node node) {
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.leftChild;
            } else {
                node = stack.pop();
                System.out.print(node.key + " ");
                node = node.rightChild;
            }
        }
    }


    /**
     * 前序遍历, 中左右
     */
    public void preOrder(Node node) {
        if (null != node) {
            System.out.print(node.key + " ");

            preOrder(node.leftChild);

            preOrder(node.rightChild);
        }
    }

    /**
     * 前序遍历，非递归
     */
    public void preOrderNonRec(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.print(cur.key + " ");
            if (cur.rightChild != null) {
                stack.push(cur.rightChild);
            }
            if (cur.leftChild != null) {
                stack.push(cur.leftChild);
            }
            java.util.Queue<String> queue = new LinkedList<>();
        }
    }

    /**
     * 后序遍历, 左右中
     */
    public void postOrder(Node node) {
        if (null != node) {
            postOrder(node.leftChild);

            postOrder(node.rightChild);

            System.out.print(node.key + " ");
        }
    }

    /**
     * 后序遍历, 非递归
     * @param node
     */
    public void postOrderNonRec(Node node) {
        Stack<Node> stack = new Stack<>();
        Stack<Node> resStack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            resStack.push(node);
            if (node.leftChild != null) {
                stack.push(node.leftChild);
            }
            if (node.rightChild != null) {
                stack.push(node.rightChild);
            }
        }
        while (!resStack.isEmpty()) {
            System.out.print(resStack.pop().key + " ");
        }
    }

    /**
     * 查找最小值
     */
    public Node minimum() {
        Node current = root;
        Node parent = null;
        while (current != null) {
            parent = current;
            current = current.leftChild;
        }

        return parent;
    }

    /**
     * 查找最大值
     */
    public Node maximum() {
        Node current = root;
        Node parent = null;
        while (current != null) {
            parent = current;
            current = current.rightChild;
        }

        return parent;
    }

    /**
     * 删除
     */
    public boolean delete(int iData) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current != null && current.key != iData) {
            parent = current;
            if (iData < current.key) {
                current = current.leftChild;
                isLeftChild = true;
            } else {
                current = current.rightChild;
                isLeftChild = false;
            }
        }

        if (current == null) { // 没有找到
            return false;
        }

        if (current.leftChild == null && current.rightChild == null) {  // 没有子节点
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.leftChild == null) {  // 有右子节点
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else if (current.rightChild == null) {  // 有左子节点
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else {  // 右两个子节点
            Node successor = getSuccessor(current);

            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.rightChild = current.rightChild;
            successor.leftChild = current.leftChild;

        }

        return true;
    }

    /**
     * 获取后继节点
     *
     * @param delNode 被删除节点
     * @return 后继节点
     */
    public Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode.rightChild;

        while (successor.leftChild != null) {
            successorParent = successor;
            successor = successor.leftChild;
        }

        if (successor == delNode.rightChild) {
            successorParent.rightChild = successor.rightChild;
        } else {
            successorParent.leftChild = successor.rightChild;
        }
        successor.rightChild = null;

        return successor;
    }

    public void displayTree() {
        postOrderNonRec(root);
    }
}
