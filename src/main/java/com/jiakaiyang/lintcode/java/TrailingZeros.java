package com.jiakaiyang.lintcode.java;

/**
 * Created by jia on 17-4-8.
 * 2. 尾部的零
 */
public class TrailingZeros {

    public static long getResult(long n){
        if (n <= 0) {
            return 0;
        }

        int count = 0;
        //因式分解，记录5的个数
        for (int j =2;j<=n;j++) {

            for (int i=2;i*i<=j;) {

                if (j % i == 0) {
                    j /= i;

                    if (i == 5) {
                        count ++;
                    }
                }else{
                    i++;
                }
            }
        }

        return count;
    }
}
