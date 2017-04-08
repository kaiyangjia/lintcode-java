package com.jiakaiyang.lintcode.java.test;

import com.jiakaiyang.lintcode.java.TrailingZeros;
import org.junit.Test;

/**
 * Created by jia on 17-4-8.
 */
public class TrailingZerosTest {

    @Test
    public void TestResult(){
        long result26 = TrailingZeros.getResult(26);
        long result36 = TrailingZeros.getResult(36);

        System.out.print(result26 + ", "+ result36);
    }
}
