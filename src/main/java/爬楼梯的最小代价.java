/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/29
 */

public class 爬楼梯的最小代价 {
    /***
     * 问题
     * 这个题目说的是，给你一个整数数组，数组中的整数表示爬对应阶楼梯的代价。你可以从第 0 阶或第 1 阶楼梯开始爬，每次可以向上爬 1 阶或 2 阶。那么请问，爬完这个楼梯的最小代价是多少？
     *
     * 比如说，给你的代价数组 c 是：
     *
     * 1, 2, 4, 2
     *
     * 爬完这个楼梯的最小代价为 4，也就是从第 1 阶（对应的代价为 2）开始，然后爬两阶就爬完了，代价是 2 + 2 = 4。
     */



    // Time: O(n), Space: O(n)
    public int minCostClimbingStairs(int[] cost) {
        if(cost ==null || cost.length==0) return 0;
        if (cost.length == 1) return cost[0];
        int n  = cost.length;
        int[] d = new int[n];
        d[0] = cost[0];
        d[1] = cost[1];

        for(int i=2;i<n;i++){
            d[i] = Math.min(d[i-1],d[i-2])+cost[i];
        }
        return Math.min(d[n-2],d[n-1]);
    }

    // Time: O(n), Space: O(1)
    public int minCostClimbingStairsO1(int[] cost) {
        if (cost == null || cost.length == 0) return 0;
        if (cost.length == 1) return cost[0];
        int first = cost[0], second = cost[1];
        for (int i = 2; i < cost.length; ++i) {
            int cur = Math.min(first, second) + cost[i];
            first = second;
            second = cur;
        }
        return Math.min(first, second);
    }
}