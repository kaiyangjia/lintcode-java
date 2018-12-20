package com.jiakaiyang.lintcode.java.test;

import com.jiakaiyang.lintcode.java.lintcode.No8RotateString;
import org.junit.Test;

/**
 * Created by jia on 17-4-8.
 */
public class No8RotateStringTest {

    @Test
    public void TestResult(){
        char[] src = "abcdefg".toCharArray();
        No8RotateString.rotateString(src, 3);
        No8RotateString.rotateString(src, 4);
        No8RotateString.rotateString(src, 1);

    }
}
