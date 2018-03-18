package com.jiakaiyang.lintcode.java.test;

import com.jiakaiyang.lintcode.java.LintCode163;
import org.junit.Test;

/**
 * Test of LintCode163
 */
public class LintCode163Test {

    @Test
    public void addListsTest() {
        LintCode163.ListNode l1 = new LintCode163.ListNode(3);
        l1.next = new LintCode163.ListNode(1);
        l1.next.next = new LintCode163.ListNode(5);

        LintCode163.ListNode l2 = new LintCode163.ListNode(5);
        l2.next = new LintCode163.ListNode(9);
        l2.next.next = new LintCode163.ListNode(2);

        LintCode163.addLists(l1, l2);
    }

}
