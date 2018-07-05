package org.abewang.dsaa.iq;

import java.util.Stack;

/**
 * @Author Abe
 * @Date 2018/5/2.
 */
public class GetMinStack {
    /**
     * 数据栈
     */
    private Stack<Integer> dataStack = new Stack<>();
    /**
     * 最小值栈
     */
    private Stack<Integer> minStack = new Stack<>();

    public void push(Integer item) {
        dataStack.push(item);
        if (minStack.isEmpty()) {
            minStack.push(item);
        } else {
            item = item < minStack.peek() ? item : minStack.peek();
            minStack.push(item);
        }
    }

    public Integer pop() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("The stack is empty.");
        }
        Integer res = dataStack.pop();
        minStack.pop();
        return res;
    }

    public Integer getMin() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("The stack is empty.");
        }

        return minStack.peek();
    }

    public static void main(String[] args) {
        GetMinStack getMinstack = new GetMinStack();
        getMinstack.push(3);
        System.out.println(getMinstack.getMin());
        getMinstack.push(4);
        System.out.println(getMinstack.getMin());
        getMinstack.push(1);
        System.out.println(getMinstack.getMin());
        System.out.println(getMinstack.pop());
        System.out.println(getMinstack.getMin());
    }
}
