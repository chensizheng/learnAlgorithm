/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/15
 */

public class 雨后盛水量 {
    /***
     * 问题
     * 这个题目说的是，给你一个非负整数数组表示的高度图，你要计算出下雨后，这个高度图中可以盛多少水。
     *
     * 比如说，给你的数组是：
     *
     * 0, 2, 0, 4, 0, 1, 2
     *
     * 高度示意图：
     *
     *   ^
     *   |
     * 4 +        +--+
     *   |        |  |
     * 3 +        |  |
     *   |        |  |
     * 2 +  +--+  |  |     +--+
     *   |  |  |  |  |     |  |
     * 1 +  |  |  |  |  +--+  |
     *   |  |  |  |  |  |  |  |
     *   +--+--+--+--+--+--+--+-->
     *    0  1  2  3  4  5  6
     *
     * 在这个高度图中，下标 2 位置的盛水量是 2，下标 4 位置的盛水量是 2，下标 5 位置的盛水量是 1，因此总共的盛水量是：
     *
     * 2 + 2 + 1 = 5
     */

    // Time: O(n), Space: O(n)
    public int waterCanBeTrap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n = height.length, leftMax = -1, rightMax = -1, water = 0;
        int[] d = new int[n];
        for (int i = 0; i < n; ++i) {
            leftMax = Math.max(leftMax, height[i]);
            d[i] = leftMax;
        }
        for (int i = n-1; i >= 0; --i) {
            rightMax = Math.max(rightMax, height[i]);
            d[i] = Math.min(d[i], rightMax);
            water += (d[i] - height[i]);
        }
        return water;
    }

    // Time: O(n), Space: O(1)
    public int waterCanBeTrapO1(int[] height) {
        if (height == null || height.length == 0) return 0;
        int leftMax = -1, rightMax = -1, water = 0;
        int i = 0, j = height.length - 1;
        while (i <= j) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);
            if (leftMax < rightMax) water += (leftMax - height[i++]);
            else water += (rightMax - height[j--]);
        }
        return water;
    }


}