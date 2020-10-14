package com.jiakaiyang.oj.java.lintcode;

/**
 * LintCode 35. 反转链表
 * <p>
 * <p>
 * https://www.lintcode.com/problem/reverse-linked-list/description
 * <p>
 * 描述
 * <p>
 * 翻转一个链表
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * <p>
 * 给出一个链表1->2->3->null，这个翻转后的链表为3->2->1->null
 * 挑战
 * <p>
 * 在原地一次翻转完成
 */
public class No35ReverseLinkedList {

    /**
     * 递归实现反转链表
     *
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here

        if (head == null || head.next == null) {
            return head;
        }

        ListNode listNode = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return listNode;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
