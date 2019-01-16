/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2018/12/29
 */

public class 二叉树的最小深度 {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }

    public int minDepthRecursive(TreeNode root){
        if (null == root) return 0;
        if(root.left == null && root.right == null ) return 1;  //左右都为空，叶子节点
        if(root.left == null) return minDepthRecursive(root.right)+1;
        if(root.right == null) return minDepthRecursive(root.left)+1;
        return Math.min(minDepthRecursive(root.left),minDepthRecursive(root.right))+1;
    }

    //按层级遍历
    public int minDepthIterative(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 1;
        while (!q.isEmpty()){
            int size = q.size(); //当前层级中节点的数量
            for (int i = 0; i < size; i++) {
                TreeNode s = q.poll();
                if (s.left == null && s.right == null) return depth;
                if (s.left != null) q.add(s.left);
                if (s.right != null) q.add(s.right);
            }
            ++depth;
        }
        return -1;
    }

}