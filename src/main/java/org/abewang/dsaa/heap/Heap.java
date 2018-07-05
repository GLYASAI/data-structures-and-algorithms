package org.abewang.dsaa.heap;

/**
 * 升序的堆（编程作业12.1）
 *
 * @Author Abe
 * @Date 2018/3/31.
 */
public class Heap {
    public Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        currentSize = 0;
        heapArray = new Node[maxSize];
    }

    public void displayHeap() {
        System.out.print("heapArray: ");    // array format
        for (int m = 0; m < currentSize; m++)
            if (heapArray[m] != null)
                System.out.print(heapArray[m].getKey() + " ");
            else
                System.out.print("-- ");
        System.out.println();
        // heap format
        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;                          // current item
        String dots = "...............................";
        System.out.println(dots + dots);      // dotted top line

        while (currentSize > 0)              // for each heap item
        {
            if (column == 0)                  // first item in row?
                for (int k = 0; k < nBlanks; k++)  // preceding blanks
                    System.out.print(' ');
            // display item
            System.out.print(heapArray[j].getKey());

            if (++j == currentSize)           // done?
                break;

            if (++column == itemsPerRow) {       // end of row?
                nBlanks /= 2;                 // half the blanks
                itemsPerRow *= 2;             // twice the items
                column = 0;                   // start over on
                System.out.println();         //    new row
            } else                             // next item on row
                for (int k = 0; k < nBlanks * 2 - 2; k++)
                    System.out.print(' ');     // interim blanks
        }  // end for
        System.out.println("\n" + dots + dots); // dotted bottom line
    }  // end displayHeap()

    public boolean insert(int key) {
        if (currentSize == maxSize) {
            return false;
        }

        heapArray[currentSize] = new Node(key);
        trickleUp(currentSize++);
        return true;
    }

    public void trickleUp(int index) {
        Node bottom = heapArray[index]; // 需要向上比较的值

        // index > 0 => 到root的时候停止
        while (index > 0 && heapArray[(index - 1) / 2].getKey() > bottom.getKey()) {
            heapArray[index] = heapArray[(index - 1) / 2];
            index = (index - 1) / 2;
        }

        heapArray[index] = bottom;
    }

    public Node remove() {
        if (currentSize == 0) {
            System.out.println("这是空堆，你不要搞事情");
            return null;
        }

        // 删除根节点，并把最后的节点作为根节点
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];

        // 平衡
        trickleDown(0);

        return root;
    }

    public void trickleDown(int index) {
        Node root = heapArray[index];
        int smallChild;
        while (2 * index + 1 < currentSize) {  // 至少有一个子节点
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            // 获取子节点中最小的一个
            // rightChild < currentSize, 因为最大的索引为currentSize - 1
            if (rightChild < currentSize && heapArray[rightChild].getKey() < heapArray[leftChild].getKey()) {
                smallChild = rightChild;
            } else {
                smallChild = leftChild;
            }

            // 小根堆
            if (root.getKey() < heapArray[smallChild].getKey()) {
                break;
            }

            heapArray[index] = heapArray[smallChild];
            index = smallChild;
        }

        heapArray[index] = root;
    }

    public boolean change(int index, int newValue) {
        if (index < 0 || index >= currentSize) {
            return false;
        }

        int oldValue = heapArray[index].getKey();
        heapArray[index].setKey(newValue);

        if (newValue > oldValue) {
            trickleDown(index);
        } else if (newValue < oldValue) {
            trickleUp(index);
        }

        return true;
    }
}
