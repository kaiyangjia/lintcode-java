package com.jiakaiyang.lintcode.java.lintcode;

import com.jiakaiyang.lintcode.java.lintcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 66. 二叉树的前序遍历
 * https://www.lintcode.com/problem/binary-tree-preorder-traversal/description
 * <p>
 * Created by jia on 5/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No66BinaryTreePreorderTraversal {
    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList();
        if (root == null) {
            return result;
        }

        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));

        return result;
    }
}
