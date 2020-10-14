package com.jiakaiyang.oj.java.lintcode.test;

import com.jiakaiyang.oj.java.lintcode.No859MaxStack;
import org.junit.Test;

/**
 * Created by jia on 7/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No859MaxStackTest {

    @Test
    public void maxStackTest() {
        No859MaxStack.MaxStack stack = new No859MaxStack.MaxStack();

        stack.push(5);
        stack.push(1);
        stack.push(5);
        int top = stack.top();
        System.out.println(top);

        int popMax = stack.popMax();
        System.out.println(popMax);

        top = stack.top();
        System.out.println(top);

        popMax = stack.peekMax();
        System.out.println(popMax);

        top = stack.pop();
        System.out.println(top);

        top = stack.top();
        System.out.println(top);
    }
}
