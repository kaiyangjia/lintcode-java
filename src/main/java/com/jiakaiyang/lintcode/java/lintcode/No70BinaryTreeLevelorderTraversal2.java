package com.jiakaiyang.lintcode.java.lintcode;

import com.jiakaiyang.lintcode.java.lintcode.entity.TreeNode;

import java.util.*;

/**
 * https://www.lintcode.com/problem/binary-tree-level-order-traversal-ii/description
 * 70. 二叉树的层次遍历 II
 * <p>
 * 描述
 * 给出一棵二叉树，返回其节点值从底向上的层次序遍历（按从叶节点所在层到根节点所在的层遍历，然后逐层从左往右遍历）
 * <p>
 * Created by jia on 8/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No70BinaryTreeLevelorderTraversal2 {
    /**
     * 普通的层级遍历，然后把结果的顺序倒转即可
     *
     * @param root: A tree
     * @return: buttom-up level order a list of lists of integer
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> tmp = new ArrayList<>();
            // 循环遍历当前层的数据，queue 的前面size 个即是当前层的数据
            while (size > 0) {
                // 这里不会为null，在向队列中添加是能够保证
                TreeNode treeNode = queue.poll();
                tmp.add(treeNode.val);

                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }

                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }

                size--;
            }
            result.add(tmp);
        }

        Collections.reverse(result);
        return result;
    }
}
