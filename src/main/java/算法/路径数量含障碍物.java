package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/30
 */

public class 路径数量含障碍物 {
    /***
     * 问题
     * 这个题目说的是，给你一个矩阵，矩阵元素有 0 和 1 两种值。0 表示矩阵中这个格子是空的，可以走；1 表示这个格子里有障碍物，不能走。你在这个矩阵中只能向右或向下走，那么从矩阵左上角走到右下角，共有多少条不同的路径。
     *
     * 比如说给你的矩阵是：
     *
     *  0, 0, 1, 0
     *  0, 0, 0, 0
     *
     * 第 0 行的 1 表示那里有个障碍物，不能走。从这个矩阵的左上角走到右下角，共有 2 条不同的路径，因此要返回 2。
     */

    // Time: O(m*n), Space: O(m*n)
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] d = new int[m][n];
        d[0][0] = grid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < m; ++i)
            d[i][0] = grid[i][0] == 1 ? 0 : d[i-1][0];
        for (int j = 1; j < n; ++j)
            d[0][j] = grid[0][j] == 1 ? 0 : d[0][j-1];

        for (int i = 1; i < m; ++i)
            for (int j = 1; j < n; ++j)
                d[i][j] = grid[i][j] == 1 ? 0 : d[i-1][j] + d[i][j-1];
        return d[m-1][n-1];
    }

    // Time: O(m*n), Space: O(n)
    public int uniquePathsWithObstaclesOn(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] d = new int[n];
        d[0] = grid[0][0] == 1 ? 0 : 1;

        for (int i = 0; i < m; ++i) {
            d[0] = grid[i][0] == 1 ? 0 : d[0];
            for (int j = 1; j < n; ++j) {
                d[j] = grid[i][j] == 1 ? 0 : d[j] + d[j-1];
            }
        }
        return d[n-1];
    }

}