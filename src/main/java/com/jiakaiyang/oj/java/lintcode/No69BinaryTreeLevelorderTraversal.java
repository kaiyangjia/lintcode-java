package com.jiakaiyang.oj.java.lintcode;

import com.jiakaiyang.oj.java.lintcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 69. 二叉树的层次遍历
 * https://www.lintcode.com/problem/binary-tree-level-order-traversal/description
 * <p>
 * Created by jia on 5/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No69BinaryTreeLevelorderTraversal {
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList();

        // 添加root，也就是第一层的数据到队列中
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmpList = new LinkedList();

            // 循环遍历一层的数据
            while (size > 0) {
                // 把当前层的数据添加到结果数据中
                TreeNode node = queue.poll();
                tmpList.add(node.val);

                // 添加下一层的数据
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                size--;
            }

            result.add(tmpList);
        }

        return result;
    }
}
