package org.abewang.dsaa.hash;

/**
 * @Author Abe
 * @Date 2018/3/28.
 */
public class DataItem {
    private int iData;

    public DataItem(int iData) {
        this.iData = iData;
    }

    public int getKey() {
        return iData;
    }
}
