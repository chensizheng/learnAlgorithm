package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/30
 */

public class 旋转数组 {
    /***
     * 问题
     * 这个题目说的是，给你一个数组和一个数字 k，你要把数组右边的数字旋转到数组左边，一次旋转一个数字，共旋转 k 次。
     *
     * 比如说，给你的数组是：
     *
     * 0, 1, 2, 4, 8
     *
     * 给你的数字 k 是 3：
     *
     * k = 3
     *
     * 把数组右边的数字一个个旋转到左边，操作 3 次。先是 8，然后 4，最后是 2。剩下的 0 和 1 保持不动。最后得到旋转后的数组是：
     *
     * 2, 4, 8, 0, 1
     */

    // Time: O(n), Space: O(n)
    public void rotateByCopy(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return;
        int n = nums.length, m = k % n, i = 0;
        int[] t = new int[n];
        for (int j = n-m; j < n; ++j) t[i++] = nums[j];
        for (int j = 0; j < n-m; ++j) t[i++] = nums[j];
        for (int j = 0; j < n; ++j) nums[j] = t[j];
    }


    // Time: O(n), Space: O(1)
    public void rotateBySwap(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return;
        int n = nums.length, m = k % n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, m-1);
        reverse(nums, m, n-1);
    }
    private void reverse(int[] nums, int i, int j) {
        for (; i < j; ++i, --j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }




}