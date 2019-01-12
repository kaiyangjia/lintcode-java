package com.jiakaiyang.lintcode.java.test;

import com.jiakaiyang.lintcode.java.lintcode.No37Reverse3DigitInteger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class No37Reverse3DigitIntegerTest {

    @Test
    public void testReverseInteger() {
        int result = No37Reverse3DigitInteger.MySolution.reverseInteger(645);
        System.out.println(result);
        assert result == 546;

        result = No37Reverse3DigitInteger.MySolution.reverseInteger(430);
        System.out.println(result);
        assert result == 34;

        result = No37Reverse3DigitInteger.MySolution.reverseInteger(100);
        System.out.println(result);
        assert result == 1;

        result = No37Reverse3DigitInteger.MySolution.reverseInteger(201);
        System.out.println(result);
        assert result == 102;
    }

    @Test
    public void testMergeToInt() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        int result = No37Reverse3DigitInteger.MySolution.mergeToInt(list);
        assert result == 321;

        //
        list.clear();
        list.add(3);
        list.add(2);
        result = No37Reverse3DigitInteger.MySolution.mergeToInt(list);
        assert result == 32;


        list.clear();
        list.add(3);
        result = No37Reverse3DigitInteger.MySolution.mergeToInt(list);
        assert result == 3;
    }
}
