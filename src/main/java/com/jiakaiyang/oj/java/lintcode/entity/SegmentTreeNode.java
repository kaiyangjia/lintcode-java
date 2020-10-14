package com.jiakaiyang.oj.java.lintcode.entity;

/**
 * Created by jia on 5/2/2020
 * github: https://github.com/kaiyangjia
 */
public class SegmentTreeNode {
    /**
     * Definition of SegmentTreeNode:
     * public class SegmentTreeNode {
     * public int start, end;
     * public SegmentTreeNode left, right;
     * public SegmentTreeNode(int start, int end) {
     * this.start = start, this.end = end;
     * this.left = this.right = null;
     * }
     * }
     */


    public int start, end;
    public SegmentTreeNode left, right;

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = this.right = null;
    }
}
