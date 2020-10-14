package com.jiakaiyang.oj.java.lintcode;

import com.jiakaiyang.oj.java.lintcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1360. 对称树
 * https://www.lintcode.com/problem/symmetric-tree/description
 * <p>
 * 描述
 * 给定二叉树，返回它是否是自身的镜像（即这棵二叉树是否对称）。
 * Created by jia on 6/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No1360SymmetricTree {

    /**
     * 思路是：
     * 1. 如果root 没有叶子结点，那么它是对称的
     * 2. 对左子树进行层序遍历（并且层序遍历是包含有叶子结点的下一层的null的），把结果存储在一个 List<Integer> 里面
     * 3. 对右子树进行反向层序遍历，把结果存储在一个 List<Integer> 里面；
     * 4. 对左右子树的遍历结果进行比较，两个List<Integer>中的数值完全一致则说明是对称的
     *
     * @param root: root of the given tree
     * @return: whether it is a mirror of itself
     */
    public boolean isSymmetric(TreeNode root) {
        // Write your code here
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left == null || root.right == null) {
            return false;
        }

        // 左子树以前序遍历
        // 右子树以根、右、左的顺序遍历
        List<Integer> listL = levelTraversal(root.left, true);
        List<Integer> listR = levelTraversal(root.right, false);
        if (listL.size() != listR.size()) {
            return false;
        }

        for (Integer i : listL) {
            String istr = i == null ? "#" : i + "";
            System.out.println("listL: " + istr);
        }

        for (Integer i : listR) {
            String istr = i == null ? "#" : i + "";
            System.out.println("listR: " + istr);
        }

        int size = listL.size();
        for (int i = 0; i < size; i++) {
            Integer l = listL.get(i);
            Integer r = listR.get(i);

            if (l == null && r == null) {
                continue;
            }

            if (l == null || r == null) {
                return false;
            }

            if (!l.equals(r)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 层序遍历
     * 在层序遍历的时候，也会把空的叶子节点添加进去，空的叶子结点会当作null处理
     * 而不仅仅是到非空的节点；
     *
     * @param leftFirst true 表示正向层序遍历，false表示从右向左反向层序遍历
     */
    private List<Integer> levelTraversal(TreeNode a, boolean leftFirst) {
        List<Integer> result = new ArrayList();
        if (a == null) {
            result.add(null);
            return result;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(a);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                TreeNode node = queue.poll();
                if (node != null) {
                    result.add(node.val);
                    if (leftFirst) {
                        queue.offer(node.left);
                        queue.offer(node.right);
                    } else {
                        queue.offer(node.right);
                        queue.offer(node.left);
                    }
                } else {
                    result.add(null);
                }

                size--;
            }
        }

        return result;
    }
}
