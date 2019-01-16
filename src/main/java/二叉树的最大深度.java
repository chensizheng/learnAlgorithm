/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2018/12/29
 */

public class 二叉树的最大深度 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }

    //递归
    public int maxDepthRecursive(TreeNode root){
        if (root == null) return 0;
        return Math.max(maxDepthRecursive(root.left),maxDepthRecursive(root.right))+1;
    }


    //逐层遍历
    public int maxDepthIterative(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth =0;
        while (!q.isEmpty()){
            int size = q.size(); //当前层级的节点个数
            for (int i = 0; i < size; i++) {
                TreeNode s = q.poll();
                if(s.left != null) q.add(s.left);
                if(s.right!= null) q.add(s.right);
            }
            ++depth;
        }
        return depth;
    }
}