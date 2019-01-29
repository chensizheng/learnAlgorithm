/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/29
 */

public class 抢劫连排房子 {
    /***
     * 问题
     * 这个题目说的是，有一个强盗要去抢一排连排房子，每个房子里放着正整数金额的钱，可以用一个整数数组来表示。这个强盗唯一的限制就是不能同时抢相邻的两个房子，那么请问，这个强盗最多可以抢到多少钱。
     *
     * 比如说，这排房子里放着的钱是整数数组 nums：
     *
     * 8, 1, 2, 9, 6
     *
     * 在不能抢相邻房子的情况下，最多可以抢到的钱是 17，就是抢 8 和 9 这两个数字对应的房子。
     *
     * 抢完 8 和 9 后，其它的房子就都不能抢了，因为都与这两所房子相邻。
     *
     * 而其它的抢劫组合也都没有 17 大，比如抢 8,2,6，这三个房子不相邻可以同时抢，但抢它们的话能抢到的钱只有 16，没有 17 大。
     */
// Time: O(n), Space: O(n)
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] d = new int[nums.length];
        d[0] = nums[0]; d[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; ++i) {
            d[i] = Math.max(d[i-1], d[i-2]+nums[i]);
        }
        return d[nums.length-1];
    }

    // Time: O(n), Space: O(1)
    public int robO1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int prev2 = 0, prev1 = 0;

        for (int num : nums) {
            int cur = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}