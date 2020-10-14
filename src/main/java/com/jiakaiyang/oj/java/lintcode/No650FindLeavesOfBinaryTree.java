package com.jiakaiyang.oj.java.lintcode;

import com.jiakaiyang.oj.java.lintcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 650. 二叉树叶子顺序遍历
 * https://www.lintcode.com/problem/find-leaves-of-binary-tree/description
 * <p>
 * 给定一个二叉树，像这样收集树节点：收集并移除所有叶子，重复，直到树为空。
 * <p>
 * 样例1
 * 输入： {1,2,3,4,5}
 * 输出： [[4, 5, 3], [2], [1]].
 * Created by jia on 9/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No650FindLeavesOfBinaryTree {

    /*
     * @param root: the root of binary tree
     * @return: collect and remove all leaves
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        // 循环调用多次，每次修剪最后的一层叶子
        while (root.left != null || root.right != null) {
            List<Integer> level = trimLeaves(root);
            if (level != null) {
                result.add(level);
            }
        }

        List<Integer> firstLevel = new ArrayList();
        firstLevel.add(root.val);

        result.add(firstLevel);
        return result;
    }

    /**
     * 获取一层叶子，是一个遍历的调用，如果当前的不是叶子则会遍历到下一层
     */
    private List<Integer> trimLeaves(TreeNode root) {
        List<Integer> result = new LinkedList();
        if (root == null) {
            return null;
        }

        // 叶子结点，则直接添加
        if (isLeaf(root)) {
            result.add(root.val);
            return result;
        }

        // 左子树不为null
        if (root.left != null) {
            TreeNode node = root.left;

            if (isLeaf(node)) {
                // 左子结点是一个叶子，那么修剪掉它
                root.left = null;
            }

            // 遍历检查下一层
            result.addAll(trimLeaves(node));
        }

        if (root.right != null) {
            TreeNode node = root.right;
            if (isLeaf(node)) {
                // 右子结点是一个叶子，那么修剪掉它
                root.right = null;
            }
            result.addAll(trimLeaves(node));
        }

        return result;
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }

        return node.left == null && node.right == null;
    }
}
