package com.jiakaiyang.lintcode.java.lintcode;

import com.jiakaiyang.lintcode.java.lintcode.entity.TreeNode;

/**
 * 155. 二叉树的最小深度
 * https://www.lintcode.com/problem/minimum-depth-of-binary-tree/description
 * <p>
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 二叉树的最小深度为根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * Created by jia on 9/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No155MinDepthOfBinaryTree {

    /**
     * @param root: The root of binary tree
     * @return: An integer
     */
    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }

        // 两个子树都为空，说明到了叶子结点，深度为1
        if (root.left == null && root.right == null) {
            return 1;
        }

        // 有一个子树是空的，那么这个时候应该算另一个
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        // 两个子树都不为空，则按照两个子树中最小的算
        int leftMin = minDepth(root.left);
        int rightMin = minDepth(root.right);

        int result = leftMin < rightMin ? leftMin : rightMin;
        return result + 1;
    }
}
