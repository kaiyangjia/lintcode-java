package com.jiakaiyang.oj.java.lintcode.test;

import com.jiakaiyang.oj.java.lintcode.No427GenerateParentheses;
import org.junit.Test;

import java.util.List;

/**
 * Created by jia on 17/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No427GenerateParenthesesTest {

    @Test
    public void solutionTest() {
        No427GenerateParentheses solution = new No427GenerateParentheses();

        List<String> result = solution.generateParenthesis(3);

        System.out.println("result: ");

        if (result != null) {
            for (String s : result) {
                System.out.println(s);
            }
        }
    }
}
