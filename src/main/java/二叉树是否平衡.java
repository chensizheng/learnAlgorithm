/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2018/12/29
 */

public class 二叉树是否平衡 {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }

    public int getHeight(TreeNode root){
        if (root == null ) return 0;
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }

    // Time: O(nlog(n)), Space: O(n)
    public boolean isBalanceTreeTopDown(TreeNode root){
        if (root == null ) return true;
        //左右子树的高度差<=1 且左右子树都是平衡二叉树
        return Math.abs(getHeight(root.left)-getHeight(root.right))<=1
                && isBalanceTreeTopDown(root.left)
                && isBalanceTreeTopDown(root.right);
    }

    // Time: O(n), Space: O(n)
    public boolean isBalancedTreeBottomUp(TreeNode root) {
        return getHeightAndCheck(root) != -1;
    }

    //获取高度的同时检查是否是平衡二叉树(非负数是高度，-1不平衡)
    public int getHeightAndCheck(TreeNode root){
        if (root == null) return 0;

        int left = getHeightAndCheck(root.left);
        if (left == -1) return -1;

        int right = getHeightAndCheck(root.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

}