package org.abewang.dsaa.tree234;

/**
 * @Author Abe
 * @Date 2018/3/24.
 */
public class DataItem {
    private long dData;

    public DataItem(long dData) {
        this.dData = dData;
    }

    public long getdData() {
        return dData;
    }

    public void displayItem() {
        System.out.print("/" + dData);
    }
}
