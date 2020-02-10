package com.jiakaiyang.lintcode.java.lintcode;

import com.jiakaiyang.lintcode.java.lintcode.entity.ListNode;
import com.jiakaiyang.lintcode.java.lintcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.lintcode.com/problem/convert-binary-tree-to-linked-lists-by-depth/description
 * <p>
 * 242. 将二叉树按照层级转化为链表
 * <p>
 * 描述
 * 给一棵二叉树，设计一个算法为每一层的节点建立一个链表。也就是说，如果一棵二叉树有 D 层，那么你需要创建 D 条链表。
 * <p>
 * 输入: {1,2,3,4}
 * 输出: [1->null,2->3->null,4->null]
 * 解释:
 * 1
 * / \
 * 2   3
 * /
 * 4
 * Created by jia on 10/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No242 {
    /**
     * 按照层序遍历的思路，在每一层添加数据的时候，按照链表的形式添加即可
     *
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        List<ListNode> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 当前层的数量
            int levelCount = queue.size();

            // 当前层的头结点
            ListNode levelHead = null;
            // 用于遍历存储当前的结点
            ListNode levelNode = null;
            // 获取当前层的结点
            while (levelCount > 0) {
                TreeNode node = queue.poll();

                // 1. 把当前层的数据添加到结果集合中
                ListNode nextNode = new ListNode(node.val);
                if (levelNode == null) {
                    // 首个结点
                    levelNode = nextNode;
                    levelHead = nextNode;
                } else {
                    levelNode.next = nextNode;
                }
                levelNode = nextNode;

                // 2. 添加下一层数据到queue中，按照左右的顺序添加
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                levelCount--;
            }
            result.add(levelHead);
        }

        return result;
    }
}
