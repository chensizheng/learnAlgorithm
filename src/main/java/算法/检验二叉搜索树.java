package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/28
 */

public class 检验二叉搜索树 {
    /***
     * 问题
     * 这个题目说的是，给你一棵二叉树，你要判断它是不是一棵二叉搜索树。
     *
     * 二叉搜索树的定义是：
     *
     *   1. 左子树所有节点上的值都小于根节点上的值
     *   2. 右子树所有节点上的值都大于根节点上的值
     *   3. 左右子树同时也为二叉搜索树
     *
     * 比如说，给你的二叉树是：
     *
     *     4
     *    / \
     *   2   6
     *
     * 左子树只有一个节点 2，小于 4；右子树也只有一个节点 6，大于 4。因此这是一棵二叉搜索树。
     *
     * 再比如说，给你的二叉树是：
     *
     *     4
     *    / \
     *   2   6
     *      / \
     *     3   8
     *
     * 右子树存在一个节点 3，它不大于根节点 4。因此这不是一棵二叉搜索树。
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode min(TreeNode root) {
        while (root.left != null) root = root.left;
        return root;
    }

    TreeNode max(TreeNode root) {
        while (root.right != null) root = root.right;
        return root;
    }


    // Time: O(n*log(n)), Space: O(n)
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean leftValid = root.left == null || root.val > max(root.left).val;
        boolean rightValid = root.right == null || root.val < min(root.right).val;
        return leftValid && rightValid && isValidBST(root.left) && isValidBST(root.right);
    }

    // Time: O(n), Space: O(n)
    public boolean isValidBSTBound(TreeNode root) {
        return isValidBSTBound(root, null, null);
    }
     //定义上下界。lower<当前节点<upper   左节点<当前节点<右节点
    boolean isValidBSTBound(TreeNode root, TreeNode lower, TreeNode upper) {
        if (root == null) return true;
        if (lower != null && lower.val >= root.val) return false;
        if (upper != null && upper.val <= root.val) return false;
        return isValidBSTBound(root.left, lower, root) && isValidBSTBound(root.right, root, upper);
    }
}