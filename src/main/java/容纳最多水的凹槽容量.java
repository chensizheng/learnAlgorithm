/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/24
 */

public class 容纳最多水的凹槽容量 {
    /***
     * 问题
     * 这个题目说的是，给你一个非负整数数组，数组中的数字表示高度值，
     * 在平面坐标画出来后，连同 X 轴一起，会形成许多的凹槽。
     * 你要找到两个高度值，使其形成的凹槽所能容纳的水最多。最后返回容纳的水量。
     */


    // Time: O(n), Space: O(1)
    public int maxWater(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;

        while (i < j) {
            int cur = Math.min(height[i], height[j]) * (j - i);
            max = Math.max(max, cur);
            if (height[i] < height[j]) ++i;
            else --j;
        }

        return max;
    }

}