package org.abewang.iq.btree;

/**
 * @Author Abe
 * @Date 2018/5/12.
 */
public class Node {
    public Integer value;
    public Node left;
    public Node right;

    public Node(Integer value) {
        this.value = value;
    }
}
