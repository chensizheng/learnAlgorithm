/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/16
 */

public class 最小路径和 {
    /***
     * 问题
     * 这个题目说的是，给你一个 m x n 的整数矩阵，你要计算从矩阵的左上角到右下角的所有路径中，最小的路径和。路径的移动方向只能是向右或向下。
     *
     * 比如说，给你的矩阵 a 是：
     *
     *  1, 2, 1
     *  8, 4, 1
     * -8, 2, 1
     *
     * 对于这个矩阵，从左上角走到右下角，和最小的一条路径是 1,8,-8,2,1，它的和是 4，因此你需要返回 4。
     */

    // Time: O(m*n), Space: O(m*n)
    public int minSumOfPath(int[][] a) {
        int m = a.length, n = a[0].length;
        int[][] d = new int[m][n];

        d[0][0] = a[0][0];
        for (int i = 1; i < m; ++i)
            d[i][0] = d[i-1][0] + a[i][0];
        for (int j = 1; j < n; ++j)
            d[0][j] = d[0][j-1] + a[0][j];

        for (int i = 1; i < m; ++i)
            for (int j = 1; j < n; ++j)
                d[i][j] = Math.min(d[i-1][j], d[i][j-1]) + a[i][j];

        return d[m-1][n-1];
    }

    // Time: O(m*n), Space: O(n)
    //比上一个方法的优化在于d只记录当前第i行
    public int minSumOfPath1dArray(int[][] a) {
        int m = a.length, n = a[0].length;
        int[] d = new int[n];

        d[0] = a[0][0];
        for (int j = 1; j < n; ++j)
            d[j] = d[j-1] + a[0][j];

        for (int i = 1; i < m; ++i) {
            d[0] += a[i][0];
            for (int j = 1; j < n; ++j) {
                d[j] = Math.min(d[j], d[j-1]) + a[i][j];
            }
        }

        return d[n-1];
    }


}