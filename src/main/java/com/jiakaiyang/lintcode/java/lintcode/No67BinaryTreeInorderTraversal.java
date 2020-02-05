package com.jiakaiyang.lintcode.java.lintcode;

import com.jiakaiyang.lintcode.java.lintcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 67. 二叉树的中序遍历
 * https://www.lintcode.com/problem/binary-tree-inorder-traversal/description
 * <p>
 * Created by jia on 5/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No67BinaryTreeInorderTraversal {
    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList();

        if (root == null) {
            return result;
        }

        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));

        return result;
    }
}
