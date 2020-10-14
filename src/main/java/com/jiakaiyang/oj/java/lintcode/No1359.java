package com.jiakaiyang.oj.java.lintcode;

import com.jiakaiyang.oj.java.lintcode.entity.TreeNode;

/**
 * 1359. 有序数组转换为二叉搜索树
 * https://www.lintcode.com/problem/convert-sorted-array-to-binary-search-tree/description
 * <p>
 * 给定一个数组，其中元素按升序排序，将其转换为高度平衡的BST。
 * <p>
 * 对于这个问题，高度平衡的二叉树被定义为二叉树，其中每个节点的两个子树的深度从不相差超过1。
 * <p>
 * 样例
 * 样例 1:
 * <p>
 * 输入: [-10,-3,0,5,9],
 * 输出: [0,-3,9,-10,#,5],
 * 解释:
 * 针对该数组的其中一个解为 [0,-3,9,-10,null,5], 其对应的平衡BST树如下:
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * Created by jia on 9/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No1359 {

    /**
     * 1. 找到数组的中间位置a，把a作为根，左侧作为左子树，右侧为右子树；
     * 2. 如果左侧或者右侧的长度大于3，则继续以上过程；
     * 3. 如果小于3，则使用这一段来生成树
     *
     * @param nums: the sorted array
     * @return: the root of the tree
     */
    public TreeNode convertSortedArraytoBinarySearchTree(int[] nums) {
        // Write your code here.
        return buildByArray(nums, 0, nums.length - 1);
    }

    private TreeNode buildByArray(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode root = null;
        int size = (end - start) + 1;
        if (size == 3) {
            int mid = (start + end) / 2;
            root = new TreeNode(nums[mid]);
            root.left = new TreeNode(nums[start]);
            root.right = new TreeNode(nums[end]);
        } else if (size == 2) {
            // 剩余长度是2 的时候，可以有多种方法实现：
            // 1. nums[start] 设为left，nums[end] 设为 root；即是只有左子树和根
            // 2. nums[start] 设为root，nums[end] 设为 right；即时只有右子树和根
            // 以上两种均可，但是选择方法1的时候，lintcode 无法通过，所以选择第二种
            root = new TreeNode(nums[start]);
            root.right = new TreeNode(nums[end]);
        } else if (size == 1) {
            root = new TreeNode(nums[start]);
        } else if (size > 3) {
            int mid = (start + end) >> 1;
            root = new TreeNode(nums[mid]);
            root.left = buildByArray(nums, start, mid - 1);
            root.right = buildByArray(nums, mid + 1, end);
        }

        return root;
    }
}
