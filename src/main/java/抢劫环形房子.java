/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/29
 */

public class 抢劫环形房子 {
    /***
     * 问题
     * 这个题目说的是，有一个强盗要去抢一排两两相邻，并且首尾相接的环形房子，每个房子里放着正整数金额的钱，可以用一个整数数组来表示。这个强盗唯一的限制就是不能同时抢相邻的两个房子，那么请问，这个强盗最多可以抢到多少钱。
     *
     * 比如说，这排房子里放着的钱是整数数组 nums：
     *
     * 8, 1, 2, 9
     *
     * 这 4 个房子实际上围成了一个圆圈，也就是说 8 和 9 是相邻的，它们不能同时被抢。
     *
     * 在不能抢相邻房子的情况下，这里最多可以抢到的钱是 10，可以抢 8 和 2，也可以抢 1 和 9。
     */
    //去掉头尾 抢两次联排房子中的最大获利

    private int rob(int[] nums, int start, int end) {
        int prev2 = 0, prev1 = 0;
        for (int i = start; i <= end; ++i) {
            int cur = Math.max(prev1, prev2+nums[i]);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }

    // Time: O(n), Space: O(1)
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(rob(nums, 0, n-2), rob(nums, 1, n-1));
    }

}