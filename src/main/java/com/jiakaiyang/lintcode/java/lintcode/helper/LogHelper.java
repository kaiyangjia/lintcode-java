package com.jiakaiyang.lintcode.java.lintcode.helper;

/**
 * Created by jia on 11/2/2020
 * github: https://github.com/kaiyangjia
 */
public class LogHelper {

    public static void printArray(String name, int[] array, int start, int end) {
        if (array == null) {
            System.out.println(name + " array is null");
            return;
        }

        if (start < 0) {
            System.out.println("start : " + start + " is illegal");
            return;
        }

        if (end >= array.length) {
            System.out.println("end : " + end + " is illegal, length is  " + array.length);
            return;
        }
        System.out.println("》》》》 begin of array: " + name);
        for (int i = start; i <= end; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println("");
        System.out.println("《《《《 end of array: " + name);
    }
}
