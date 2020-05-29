package com.jiakaiyang.lintcode.java.test;

import com.jiakaiyang.lintcode.java.lintcode.No491PalindromeNumber;
import org.junit.Test;

/**
 * Created by jia on 29/5/2020
 * github: https://github.com/kaiyangjia
 */
public class No419PalindromeNumberTest {

    @Test
    public void sizeOfTest() {
        int result = No491PalindromeNumber.sizeOf(99);
        assert result == 2;
    }

    @Test
    public void isPalindromeTest() {
        boolean result = No491PalindromeNumber.isPalindrome(100001);
        assert result;

        result = No491PalindromeNumber.isPalindrome(10011);
        assert !result;

        result = No491PalindromeNumber.isPalindrome(12221);
        assert result;

        result = No491PalindromeNumber.isPalindrome(12321);
        assert result;
    }
}
