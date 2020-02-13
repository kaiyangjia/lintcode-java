package com.jiakaiyang.lintcode.java.test;

import com.jiakaiyang.lintcode.java.lintcode.No1222ValidIPAddress;
import org.junit.Test;

/**
 * Created by jia on 12/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No1222ValidIPAddressTest {

    @Test
    public void validIPAddressTest() {
        int maxValue = 2 << 15;
        System.out.println("maxValue: " + maxValue);

        maxValue = 2 << 16;
        System.out.println("maxValue: " + maxValue);

        maxValue = 2 ^ 16;
        System.out.println("maxValue: " + maxValue);

        No1222ValidIPAddress solution = new No1222ValidIPAddress();

        String result = solution.validIPAddress("172.16.254.1");
        System.out.println("result: " + result);

        // 合法的
        result = solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334");
        System.out.println("result: " + result);

        result = solution.validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334");
        System.out.println("result: " + result);

        result = solution.validIPAddress("2001:0db8:085a3:0000:0000:8a2e:0370:7334");
        System.out.println("result: " + result);
    }
}
