package com.jiakaiyang.oj.java.lintcode.test;

import com.jiakaiyang.oj.java.lintcode.No415ValidPalindrome;
import org.junit.Test;

/**
 * Created by jia on 27/5/2020
 * github: https://github.com/kaiyangjia
 */
public class No415ValidPalindromeTest {

    @Test
    public void solutionTest() {
        boolean result;

        result = No415ValidPalindrome.isPalindrome("A man, a plan, a canal: Panama");
        assert result;

        result = No415ValidPalindrome.isPalindrome("1`2.3.32...1");
        assert result;

        result = No415ValidPalindrome.isPalindrome("..,,...");
        assert result;

        result = No415ValidPalindrome.isPalindrome("");
        assert result;

        result = No415ValidPalindrome.isPalindrome("222222");
        assert result;

        result = No415ValidPalindrome.isPalindrome("121212");
        assert !result;
    }

    @Test
    public void validCharTest() {
        boolean result = No415ValidPalindrome.validChar('1');
        assert result;

        result = No415ValidPalindrome.validChar(',');
        assert !result;

        result = No415ValidPalindrome.validChar('.');
        assert !result;

        result = No415ValidPalindrome.validChar('z');
        assert result;

        result = No415ValidPalindrome.validChar('0');
        assert result;

        result = No415ValidPalindrome.validChar(' ');
        assert !result;
    }
}
