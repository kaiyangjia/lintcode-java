package com.jiakaiyang.oj.java.lintcode;

import com.jiakaiyang.oj.java.lintcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. 二叉树的后序遍历
 * https://www.lintcode.com/problem/binary-tree-postorder-traversal/description
 * <p>
 * Created by jia on 5/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No68BinaryTreePostorderTraversal {
    /**
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList();
        if (root == null) {
            return result;
        }

        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);

        return result;
    }
}
