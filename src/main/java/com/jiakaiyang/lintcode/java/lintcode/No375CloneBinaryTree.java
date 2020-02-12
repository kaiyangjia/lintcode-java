package com.jiakaiyang.lintcode.java.lintcode;

import com.jiakaiyang.lintcode.java.lintcode.entity.TreeNode;

/**
 * 375. 克隆二叉树
 * https://www.lintcode.com/problem/clone-binary-tree/description
 * 深度复制一个二叉树。
 * <p>
 * 给定一个二叉树，返回一个他的 克隆品 。
 * 你最好不要仅仅通过return root来通过此题。
 * Created by jia on 11/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No375CloneBinaryTree {
    /**
     * @param root: The root of binary tree
     * @return: root of new tree
     */
    public TreeNode cloneTree(TreeNode root) {
        // write your code here

        if (root == null) {
            return null;
        }

        TreeNode result = new TreeNode(root.val);
        if (root.left == null && root.right == null) {
            return result;
        }

        if (root.left != null) {
            result.left = cloneTree(root.left);
        }
        if (root.right != null) {
            result.right = cloneTree(root.right);
        }

        return result;
    }
}
