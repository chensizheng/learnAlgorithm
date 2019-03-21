package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/28
 */

public class 买卖股票的最大利润 {
    /***
     * 问题
     * 这个题目说的是，给你一个整数数组，其中第 i 个元素表示的是第 i 天的股票价格，你要计算出先买一股，然后再卖出它能获得的最大利润。
     *
     * 比如说，给你的数组是：
     *
     * 9, 3, 7, 5, 1, 8
     *
     * 如果你在价格为 1 时买入并在价格为 8 时卖出，这时能获得最大的利润 7。
     *
     * 再比如说给你的数组是：
     *
     * 9, 8, 7, 6
     *
     * 这时股票每天都在迭，不存在买入再卖出来获利的可能，因此没有交易，最大利润为 0。
     */
// Time: O(n^2), Space: O(1)
    public int maxProfitBruteForce(int[] prices) {
        if (prices.length < 2) return 0;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; ++i)
            for (int j = i+1; j < prices.length; ++j)
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);

        return maxProfit;
    }

    // Time: O(n), Space: O(1)
    public int maxProfitOnePass(int[] prices) {
        if (prices.length < 2) return 0;

        int maxProfit = 0, buy = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] < buy) buy = prices[i];
            else maxProfit = Math.max(maxProfit, prices[i] - buy);
        }
        return maxProfit;
    }



}