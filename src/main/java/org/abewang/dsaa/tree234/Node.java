package org.abewang.dsaa.tree234;

/**
 * @Author Abe
 * @Date 2018/3/24.
 */
public class Node {
    private static final int ORDER = 4;
    private int numItems = 0;
    private Node parent;
    private Node[] childArr = new Node[ORDER];
    private DataItem[] itemArr = new DataItem[ORDER - 1];

    public Node getChild(int index) {
        return childArr[index];
    }

    public long getdData(int index) {
        return itemArr[index].getdData();
    }

    public DataItem getItem(int index) {
        return itemArr[index];
    }

    public int getNumItems() {
        return numItems;
    }

    public Node getParent() {
        return parent;
    }

    public boolean isFull() {
        return numItems == ORDER - 1;
    }

    public boolean isLeaf() {
        return childArr[0] == null;
    }

    public int insertItem(DataItem newItem) {
        // assume node is not full
        numItems++;

        for (int i = numItems - 1; i >= 0; i--) {
            if (itemArr[i] == null) {
                continue;
            } else {
                if (itemArr[i].getdData() > newItem.getdData()) {
                    itemArr[i + 1] = itemArr[i];
                } else {
                    itemArr[i + 1] = newItem;
                    return i + 1;
                }
            }
        }

        itemArr[0] = newItem;
        return 0;
    }

    public DataItem removeItem() {
        DataItem result = itemArr[numItems -1];
        itemArr[numItems -1] = null;  // disconnect it
        numItems--;
        return result;
    }

    public void connectChild(int childNum, Node child) {
        childArr[childNum] = child;
        if (child != null) {
            child.parent = this;
        }
    }

    public Node disconnectChild(int childNum) {
        Node temp = childArr[childNum];
        childArr[childNum] = null;
        return temp;
    }

    public void displayNode() {
        for (int i = 0; i < numItems; i++) {
            itemArr[i].displayItem();
        }
        System.out.println("/");
    }
}
