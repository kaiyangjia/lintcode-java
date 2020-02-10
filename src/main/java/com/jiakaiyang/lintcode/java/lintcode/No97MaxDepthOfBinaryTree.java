package com.jiakaiyang.lintcode.java.lintcode;

import com.jiakaiyang.lintcode.java.lintcode.entity.TreeNode;

/**
 * @see No155MinDepthOfBinaryTree
 * Created by jia on 9/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No97MaxDepthOfBinaryTree {

    /**
     * 使用递归，当前树的最大深度，等于左右子树的最大深度+1
     *
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxDepth(TreeNode root) {
        // write your code here

        if (root == null) {
            return 0;
        }

        // 1. 左右子树都为空
        if (root.left == null && root.right == null) {
            return 1;
        }

        // 2. 有一个子树为空
        if (root.left == null) {
            return maxDepth(root.right) + 1;
        }

        if (root.right == null) {
            return maxDepth(root.left) + 1;
        }

        // 3. 两个子树否不为空
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        int result = maxLeft > maxRight ? maxLeft : maxRight;
        return result + 1;
    }
}
