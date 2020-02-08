package com.jiakaiyang.lintcode.java.lintcode;

import com.jiakaiyang.lintcode.java.lintcode.entity.TreeNode;

/**
 * https://www.lintcode.com/problem/invert-binary-tree/description
 * 175. 翻转二叉树
 * <p>
 * 描述
 * 翻转一棵二叉树。左右子树交换。
 * Created by jia on 8/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No175InvertBinaryTree {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        if (root.left != null) {
            invertBinaryTree(root.left);
        }

        if (root.right != null) {
            invertBinaryTree(root.right);
        }
    }
}
