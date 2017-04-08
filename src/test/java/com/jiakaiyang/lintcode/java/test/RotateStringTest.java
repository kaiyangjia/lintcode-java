package com.jiakaiyang.lintcode.java.test;

import com.jiakaiyang.lintcode.java.RotateString;
import org.junit.Test;

/**
 * Created by jia on 17-4-8.
 */
public class RotateStringTest {

    @Test
    public void TestResult(){
        char[] src = "abcdefg".toCharArray();
        RotateString.rotateString(src, 3);
        RotateString.rotateString(src, 4);
        RotateString.rotateString(src, 1);

    }
}
