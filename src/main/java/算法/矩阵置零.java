package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/29
 */

public class 矩阵置零 {
    /***
     * 问题
     * 这个题目说的是，给你一个 m x n 的矩阵，你要把这个矩阵中等于 0 的元素所在的行和列都置 0。
     *
     * 比如说，给你的矩阵 a 是：
     *
     *  1, 2, 3
     *  4, 0, 6
     *  0, 8, 9
     *
     * 这个矩阵中有两个 0，把它们所在的行和列都置 0 后，得到的矩阵是：
     *
     *  0, 0, 3
     *  0, 0, 0
     *  0, 0, 0
     */

    // Time: O(m*n), Space: O(m+n)
    public void setZeroInMatrix(int[][] a) {
        int m = a.length, n = a[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (a[i][j] == 0)
                    rows[i] = cols[j] = true;

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (rows[i] || cols[j])
                    a[i][j] = 0;
    }

    // Time: O(m*n), Space: O(1)
    public void setZeroInMatrixO1(int[][] a) {
        int m = a.length, n = a[0].length;
        boolean row0 = false, col0 = false;

        for (int i = 0; i < m; ++i)
            if (a[i][0] == 0) col0 = true;
        for (int j = 0; j < n; ++j)
            if (a[0][j] == 0) row0 = true;

        for (int i = 1; i < m; ++i)
            for (int j = 1; j < n; ++j)
                if (a[i][j] == 0)
                    a[i][0] = a[0][j] = 0;

        for (int i = 1; i < m; ++i)
            for (int j = 1; j < n; ++j)
                if (a[i][0] == 0 || a[0][j] == 0)
                    a[i][j] = 0;

        if (row0)
            for (int j = 0; j < n; ++j)
                a[0][j] = 0;
        if (col0)
            for (int i = 0; i < m; ++i)
                a[i][0] = 0;
    }


}