package com.jiakaiyang.lintcode.java.test;

import com.jiakaiyang.lintcode.java.lintcode.No49SortLettersByCase;
import org.junit.Test;

public class No49SortLettersByCaseTest {

    @Test
    public void MySolution_sortLetters() {
        char[] chars = {'a', 'b', 'A', 'c', 'D'};
        No49SortLettersByCase.MySolution.sortLetters(chars);
        System.out.println(chars);


        chars = new char[]{'a', 'b', 'c'};
        No49SortLettersByCase.MySolution.sortLetters(chars);
        System.out.println(chars);

        chars = new char[]{'A', 'C', 'F'};
        No49SortLettersByCase.MySolution.sortLetters(chars);
        System.out.println(chars);

    }
}
