package com.jiakaiyang.lintcode.java.test;

import com.jiakaiyang.lintcode.java.lintcode.No2TrailingZeros;
import org.junit.Test;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by jia on 17-4-8.
 */
public class No2TrailingZerosTest {

    @Test
    public void TestResultBasic(){
        long result26 = No2TrailingZeros.getResultBasic(26);
        long result36 = No2TrailingZeros.getResultBasic(36);

        System.out.print(result26 + ", "+ result36);
    }


    @Test
    public void TestResult2(){

        long result5555550000000 = No2TrailingZeros.getResult2(new BigInteger("5555550000000"));

        System.out.print(result5555550000000 + ", ");
    }

    @Test
    public void TestFactoring(){
        List<Long> result10 = No2TrailingZeros.factoring(10);
        for (long l : result10) {
            System.out.println("result 10: " + l);
        }
    }
}
