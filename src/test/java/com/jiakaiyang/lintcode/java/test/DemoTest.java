package com.jiakaiyang.lintcode.java.test;

import org.junit.Test;

import java.util.HashMap;

/**
 * Created by jia on 30/3/2020
 * github: https://github.com/kaiyangjia
 */
public class DemoTest {

    @Test
    public void demo() {
        HashMap<Integer, String> map = new HashMap<Integer, String>() {
            @Override
            public String get(Object key) {
                return super.get(key);
            }
        };
        int i = 1;
        map.put(i, "one");
        String aa = map.get(1);
        byte b = 1;
        String bb = map.get(b);

        Byte bWrapper = b;
        Integer iWrapper = i;

        int hashCodeB = hash(b);
        int hashCodeI = hash(i);

        if (hashCodeB == hashCodeI) {
            System.out.println(hashCodeB + ", " + hashCodeI);
        }

        if (bb == null) {

        }
    }

    @Test
    public void test() {
        float f = 3.14f;
        double d = f;
        System.out.println(f);
        System.out.println(d);

    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static class MyHashMap<T> extends HashMap {

        @Override
        public Object get(Object key) {
            return super.get(key);
        }
    }
}
