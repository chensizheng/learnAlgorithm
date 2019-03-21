package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2018/12/29
 */

public class 二叉树翻转 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //遍历翻转
    public TreeNode invertBinaryTreeRecursive(TreeNode root) {
        if (root == null) return root;
        TreeNode tmp = root.left;
        root.left =root.right;
        root.right = tmp;
        invertBinaryTreeRecursive(root.left);
        invertBinaryTreeRecursive(root.right);
        return root;
    }

    //迭代翻转
    // Time: O(n), Space: O(n)
    public  TreeNode invertBinaryTreeIterative(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
        return root;
    }
}