package org.abewang.dsaa.iq;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * 仅用队列结构实现栈结构
 * 仅用栈结构实现队列结构
 *
 * @Author Abe
 * @Date 2018/5/2.
 */
public class StackQueueTransform {
    /**
     * 用两个队列实现一个栈
     */
    public static class StackByQueue {
        private Queue<Integer> queue;
        private Queue<Integer> helpQ;

        public StackByQueue() {
            queue = new LinkedList<>();
            helpQ = new LinkedList<>();
        }

        public void push(Integer item) {
            queue.add(item);
        }

        public Integer pop() {
            if (queue.isEmpty()) {
                throw new RuntimeException("The stack is empty!");
            }

            while (queue.size() != 1) {
                helpQ.add(queue.poll());
            }
            Integer res = queue.poll();
            swap();

            return res;
        }

        public Integer peek() {
            if (queue.isEmpty()) {
                throw new RuntimeException("The stack is empty!");
            }

            while (queue.size() != 1) {
                helpQ.add(queue.poll());
            }
            Integer res = queue.poll();
            helpQ.add(res);
            swap();

            return res;
        }

        private void swap() {
            Queue<Integer> temp = queue;
            queue = helpQ;
            helpQ = temp;
        }
    }

    /**
     * 用两个栈实现一个队列
     */
    public static class QueueByStack {
        private Stack<Integer> pushStack;
        private Stack<Integer> popStack;

        public QueueByStack() {
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }

        public void push(Integer item) {
            pushStack.push(item);
        }

        public Integer pop() {
            if (pushStack.isEmpty() && popStack.isEmpty()) {
                throw new RuntimeException("The queue is empty");
            } else if (popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    popStack.push(pushStack.pop());
                }
            }

            return popStack.pop();
        }

        public Integer peek() {
            if (pushStack.isEmpty() && popStack.isEmpty()) {
                throw new RuntimeException("The queue is empty");
            } else if (popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    popStack.push(pushStack.pop());
                }
            }

            return popStack.peek();
        }
    }
}
