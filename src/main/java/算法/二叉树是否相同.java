package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

import java.util.Stack;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2018/12/28
 */

public class 二叉树是否相同 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }

    //递归判断
    public boolean isSameTreeRecursive(TreeNode p,TreeNode q) {
        if(p == null && q == null ) return true;
        if(p == null || q == null ) return false;
        return p.val == q.val && isSameTreeRecursive(p.left,p.left)
                && isSameTreeRecursive(p.right,p.right);
    }

    //迭代
    public boolean isSameTreeIterative(TreeNode p,TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);
        while (!stack.empty()){
            TreeNode s = stack.pop(),t = stack.pop();
            if(s == null && t == null ) continue;
            if(s == null || t == null ) return false;
            if(s.val != t.val ) return false;
            stack.push(s.left);
            stack.push(t.left);
            stack.push(s.right);
            stack.push(t.right);
        }
        return true;
    }
}