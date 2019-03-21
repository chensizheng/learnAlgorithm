package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/21
 */

public class 缺失的数字 {
    /***
     * 问题
     * 这个题目说的是，从 0 到 n 这 n+1 个整数中去掉一个，然后把剩下的 n 个整数放进一个长度为 n 的数组，给你这个数组，你要找到那个去掉的整数。
     *
     * 比如说，给你的数组是：
     *
     * 4, 1, 0, 2
     *
     * 这里的数组长度是 4，说明这是从 0 到 4 中去掉一个数字后形成的数组。数组中缺失的数字是 3，因此我们要返回 3。
     */
    //求异或 0 1 2 3 4 异或 0 1 2 4 = 3

    // Time: O(n), Space: O(1)
    public int missingNumber(int[] nums) {
        int n = nums.length, result = n;
        for (int i = 0; i < n; ++i) result = result ^ i ^ nums[i];
        return result;
    }
}