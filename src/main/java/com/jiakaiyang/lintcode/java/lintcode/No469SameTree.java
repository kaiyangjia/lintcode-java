package com.jiakaiyang.lintcode.java.lintcode;

import com.jiakaiyang.lintcode.java.lintcode.entity.TreeNode;

/**
 * 469. 等价二叉树
 * https://www.lintcode.com/problem/same-tree/description
 * <p>
 * 描述
 * <p>
 * 检查两棵二叉树是否等价。等价的意思是说，首先两棵二叉树必须拥有相同的结构，并且每个对应位置上的节点上的数都相等。
 * Created by jia on 5/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No469SameTree {
    /**
     * @param a: the root of binary tree a.
     * @param b: the root of binary tree b.
     * @return: true if they are identical, or false.
     */
    public boolean isIdentical(TreeNode a, TreeNode b) {
        // write your code here
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (a.val != b.val) {
            return false;
        }

        // 叶子结点，为递归的结束条件
        if (a.val == b.val && isLeaf(a) && isLeaf(b)) {
            return true;
        }

        // 非叶子结点查看子树
        return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
    }

    private boolean isLeaf(TreeNode a) {
        if (a == null) {
            return false;
        }

        return a.left == null && a.right == null;
    }
}
