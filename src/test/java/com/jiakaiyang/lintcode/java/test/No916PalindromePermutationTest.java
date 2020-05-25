package com.jiakaiyang.lintcode.java.test;

import com.jiakaiyang.lintcode.java.lintcode.No916PalindromePermutation;
import org.junit.Test;

/**
 * Created by jia on 24/5/2020
 * github: https://github.com/kaiyangjia
 */
public class No916PalindromePermutationTest {

    @Test
    public void testSolution() {
        boolean result = No916PalindromePermutation.canPermutePalindrome("");
        assert !result;

        result = No916PalindromePermutation.canPermutePalindrome("1231");
        assert !result;


        result = No916PalindromePermutation.canPermutePalindrome("2222");
        assert result;

        result = No916PalindromePermutation.canPermutePalindrome("1271233");
        assert result;

        result = No916PalindromePermutation.canPermutePalindrome("aab");
        assert result;
    }
}
