package com.jiakaiyang.lintcode.java.lintcode;

/**
 * Created by jia on 7/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No859MaxStack {

    public static class MaxStack {
        private int[] data;
        private int[] dataMax;
        private int size = 0;
        private int sizeMax = 0;

        public MaxStack() {
            // do intialization if necessary

            data = new int[16];
            dataMax = new int[8];
        }

        /*
         * @param number: An integer
         * @return: nothing
         */
        public void push(int x) {
            // write your code here
            if (sizeMax == 0) {
                dataMax[sizeMax] = x;
                sizeMax++;
            } else {
                int top = peekMax();
                if (x >= top) {
                    // 新数据需要添加到 max stack
                    checkAndResize(dataMax, sizeMax);
                    dataMax[sizeMax] = x;

                    sizeMax++;
                }
            }

            checkAndResize(data, size);
            data[size] = x;
            size++;
        }

        public int pop() {
            // write your code here
            if (size <= 0) {
                //
                return -1;
            }

            int result = data[size - 1];
            int topOfMax = peekMax();
            if (result == topOfMax) {
                // 需要pop的数据也是当前max 栈的栈顶
                dataMax[sizeMax - 1] = 0;
                sizeMax--;
            }

            data[size - 1] = 0;
            size--;
            return result;
        }

        /*
         * @return: An integer
         */
        public int top() {
            // write your code here
            if (size <= 0) {
                //
                return -1;
            }

            int result = data[size - 1];
            return result;
        }

        /*
         * @return: An integer
         */
        public int peekMax() {
            // write your code here

            if (sizeMax <= 0) {
                return -1;
            }

            return dataMax[sizeMax - 1];
        }

        /*
         * @return: An integer
         */
        public int popMax() {
            // write your code here
            if (data.length <= 0) {
                return -1;
            }
            int topOfMax = peekMax();

            int maxLastIndex = size - 1;
            while (maxLastIndex >= 0) {
                int tmp = data[maxLastIndex];
                if (tmp == topOfMax) {
                    break;
                }

                maxLastIndex--;
            }

            if (maxLastIndex <= 0) {
                // not find,error
                return -1;
            }

            // 当前的就是最大的
            if (maxLastIndex == size - 1) {
                return pop();
            }

            int max = data[maxLastIndex];
            // remove maxLastIndex data
            int targetLength = size - maxLastIndex - 1;
            System.arraycopy(data, maxLastIndex + 1, data, maxLastIndex, targetLength);
            data[size - 1] = 0;
            size--;

            // pop max stack
            dataMax[sizeMax - 1] = 0;
            sizeMax--;
            return max;
        }

        private void resize() {
            int[] newData = new int[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);

            data = newData;
        }

        private void checkAndResize(int[] array, int size) {
            if (array.length <= size) {
                // 需要扩容
                resize();
            }
        }
    }
}
