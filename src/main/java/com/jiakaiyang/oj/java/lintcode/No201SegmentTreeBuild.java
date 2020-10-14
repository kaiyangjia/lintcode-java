package com.jiakaiyang.oj.java.lintcode;

import com.jiakaiyang.oj.java.lintcode.entity.SegmentTreeNode;

/**
 * 201. 线段树的构造
 * <p>
 * 描述
 * <p>
 * 线段树是一棵二叉树，他的每个节点包含了两个额外的属性start和end用于表示该节点所代表的区间。start和end都是整数，并按照如下的方式赋值:
 * <p>
 * 根节点的 start 和 end 由 build 方法所给出。
 * 对于节点 A 的左儿子，有 start=A.start, end=(A.start + A.end) / 2。
 * 对于节点 A 的右儿子，有 start=(A.start + A.end) / 2 + 1, end=A.end。
 * 如果 start 等于 end, 那么该节点是叶子节点，不再有左右儿子。
 * 实现一个 build 方法，接受 start 和 end 作为参数, 然后构造一个代表区间 [start, end] 的线段树，返回这棵线段树的根。
 * <p>
 * https://www.lintcode.com/problem/segment-tree-build/description
 * Created by jia on 5/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No201SegmentTreeBuild {

    /*
     * @param start: start value.
     * @param end: end value.
     * @return: The root of Segment Tree.
     */
    public SegmentTreeNode build(int start, int end) {
        // write your code here
        if (start > end) {
            return null;
        }

        if (start == end) {
            SegmentTreeNode node = new SegmentTreeNode(start, end);
            return node;
        }

        SegmentTreeNode root = new SegmentTreeNode(start, end);
        root.left = build(start, (start + end) / 2);
        root.right = build((start + end) / 2 + 1, end);

        return root;
    }
}
