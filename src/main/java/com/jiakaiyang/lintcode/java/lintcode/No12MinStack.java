package com.jiakaiyang.lintcode.java.lintcode;

import java.util.Stack;

/**
 * 12. 带最小值操作的栈
 * <p>
 * https://www.lintcode.com/problem/min-stack/description
 */
public class No12MinStack {


    public class MinStack {
        private Stack<Integer> data;
        private Stack<Integer> minStack;

        public MinStack() {
            // do intialization if necessary
            data = new Stack<Integer>();
            minStack = new Stack<Integer>();
        }

        /*
         * @param number: An integer
         * @return: nothing
         */
        public void push(int number) {
            // write your code here
            data.push(number);

            if (minStack.empty()) {
                minStack.push(number);
            } else {
                int currentMin = minStack.peek();
                int min = Math.min(currentMin, number);
                minStack.push(min);
            }
        }

        /*
         * @return: An integer
         */
        public int pop() {
            // write your code here
            minStack.pop();

            return data.pop();
        }

        /*
         * @return: An integer
         */
        public int min() {
            // write your code here
            return minStack.peek();
        }
    }

}
