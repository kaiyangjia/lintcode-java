package com.jiakaiyang.lintcode.java.lintcode;

import com.jiakaiyang.lintcode.java.lintcode.entity.ListNode;

/**
 * 102. 带环链表
 * 给定一个链表，判断它是否有环。
 * <p>
 * ```
 * 样例 1:
 * 输入: 21->10->4->5,  then tail connects to node index 1(value 10).
 * 输出: true
 * <p>
 * 样例 2:
 * 输入: 21->10->4->5->null
 * 输出: false
 * <p>
 * ```
 * <p>
 * Created by jia on 12/4/2020
 * github: https://github.com/kaiyangjia
 */
public class No102LinkedListCycle {

    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        // write your code here
        // 空列表无环
        if (head == null) {
            return false;
        }

        // 初始化快慢两个指针
        ListNode fast = head, slow = head;

        while (true) {
            // 快指针，步进两步
            fast = fast.next;
            if (fast == null) {
                return false;
            }
            fast = fast.next;

            // 慢指针，步进一步
            slow = slow.next;

            if (fast == null || slow == null) {
                // 无环
                return false;
            }

            // 快慢指针相遇，有环
            if (fast.val == slow.val) {
                return true;
            }
        }
    }
}
