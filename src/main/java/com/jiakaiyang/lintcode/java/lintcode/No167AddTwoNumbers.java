package com.jiakaiyang.lintcode.java.lintcode;

/**
 * Lint Code 167 题
 *
 * https://www.lintcode.com/problem/add-two-numbers/description
 *
 * 链表求和
 * 你有两个用链表代表的整数，其中每个节点包含一个数字。数字存储按照在原来整数中相反的顺序，使得第一个数字位于链表的开头。写出一个函数将两个整数相加，用链表形式返回和。
 *
 */
public class No167AddTwoNumbers {

    /*
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public static ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode result = null;
        int carry = 0;

        ListNode a = l1;
        ListNode b = l2;

        for (; ; ) {
            if (a == null
                    && b == null
                    && carry == 0) {
                break;
            }

            int valA = (a == null) ? 0 : a.val;
            int valB = (b == null) ? 0 : b.val;

            int newVal = valA + valB + carry;

            carry = newVal / 10;

            ListNode node = new ListNode(newVal % 10);

            if (result == null) {
                // first time
                result = node;
            } else {
                append(result, node);
            }

            if (a != null) {
                a = a.next;
            }

            if (b != null) {
                b = b.next;
            }
        }

        return result;
    }


    public static void append(ListNode root, ListNode node) {
        ListNode tmp = root;
        while (tmp.next != null) {
            tmp = tmp.next;
        }

        tmp.next = node;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
