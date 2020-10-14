package com.jiakaiyang.oj.java.lintcode;

import com.jiakaiyang.oj.java.lintcode.entity.TreeNode;

/**
 * 701. 修剪二叉搜索树
 * https://www.lintcode.com/problem/trim-a-binary-search-tree/description
 * <p>
 * 给定一个有根的二分搜索树和两个数字min和max，修整这个树使得所有的数字在这个新的树种都是在min和max之间（包括min和max）。然后这个所得的树仍然是合法的二分搜索树。
 * Created by jia on 10/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No701TrimBST {

    /**
     * @param root:    given BST
     * @param minimum: the lower limit
     * @param maximum: the upper limit
     * @return: the root of the new tree
     */
    public TreeNode trimBST(TreeNode root, int minimum, int maximum) {
        // write your code here
        if (root == null) {
            return null;
        }

        // 1. 从子结点中找到一个新的合法的根结点
        while (root != null) {
            if (root.val <= maximum && root.val >= minimum) {
                break;
            }

            root = findIllegalRoot(root, minimum, maximum);
        }

        if (root == null) {
            return null;
        }

        // 2. 分别修剪左子树和右子树
        trim(root, root.left, minimum, maximum);
        trim(root, root.right, minimum, maximum);

        return root;
    }

    /**
     * 以root 为起始，找到它的子结点中的下一个合法的root，合法的root即范围在[minimum, maximum] 中的结点
     *
     * @param root
     * @param minimum
     * @param maximum
     * @return
     */
    private TreeNode findIllegalRoot(TreeNode root, int minimum, int maximum) {
        int rootVal = root.val;
        // 先找到一个在范围内的root
        if (rootVal > maximum) {
            while (root != null) {
                if (root.val <= maximum) {
                    break;
                }
                root = root.left;
            }
        } else if (rootVal < minimum) {
            while (root != null) {
                if (root.val >= minimum) {
                    break;
                }
                root = root.right;
            }
        }

        return root;
    }

    /**
     * 修剪操作，内部会对该结点 root 进行修剪操作，该方法是一个递归方法，内部会逐层对子树进行修剪
     *
     * @param parent
     * @param root
     * @param minimum
     * @param maximum
     */
    private void trim(TreeNode parent, TreeNode root, int minimum, int maximum) {
        if (root == null) {
            return;
        }
        int rootVal = root.val;

        // check当前的结点是否在范围内，不在的话则修剪树
        if (rootVal < minimum) {
            // 修剪根和左子树
            root = trimRootAndLeft(parent, root, minimum, maximum);
        }
        if (rootVal > maximum) {
            root = trimRootAndRight(parent, root, minimum, maximum);
        }


        // 遍历左右子树，递归调用该方法
        if (root != null && root.left != null) {
            trim(root, root.left, minimum, maximum);
        }

        if (root != null && root.right != null) {
            trim(root, root.right, minimum, maximum);
        }

    }

    /**
     * 修剪掉根和左子树
     */
    private TreeNode trimRootAndLeft(TreeNode parent, TreeNode root, int minimum, int maximum) {
        root.left = null;
        if (parent != null) {
            // 找到下一个合法的根，然后把新的合法的添加为parent 的left结点
            TreeNode newRoot = findIllegalRoot(root, minimum, maximum);
            parent.left = newRoot;
            return parent.left;
        }

        return root;
    }

    /**
     * 修剪掉右子树和根，会在左子树内部查找下一个合法结点作为新的根
     *
     * @param parent
     * @param root
     * @param minimum
     * @param maximum
     * @return
     */
    private TreeNode trimRootAndRight(TreeNode parent, TreeNode root, int minimum, int maximum) {
        root.right = null;
        if (parent != null) {
            TreeNode newRoot = findIllegalRoot(root, minimum, maximum);
            parent.right = newRoot;
            return parent.right;
        }

        return root;
    }
}
