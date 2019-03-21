package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

import java.util.Stack;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2018/12/28
 */

public class 二叉树是否对称 {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }

    public boolean isSymmetric(TreeNode l,TreeNode r){
        if(l != null && r !=null )
            return l.val == r.val && isSymmetric(l.left,r.right) && isSymmetric(l.right,r.left);
        else return l == null && r == null;
    }

    //递归判断
    public boolean isSymmetricTreeRecursive(TreeNode root) {
        if(root ==null) return true;
        return isSymmetric(root.left,root.right);
    }

    public boolean isSymmetricTreeIterative(TreeNode root) {
        if(root ==null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.empty()){
            TreeNode s = stack.pop(), t = stack.pop();
            if(s == null && t == null) continue;
            if(s == null || t == null) return false;
            if(s.val != t.val) return false;
            stack.push(t.left);
            stack.push(s.right);
            stack.push(t.right);
            stack.push(s.left);
        }
        return true;
    }

}