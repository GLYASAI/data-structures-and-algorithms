package org.abewang.dsaa.iq.rdp;

import java.util.Stack;

/**
 * 逆序栈
 *
 * @Author Abe
 * @Date 2018/6/16.
 */
public class ReverseStack {
    public static <T> void reverse(Stack<T> stack) {
        if (stack.isEmpty()) {
            return;
        }

        T item = getAndRemoveLast(stack);
        reverse(stack);
        stack.push(item);
    }

    public static <T> T getAndRemoveLast(Stack<T> stack) {
        T result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            T last = getAndRemoveLast(stack);
            stack.push(result);
            return last;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> test = new Stack<>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        reverse(test);
        while (!test.isEmpty()) {
            System.out.println(test.pop());
        }
    }
}
