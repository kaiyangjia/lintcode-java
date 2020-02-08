package com.jiakaiyang.lintcode.java.lintcode;

import com.jiakaiyang.lintcode.java.lintcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.lintcode.com/problem/search-range-in-binary-search-tree/description
 * <p>
 * 11. 二叉查找树中搜索区间
 * <p>
 * 描述
 * 给定一个二叉查找树和范围[k1, k2]。按照升序返回给定范围内的节点值
 * <p>
 * 样例
 * 样例 1:
 * <p>
 * 输入：{5},6,10
 * 输出：[]
 * 5
 * 它将被序列化为 {5}
 * 没有数字介于6和10之间
 * 样例 2:
 * <p>
 * 输入：{20,8,22,4,12},10,22
 * 输出：[12,20,22]
 * 解释：
 * 20
 * /  \
 * 8   22
 * / \
 * 4   12
 * 它将被序列化为 {20,8,22,4,12}
 * [12,20,22]介于10和22之间
 * Created by jia on 8/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No11 {

    /**
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> result = new ArrayList();
        if (root == null) {
            return result;
        }

        int rootValue = root.val;

        if (root.left != null && rootValue >= k1) {
            int leftVal = root.left.val;
            result.addAll(searchRange(root.left, k1, k2));
        }

        if (rootValue <= k2 && rootValue >= k1) {
            result.add(rootValue);
        }

        if (root.right != null && rootValue <= k2) {
            int rightVal = root.right.val;
            result.addAll(searchRange(root.right, k1, k2));
        }

        return result;
    }
}
