package com.jiakaiyang.lintcode.java.test;

import com.jiakaiyang.lintcode.java.lintcode.No52NextPermutation;
import org.junit.Test;

/**
 * Created by jia on 1/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No52NextPermutationTest {

    @Test
    public void nextPermutationTest() {
        int[] array = new int[]{2, 4, 3, 3, 1};
        int[] result = No52NextPermutation.nextPermutation(array);
        System.out.println("result : " + result);
    }
}
