package com.jiakaiyang.oj.java.lintcode;

import java.util.List;

/**
 * TODO not done
 * https://www.lintcode.com/problem/partition-list/description
 * 96. 链表划分
 * 描述
 * 给定一个单链表和数值x，划分链表使得所有小于x的节点排在大于等于x的节点之前。
 * 你应该保留两部分内链表节点原有的相对顺序。
 * <p>
 * Created by jia on 21/1/2020
 * github: https://github.com/kaiyangjia
 */
public class No96PartitionList {
    /**
     * @param head: The first node of linked list
     * @param x:    An integer
     * @return: A ListNode
     */
    public static ListNode partition(ListNode head, int x) {
        // write your code here
        if (head == null) {
            return null;
        }

        ListNode smallTail = null, bigTail = null;
        ListNode smallHead = null, bigHead = null;

        ListNode tmp = head;
        while (tmp != null) {
            if (tmp.val < x) {
                // 添加到小于的数组中
                if (smallTail != null) {
                    smallTail.next = tmp;
                    System.out.println("append small : " + tmp.val);
                } else {
                    smallHead = tmp;
                    System.out.println("set small head: " + smallHead.val);
                }
                smallTail = tmp;
            } else {
                if (bigTail != null) {
                    bigTail.next = tmp;
                    System.out.println("append big : " + tmp.val);
                } else {
                    bigHead = tmp;
                    System.out.println("set big head: " + bigHead.val);
                }
                bigTail = tmp;
            }

            tmp = tmp.next;
        }

        if (smallTail != null) {
            smallTail.next = bigHead;
        }

        return smallHead;
    }


    /**
     * Definition for ListNode
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
