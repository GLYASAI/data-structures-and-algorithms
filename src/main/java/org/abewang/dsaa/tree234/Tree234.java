package org.abewang.dsaa.tree234;

/**
 * 2-3-4树
 * @Author Abe
 * @Date 2018/3/24.
 */
public class Tree234 {
    private Node root = new Node();

    public void insert(long dValue) {
        Node curNode = root;
        DataItem tempItem = new DataItem(dValue);

        while (true) {
            if (curNode.isFull()) {
                split(curNode);
                curNode = curNode.getParent();
                curNode = getNextChild(curNode, dValue);
            } else if (curNode.isLeaf()) {
                break;
            } else {
                curNode = getNextChild(curNode, dValue);
            }
        }

        curNode.insertItem(tempItem);
    }

    private void split(Node thisNode) {
        // assume node is full
        Node parent;

        DataItem itemC = thisNode.removeItem();
        DataItem itemB = thisNode.removeItem();

        Node child2 = thisNode.getChild(2);
        Node child3 = thisNode.getChild(3);

        Node newRight = new Node();
        newRight.insertItem(itemC);newRight.connectChild(0, child2);
        newRight.connectChild(1, child3);
        if (thisNode == root) {
            root = new Node();
            parent = root;
            parent.connectChild(0, thisNode);
        } else {
            parent = thisNode.getParent();
        }

        // 将itemB右边的item右移一位
        int itemIndex = parent.insertItem(itemB);
        for (int i = parent.getNumItems() - 1; i > itemIndex; i--) {
            Node temp = parent.disconnectChild(i);
            parent.connectChild(i + 1, temp);
        }

        parent.connectChild(itemIndex + 1, newRight);
    }

    public Node getNextChild(Node node, long theValue) {
        int i;
        // assume node is not empty, not full, not a leaf
        for (i = 0; i < node.getNumItems(); i++){
            if (node.getdData(i) > theValue) {
                return node.getChild(i);
            }
        }
        return node.getChild(i);
    }

    public void displayTree() {
        this.recDisplayTree(root, 0, 0);
    }

    public void recDisplayTree(Node thisNode, int level, int childNumber) {
        System.out.print("level=" + level + " child=" + childNumber + " ");
        thisNode.displayNode();

        for (int i = 0; i < thisNode.getNumItems() + 1; i++) {  // 子节点数比item数多1，所以numItems + 1
            Node nextNode = thisNode.getChild(i);
            if (nextNode != null) {
                recDisplayTree(nextNode, level + 1, i);
            } else {
                return;
            }
        }
    }
}
