package com.jiakaiyang.lintcode.java.test;

import com.jiakaiyang.lintcode.java.lintcode.No28SearchA2dMatrix;
import org.junit.Test;

/**
 * Created by jia on 19/1/2020
 * github: https://github.com/kaiyangjia
 */
public class No28SearchA2dMatrixTest {

    @Test
    public void SearchA2DMatrixTest() {
        int[][] array = {{1,4,5},{6,7,8}};
        int target = 8;

        boolean result = No28SearchA2dMatrix.searchMatrix(array, target);
        System.out.println("result: " + result);
        assert result;
    }
}
