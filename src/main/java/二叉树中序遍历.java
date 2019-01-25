/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/24
 */

public class 二叉树中序遍历 {
    /***
     * 问题
     * 这个题目说的是，给你一个二叉树，你要返回一个数组，表示二叉树中序遍历的结果。
     *
     * 比如说，给你的二叉树是：
     *
     *      1
     *    /   \
     *   2     3
     *    \
     *     4
     *    /
     *   5
     *
     * 你要返回的中序遍历结果是：2, 5, 4, 1, 3
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Time: O(n). Space: O(n)
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> left = inorderTraversalRecursive(root.left);
        List<Integer> right = inorderTraversalRecursive(root.right);
        left.add(root.val);
        left.addAll(right);
        return left;
    }

    // Time: O(n). Space: O(n)
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> result = new ArrayList<>();

        while (root != null || !s.empty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            result.add(root.val);
            root = root.right;
        }

        return result;
    }

}