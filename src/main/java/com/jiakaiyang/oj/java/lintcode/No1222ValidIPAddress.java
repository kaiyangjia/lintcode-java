package com.jiakaiyang.oj.java.lintcode;

/**
 * 1222. 检验IP地址
 * https://www.lintcode.com/problem/validate-ip-address/description
 * <p>
 * 描述
 * 实现一个函数来检查输入字符串是一个合法的IPv4地址，还是一个合法的IPv6地址，抑或是两者都不是。
 * <p>
 * IPv4地址被规范地表示为点分十进制，包含四个取值为0到255的十进制数，其间使用点号(".")来进行分隔，例如，172.16.254.1；
 * <p>
 * 此外，前导零在IPv4地址中是非法的。例如，地址172.16.254.01就是非法的。
 * <p>
 * IPv6地址被表示为十六进制数位，每4个十六进制数位归为一组，共八组，每组可表示16个二进制位。每组之间使用冒号(":")来进行分隔。例如，地址2001:0db8:85a3:0000:0000:8a2e:0370:7334是合法的。同时，去掉每组十六进制数位中的一些前导零，或是将表示十六进制数位的小写字母写作大写字母，也都是合法的，所以2001:db8:85a3:0:0:8A2E:0370:7334同样是一个合法的IPv6地址（它忽略了前导零同时使用了大写字母）。
 * <p>
 * 然而，我们不能为了追求简洁就使用两个冒号("::")将连续的值为0的组替换为一个空组。例如，2001:0db8:85a3::8A2E:0370:7334就是一个非法的IPv6地址。
 * <p>
 * 此外，额外的前导零在IPv6中也是非法的。例如，地址02001:0db8:85a3:0000:0000:8a2e:0370:7334就是非法的。
 * <p>
 * 你可以假设输入字符串中没有多余的空格或其他特殊字符。
 * <p>
 * Created by jia on 12/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No1222ValidIPAddress {

    /**
     * @param IP: the given IP
     * @return: whether an input string is a valid IPv4 address or IPv6 address or neither
     */
    public String validIPAddress(String IP) {
        // Write your code here
        return solutionWithStringParse(IP);
    }

    /**
     * 使用字符串解析处理的结果
     *
     * @param IP
     * @return
     */
    private String solutionWithStringParse(String IP) {
        String v4 = "IPv4";
        String v6 = "IPv6";
        String neither = "Neither";

        if (IP == null) {
            return neither;
        }

        boolean isIPv4 = isIPv4(IP);
        if (isIPv4) {
            return v4;
        }

        boolean isIPv6 = isIPv6(IP);
        if (isIPv6) {
            return v6;
        }
        return neither;
    }

    private boolean isIPv4(String IP) {
        // . 是特殊的字符，需要加上转义
        String[] array = IP.split("\\.");
        if (array.length != 4) {
            return false;
        }

        // 长度等于4的有可能是 IPv4
        // check 下每一个是否都是合法的
        for (String segment : array) {
            int i = -1;
            try {
                i = Integer.valueOf(segment);
            } catch (NumberFormatException e) {
                // 有解析失败的肯定不是ip
                return false;
            }

            if (i < 0 || i > 255) {
                return false;
            }

            // ipv4 不允许前置0
            boolean startWithZero = segment.startsWith("0");
            if (startWithZero) {
                return false;
            }
        }

        return true;
    }

    private boolean isIPv6(String IP) {
        String[] array = IP.split(":");
        if (array.length != 8) {
            return false;
        }

        // IPv6 的每个段最大值是 2^16 - 1
        int maxValue = (2 << 15) - 1;
        for (String segment : array) {
            // 空串是非法的
            if (segment.isEmpty()) {
                return false;
            }

            // 长度大于4是非法的
            if (segment.length() > 4) {
                return false;
            }

            int i = -1;
            try {
                i = Integer.valueOf(segment, 16);
            } catch (NumberFormatException e) {
                return false;
            }

            if (i < 0 || i > maxValue) {
                return false;
            }
        }

        return true;
    }
}
