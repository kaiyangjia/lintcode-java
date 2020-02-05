package com.jiakaiyang.lintcode.java.lintcode;

import com.jiakaiyang.lintcode.java.lintcode.entity.TreeNode;

import java.util.*;

/**
 * 71. 二叉树的锯齿形层次遍历
 * 描述
 * 给出一棵二叉树，返回其节点值的锯齿形层次遍历（先从左往右，下一层再从右往左，层与层之间交替进行）
 * https://www.lintcode.com/problem/binary-tree-zigzag-level-order-traversal/description
 * <p>
 * Created by jia on 5/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No71BinaryTreeZigzagLevelorderTraversal {
    /**
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList();

        // 添加第一层的数据
        queue.offer(root);
        int level = 1;

        while (!queue.isEmpty()) {
            int count = queue.size();

            List<Integer> tmpList = new ArrayList();
            int nextLevel = level + 1;

            // 遍历一层
            while (count > 0) {
                TreeNode node = queue.poll();
                tmpList.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
                count--;
            }

            // 偶数层添加的时候，把列表进行反转即可，奇数层的保持不变
            if (level % 2 == 0) {
                Collections.reverse(tmpList);
            }
            result.add(tmpList);

            // 每循环一次都是层次加1
            level++;
        }

        return result;
    }
}
