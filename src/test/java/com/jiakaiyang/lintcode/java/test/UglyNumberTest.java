package com.jiakaiyang.lintcode.java.test;

import com.jiakaiyang.lintcode.java.UglyNumber;
import org.junit.Test;

/**
 * Created by jia on 2017/8/27.
 */
public class UglyNumberTest {

    @Test
    public void GetUglyNumberTest() {
        int ugly100 = UglyNumber.getUglyNumber(1665);
        System.out.print(ugly100);
    }
}
