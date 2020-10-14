package com.jiakaiyang.oj.java.lintcode;

import com.jiakaiyang.oj.java.lintcode.entity.TreeNode;

/**
 * 1593. 根据前序和后序遍历构造二叉树
 * https://www.lintcode.com/problem/construct-binary-tree-from-preorder-and-postorder-traversal/description
 * <p>
 * 描述
 * 返回与给定的前序和后序遍历匹配的任何二叉树。
 * pre 和 post 遍历中的值是不同的正整数。
 * <p>
 * - 1 <= pre.length == post.length <= 30
 * - pre[]和 post[] 都是 1, 2, ..., pre.length 的排列
 * - 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。
 * <p>
 * Created by jia on 11/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No1593 {

    /**
     * 分析前序遍历和后序遍历的特点：
     * 1. 前序的第一个元素和后序的最后一个元素相等，都是树的根
     * 2. 前序的第二个元素是左子树或者右子树的根，取决于这个元素在后序遍历中的位置，如果在后序的位置是 n-2 的话，则是右子树，否则是左子树；
     * 3. 找到左右子树的部分数组后，可以针对左右数组递归操作，直到找到叶子结点；
     *
     * @param pre  前序遍历的结果
     * @param post 后序遍历的结果
     * @return
     */
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        // write your code here
        if (pre == null || post == null) {
            return null;
        }
        if (pre.length != post.length) {
            // 参数错误
            return null;
        }
        int length = pre.length;

        if (length == 0) {
            // 空树
            return null;
        }
        return constructFromPrePost(pre, 0, length - 1, post, 0, length - 1);
    }

    /**
     * 创建，是一个递归调用的方法
     *
     * @param pre       前序遍历的数组
     * @param preStart  前序数据在前序数组中的起始下标
     * @param preEnd    前序数据在前序数组中的结束下标
     * @param post      后序遍历的数组
     * @param postStart 后序数据在后序数组中的起始下标
     * @param postEnd   后序数据在后序数组中的结束下标
     * @return
     */
    private TreeNode constructFromPrePost(int[] pre, int preStart, int preEnd
            , int[] post, int postStart, int postEnd) {
        int length = (preEnd - preStart) + 1;
        int lengthPost = (postEnd - postStart) + 1;

        if (length != lengthPost) {
            // 两个长度必须相等，如果不相等，说明出现了问题，下面输出日志供排查
            System.out.println("-----start constructFromPrePost");
            System.out.println("preStart: " + preStart + ", preEnd: " + preEnd + ", postStart: " + postStart + ", postEnd:" + postEnd);


            System.out.println("length: " + length + ", lengthPost: " + lengthPost);
            printArray("pre", pre, preStart, preEnd);
            printArray("post", post, postStart, postEnd);
        }

        if (length < 0) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preStart]);
        if (length == 1) {
            return root;
        }

        // 后面的数据能保证列表长度是大于1 的
        TreeNode leftChild = null, rightChild = null;
        int childRootVal = pre[preStart + 1];

        // 从post 数组中找到对应的 childRootVal 的位置
        int targetIndex = -1;
        for (int i = postEnd; i >= postStart; i--) {
            int val = post[i];
            if (val == childRootVal) {
                targetIndex = i;
                break;
            }
        }

        System.out.println("targetIndex: " + targetIndex + ", childRootVal: " + childRootVal);
        if (targetIndex < 0) {
            // 数据有误，没有找到子树的根在 post 的位置
            return null;
        }

        // 说明只有一个子树，另一个子树为空的
        // 我们固定认为它是右子
        if (targetIndex == postEnd - 1) {
            rightChild = constructFromPrePost(pre, preStart + 1, preEnd, post, postStart, postEnd - 1);
            root.right = rightChild;
        } else {
            // 左右子树都不为空
            // post 中[postStart, targetIndex] 为左子树的数据，[targetIndex+1, postEnd-1] 为右子树
            // pre 中[preStart+1, rightPreIndex-1] 为左子树的数据，[rightPreIndex, preEnd] 的为右子树的数据

            int rightRootVal = post[postEnd - 1];
            // 找到pre数组查找右子树的位置
            int rightPreIndex = -1;
            for (int i = preStart; i <= preEnd; i++) {
                int val = pre[i];
                if (val == rightRootVal) {
                    rightPreIndex = i;
                    break;
                }
            }

            if (rightPreIndex < 0) {
                return null;
            }

            leftChild = constructFromPrePost(pre, preStart + 1, rightPreIndex - 1
                    , post, postStart, targetIndex);
            rightChild = constructFromPrePost(pre, rightPreIndex, preEnd
                    , post, targetIndex + 1, postEnd - 1);

            root.left = leftChild;
            root.right = rightChild;
        }

        return root;
    }

    public static void printArray(String name, int[] array, int start, int end) {
        if (array == null) {
            System.out.println(name + " array is null");
            return;
        }

        if (start < 0) {
            System.out.println("start : " + start + " is illegal");
            return;
        }

        if (end >= array.length) {
            System.out.println("end : " + end + " is illegal, length is  " + array.length);
            return;
        }
        System.out.println("》》》》 begin of array: " + name);
        for (int i = start; i <= end; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println("");
        System.out.println("《《《《 end of array: " + name);
    }
}
