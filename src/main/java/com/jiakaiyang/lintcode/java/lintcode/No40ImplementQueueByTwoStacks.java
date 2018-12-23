package com.jiakaiyang.lintcode.java.lintcode;

import java.util.Stack;

/**
 * 40.用栈实现队列
 * <p>
 * https://www.lintcode.com/problem/implement-queue-by-two-stacks/description
 * <p>
 * <p>
 * 描述
 * <p>
 * 正如标题所述，你需要使用两个栈来实现队列的一些操作。
 * <p>
 * 队列应支持push(element)，pop() 和 top()，其中pop是弹出队列中的第一个(最前面的)元素。
 * <p>
 * pop和top方法都应该返回第一个元素的值。
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * <p>
 * 比如push(1), pop(), push(2), push(3), top(), pop()，你应该返回1，2和2
 * 挑战
 * <p>
 * 仅使用两个栈来实现它，不使用任何其他数据结构，push，pop 和 top的复杂度都应该是均摊O(1)的
 */
public class No40ImplementQueueByTwoStacks {


    public class MyQueue {
        private Stack<Integer> storeStack;
        private Stack<Integer> tmpStack;

        public MyQueue() {
            // do intialization if necessary

            storeStack = new Stack<>();
            tmpStack = new Stack<>();
        }

        /*
         * @param element: An integer
         * @return: nothing
         */
        public void push(int element) {
            // write your code here
            if (!tmpStack.isEmpty()) {
                switchStack(tmpStack, storeStack);
            }

            storeStack.push(element);
        }

        /*
         * @return: An integer
         */
        public int pop() {
            // write your code here
            if (tmpStack.empty()) {
                switchStack(storeStack, tmpStack);
            }

            return tmpStack.pop();
        }

        /*
         * @return: An integer
         */
        public int top() {
            // write your code here
            if (tmpStack.empty()) {
                switchStack(storeStack, tmpStack);
            }

            return tmpStack.peek();
        }

        /**
         * move all element from src to des
         *
         * @param src
         * @param des
         */
        private <T> void switchStack(Stack<T> src, Stack<T> des) {
            if (src == null || des == null) {
                return;
            }

            while (!src.isEmpty()) {
                T e = src.pop();
                des.push(e);
            }
        }
    }
}
