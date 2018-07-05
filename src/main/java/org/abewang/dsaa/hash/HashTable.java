package org.abewang.dsaa.hash;

/**
 * 用二次探测实现的哈希表
 *
 * @Author Abe
 * @Date 2018/3/28.
 */
public class HashTable {
    private int arraySize;
    private DataItem hashArray[];
    private DataItem nonItem;

    public HashTable(int arraySize) {
        this.arraySize = arraySize;
        this.hashArray = new DataItem[arraySize];
        DataItem nonItem = new DataItem(-1);
        this.nonItem = nonItem;
    }

    public void displayTable()
    {
        System.out.print("Table: ");
        for(int j=0; j<arraySize; j++)
        {
            if(hashArray[j] != null)
                System.out.print(hashArray[j].getKey() + " ");
            else
                System.out.print("** ");
        }
        System.out.println("");
    }

    public int hashFunc(int key) {
        return key % arraySize;
    }

    public void insert(DataItem dItem) {
        int hashValue = hashFunc(dItem.getKey());
        int hashDoubleValue = hashValue;

        int i = 1;
        while (hashArray[hashDoubleValue] != null && hashArray[hashDoubleValue].getKey() != -1) {
            hashDoubleValue = hashValue + i^2;
            i++;

            hashValue %= arraySize;
        }

        hashArray[hashDoubleValue] = dItem;
    }

    public void delete(int key) {
        int hashValue = hashFunc(key);
        int hashDoubleValue = hashValue;

        int i = 1;
        while (hashArray[hashValue] == null || hashArray[hashValue].getKey() == -1) {
            hashDoubleValue = hashValue + i^2;
            i++;
            hashDoubleValue %= arraySize;
        }

        hashArray[hashDoubleValue] = nonItem;
    }

    public DataItem find(int key) {
        int hashValue = hashFunc(key);
        int hashDoubleValue = hashValue;

        int i = 1;
        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].getKey() != key) {
                hashDoubleValue = hashValue + i^2;
                i++;
                hashDoubleValue %= arraySize;
            } else {
                return hashArray[hashDoubleValue];
            }
        }

        return null;
    }
}
