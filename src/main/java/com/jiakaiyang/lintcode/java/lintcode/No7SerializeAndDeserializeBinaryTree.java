package com.jiakaiyang.lintcode.java.lintcode;

/**
 * 7. 二叉树的序列化和反序列化
 * 描述
 * 设计一个算法，并编写代码来序列化和反序列化二叉树。将树写入一个文件被称为“序列化”，读取文件后重建同样的二叉树被称为“反序列化”。
 * <p>
 * 如何反序列化或序列化二叉树是没有限制的，你只需要确保可以将二叉树序列化为一个字符串，并且可以将字符串反序列化为原来的树结构。
 * <p>
 * https://www.lintcode.com/problem/serialize-and-deserialize-binary-tree/description
 * <p>
 * Created by jia on 18/1/2020
 * github: https://github.com/kaiyangjia
 */
public class No7SerializeAndDeserializeBinaryTree {

    /**
     * 思路：
     * 使用一个数组存放二叉树的数据，其中为空的地方都不设置数据
     * 一个完全二叉树，它在数组中很好存储，数组的下标以1开头，其中空结点存放为 "#"：
     * - 在位置a 的地方的结点，它的左右结点的下标分别是 2a 和 2a+1
     * - 对于任何下标的一个地方b，它的父结点是下标为  b/2 的地方
     *
     * 在把树存放在数组中后，再通过序列化数组来实现
     */

    /**
     * 算法步骤：
     * 序列化：
     * 1. 计算出二叉树的深度deep，然后根据深度得到数组的长度为 2^deep - 1
     * 2. 按照根、左、右的顺序遍历树，把树存放在数组中。存放的位置是按照【根、左、右】---【a、2a、2a+1】 的位置关系
     * 3. 对于不为空的结点，存放值的字符串，对于为空的结点，则存放为 "#"
     * 4. 每一个结点值之间以逗号分割
     *
     * 反序列化：
     * 1. 如果传入的数据为空或者空串或者"#"，那么返回一个空树；
     * 2. 以逗号分割字符串，得到一个字符串数组；
     * 3. 从第一个位置开始，根据 【根、左、右】---【a、2a、2a+1】 的关系来遍历数组，依次构建结点
     */

    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public static String serialize(TreeNode root) {
        // write your code here
        // 计算出层数，以此确定数组的长度
        int deep = getTreeDeep(root);
        int length = (int) Math.pow(2, deep) - 1;

        System.out.println("deep: " + deep + ", length: " + length);

        String[] result = new String[length];
        saveToArray(result, root, 1);

        for (String s : result) {
            System.out.println("after save to array: " + s);
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            String s = result[i];
            builder.append(s);
            if (i != length - 1) {
                builder.append(",");
            }
        }

        String data = builder.toString();
        return data;
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public static TreeNode deserialize(String data) {
        // write your code here
        System.out.println("deserialize: " + data);

        // 当为空树的时候，data 会是一个空的字符串
        if (data == null || data.isEmpty()) {
            return null;
        }

        if (data.equals("#")) {
            return null;
        }

        String[] array = data.split(",");
        System.out.println("deserialize: length: " + array.length);
        TreeNode node = readFrom(array, 1);
        return node;
    }


    /**
     * 把一个树存放在数组中，会在内部递归地存放它的子树
     *
     * @param array     需要被存放的数组，内部使用字符串来存储，是为了方便地序列化
     * @param root      树的根结点
     * @param rootIndex 根结点在数组中的下标
     */
    private static void saveToArray(String[] array, TreeNode root, int rootIndex) {
        boolean result = saveByIndex(array, root, rootIndex);
//        System.out.println("saveToArray: " + root + ", " + rootIndex + ", result: " + result);

        if (result && root != null) {
            int lChildIndex = 2 * rootIndex;
            int rChildIndex = 2 * rootIndex + 1;

            TreeNode left = root.left;
            TreeNode right = root.right;

//            System.out.println("saveToArray: left: " + left);
//            System.out.println("saveToArray: right: " + right);

            saveToArray(array, left, lChildIndex);
            saveToArray(array, right, rChildIndex);
        }
    }

    /**
     * 从数组中重建一个二叉树
     *
     * @param array     存放数据的数组
     * @param rootIndex 读取的下标
     * @return
     */
    private static TreeNode readFrom(String[] array, int rootIndex) {
        TreeNode root = readByIndex(array, rootIndex);
        if (root == null) {
            return null;
        }

        int lChildIndex = 2 * rootIndex;
        int rChildIndex = 2 * rootIndex + 1;

        root.left = readFrom(array, lChildIndex);
        root.right = readFrom(array, rChildIndex);

        return root;
    }

    /**
     * 按照逻辑index 保存到实际的数据中。逻辑的index是从1开始计算的，实际在数组中存放的数据
     * 是从0开始计算的，这个方法内部会做一个转换
     *
     * @param array      存放数据的数组
     * @param node       要被保存的结点
     * @param logicIndex 要被保存的数据的逻辑上的下标，是从1开始的计算的。
     * @return
     */
    private static boolean saveByIndex(String[] array, TreeNode node, int logicIndex) {
        int realIndex = logicIndex - 1;
        boolean outRange = realIndex < 0 || realIndex >= array.length;
//        System.out.println("saveByIndex: " + logicIndex + ", " + outRange + ", " + realIndex + ", " + array.length);

        if (outRange) {
            return false;
        }
        String data = node == null ? "#" : node.val + "";
        array[realIndex] = data;
        return true;
    }

    /**
     * 按照逻辑 index 来从数组中读取一个结点
     *
     * @param array      存放数据的数组
     * @param logicIndex 该结点的逻辑下标，是从1开始计算的
     * @return
     */
    private static TreeNode readByIndex(String[] array, int logicIndex) {
        System.out.println("readByIndex: " + logicIndex);
        int realIndex = logicIndex - 1;
        if (realIndex < 0 || realIndex >= array.length) {
            return null;
        }
        String data = array[realIndex];
        if ("#".equals(data)) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(data));
        return node;
    }

    /**
     * 遍历获取树的深度
     *
     * @param root
     * @return
     */
    private static int getTreeDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null) {
            return getTreeDeep(root.right) + 1;
        }

        if (root.right == null) {
            return getTreeDeep(root.left) + 1;
        }

        return Math.max(getTreeDeep(root.left), getTreeDeep(root.right)) + 1;
    }

    /**
     * Definition of TreeNode:
     * public class TreeNode {
     * public int val;
     * public TreeNode left, right;
     * public TreeNode(int val) {
     * this.val = val;
     * this.left = this.right = null;
     * }
     * }
     */
    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}
