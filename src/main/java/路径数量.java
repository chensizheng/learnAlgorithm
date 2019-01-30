/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/30
 */

public class 路径数量 {
    /***
     * 问题
     * 这个题目说的是，给你两个整数 m 和 n，表示的是一个 m x n 的矩阵，任何时候你只能向右或向下移动，那么从矩阵左上角移动到右下角，共有多少条不同的路径。
     *
     * 比如说，给你的 m = 2，n = 4。简单地画出这个矩阵，使用 0 作为占位符：
     *
     * 0, 0, 0, 0
     * 0, 0, 0, 0
     *
     * 从这个矩阵的左上角走到右下角，共有 4 条不同的路径，因此返回 4。
     */

    // Time: O(m*n), Space: O(m*n)
    public int uniquePathsDP(int m, int n) {
        if (m < 1 || n < 1) return 0;
        int[][] d = new int[m][n];
        for (int i = 0; i < m; ++i)
            d[i][0] = 1;
        for (int j = 0; j < n; ++j)
            d[0][j] = 1;

        for (int i = 1; i < m; ++i)
            for (int j = 1; j < n; ++j)
                d[i][j] = d[i-1][j] + d[i][j-1];
        return d[m-1][n-1];
    }

    // Time: O(min(m, n)), Space: O(1)
    public int uniquePathsMath(int m, int n) {
        if (m < 1 || n < 1) return 0;
        int small = Math.min(m-1, n-1);
        int total = m + n - 2;
        long result = 1;
        for (int i = 0; i < small; ++i)
            result = result * (total-i) / (i+1);
        return (int)result;
    }

}