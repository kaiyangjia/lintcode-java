package com.jiakaiyang.oj.java.lintcode.test;

import com.jiakaiyang.oj.java.lintcode.No167AddTwoNumbers;
import org.junit.Test;

/**
 * Test of No167AddTwoNumbers
 */
public class No167AddTwoNumbersTest {

    @Test
    public void addListsTest() {
        No167AddTwoNumbers.ListNode l1 = new No167AddTwoNumbers.ListNode(3);
        l1.next = new No167AddTwoNumbers.ListNode(1);
        l1.next.next = new No167AddTwoNumbers.ListNode(5);

        No167AddTwoNumbers.ListNode l2 = new No167AddTwoNumbers.ListNode(5);
        l2.next = new No167AddTwoNumbers.ListNode(9);
        l2.next.next = new No167AddTwoNumbers.ListNode(2);

        No167AddTwoNumbers.addLists(l1, l2);
    }

}
