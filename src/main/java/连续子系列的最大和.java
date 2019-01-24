/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/24
 */

public class 连续子系列的最大和 {
    /***
     * 问题
     * 这个题目说的是，给你一个非空整数数组，你要找到和最大的连续子序列，然后返回它的和。
     *
     * 比如说，给你的数组 a 是：
     *
     * 2, -8, 3, -2, 4, -10
     *
     * 和最大的连续子序列是 3, -2, 4,  他们的和是 5。
     */


    //当前子序列和cur 如果<=0 则不会对最大和有任何贡献，则更新cur = n[i], 否则cur = cur+n[i]
    // Time: O(n), Space: O(1)
    public int maxSumOfSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, cur = 0;
        for (int i = 0; i < nums.length; ++i) {
            cur = cur <= 0 ? nums[i] : (cur + nums[i]);
            max = Math.max(max, cur);
        }
        return max;
    }
}