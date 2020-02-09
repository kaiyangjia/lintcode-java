package com.jiakaiyang.lintcode.java.lintcode;

import com.jiakaiyang.lintcode.java.lintcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.lintcode.com/problem/binary-search-tree-iterator/description
 * 86. 二叉查找树迭代器
 * 描述
 * 设计实现一个带有下列属性的二叉查找树的迭代器：
 * next()返回BST中下一个最小的元素
 * <p>
 * - 元素按照递增的顺序被访问（比如中序遍历）
 * - next()和hasNext()的询问操作要求均摊时间复杂度是O(1)
 * <p>
 * Created by jia on 9/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No86BinarySearchTreeIterator {

    public class BSTIterator {
        private List<TreeNode> list;
        private int nextIndex = -1;

        /**
         * 1. 在初始化迭代器的时候，根据树对象生成按照中序遍历的一个列表，这个列表中的顺序，就是按照数据大小排列的数据
         * 2. 记录当前迭代器的迭代位置，初始为0，每一次调用next() 都会使得当前位置向后移动一位
         * 3. hasNext() 的判断逻辑，就是 check 当前的迭代位置是否还是合法的
         *
         * @param root: The root of binary tree.
         */
        public BSTIterator(TreeNode root) {
            // do intialization if necessary
            // 使用ArrayList，使得获取的速度为O(1) 复杂度
            list = new ArrayList();
            list.addAll(inOrderTraversal(root));

            if (list.size() > 0) {
                nextIndex = 0;
            }
        }

        private List<TreeNode> inOrderTraversal(TreeNode root) {
            List<TreeNode> result = new ArrayList();
            if (root == null) {
                return result;
            }

            result.addAll(inOrderTraversal(root.left));
            result.add(root);
            result.addAll(inOrderTraversal(root.right));

            return result;
        }

        /*
         * @return: True if there has next node, or false
         */
        public boolean hasNext() {
            // write your code here
            return nextIndex >= 0;
        }

        /*
         * @return: return next node
         */
        public TreeNode next() {
            // write your code here
            if (nextIndex < 0 || nextIndex >= list.size()) {
                return null;
            }

            TreeNode result = list.get(nextIndex);
            nextIndex++;

            if (nextIndex >= list.size()) {
                nextIndex = -1;
            }
            return result;
        }
    }
}
