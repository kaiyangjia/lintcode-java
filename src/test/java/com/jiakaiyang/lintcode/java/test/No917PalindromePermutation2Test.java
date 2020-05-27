package com.jiakaiyang.lintcode.java.test;

import com.jiakaiyang.lintcode.java.lintcode.No917PalindromePermutation2;
import org.junit.Test;

import java.util.List;

/**
 * Created by jia on 26/5/2020
 * github: https://github.com/kaiyangjia
 */
public class No917PalindromePermutation2Test {

    @Test
    public void solutionTest() {
        List<String> result = No917PalindromePermutation2.generatePalindromes("aabb");
        System.out.println(result);

        result = No917PalindromePermutation2.generatePalindromes("abs");
        System.out.println(result);

        result = No917PalindromePermutation2.generatePalindromes("");
        System.out.println(result);

        result = No917PalindromePermutation2.generatePalindromes("abbbbsbba");
        System.out.println(result);

        result = No917PalindromePermutation2.generatePalindromes("aabbccc");
        System.out.println(result);
    }
}
