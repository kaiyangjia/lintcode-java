package com.jiakaiyang.lintcode.java.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 427. 生成括号
 * https://www.lintcode.com/problem/generate-parentheses/description
 * <p>
 * 给定 n，表示有 n 对括号, 请写一个函数以将其生成所有的括号组合，并返回组合结果。
 * <p>
 * 样例
 * 样例 1:
 * <p>
 * 输入: 3
 * 输出: ["((()))", "(()())", "(())()", "()(())", "()()()"]
 * 样例 2:
 * <p>
 * 输入: 2
 * 输出: ["()()", "(())"]
 * <p>
 * <p>
 * Created by jia on 17/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No427GenerateParentheses {

    /**
     * @param n: n pairs
     * @return: All combinations of well-formed parentheses
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        findgenerateParenthesis(n, n, "", res, "root");
        return res;
    }

    /**
     * left和right分别表示左右括号的剩余个数
     * 决策树的每一个结点的属性包含：剩余的可用左括号数量left，剩余可用右括号数量right
     * 结点的递归条件，需要满足：left >= 0，左括号小于右括号的剩余数量
     */
    public void findgenerateParenthesis(int left, int right, String out, List<String> res, String from) {
        //left > right是")("的情况
        System.out.println("from: " + from + ", left: " + left + ", right: " + right + ", out: " + out);
        if (left < 0 || right < 0 || left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(out);
            return;
        }

        // 深度优先搜索，先把左括号的数量降低遍历
        if (left > 0) {
            findgenerateParenthesis(left - 1, right, out + "(", res, "left");//回溯
        }

        // 在左括号降低到0以后，再添加右括号
        if (left < right) {
            findgenerateParenthesis(left, right - 1, out + ")", res, "right");
        }
    }
}
