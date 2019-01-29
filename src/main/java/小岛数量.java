/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

import java.util.Stack;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/29
 */

public class 小岛数量 {
    /***
     * 问题
     * 这个题目说的是，给你一个包含 0/1 字符的二维数组，字符 1 构成的连通区域表示小岛，字符 0 表示海水，你要计算二维数组中有多少个小岛。在这个题目中，元素相邻只考虑上/下/左/右 4 个元素，斜方向的元素认为是不相邻的。
     *
     * 比如说，给你的二维数组 g 是：
     *
     * 1 0 0
     * 0 1 1
     * 0 1 1
     *
     * 这个二维数组中，左上角的 1 是一个小岛，右下角 4 个 1 也组成了一个小岛。总共有 2 个小岛，因此你要返回的就是 2。
     */
    //使用深度优先算法

    private void dfs(char[][] g, boolean[][] visit, int i, int j) {
        int m = g.length, n = g[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || g[i][j] == '0' || visit[i][j])
            return;
        visit[i][j] = true;
        dfs(g, visit, i-1, j);
        dfs(g, visit, i+1, j);
        dfs(g, visit, i, j-1);
        dfs(g, visit, i, j+1);
    }

    public int numberOfIslands(char[][] g) {
        if (g == null || g.length == 0 ||
                g[0] == null || g[0].length == 0)
            return 0;
        int m = g.length, n = g[0].length;
        boolean[][] visit = new boolean[m][n];

        int num = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (g[i][j] == '0' || visit[i][j]) continue;
                ++num;
                dfs(g, visit, i, j);
            }
        }
        return num;
    }



    private class Point {
        int i, j;
        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private void dfsIterative(char[][] g, boolean[][] visit, int i , int j) {
        int m = g.length, n = g[0].length;
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(i, j));
        while (!stack.isEmpty()) {
            Point p = stack.pop();
            if (p.i < 0 || p.i >=m || p.j < 0 || p.j >= n || g[p.i][p.j] == '0' || visit[p.i][p.j])
                continue;
            visit[p.i][p.j] = true;
            stack.push(new Point(p.i-1, p.j));
            stack.push(new Point(p.i+1, p.j));
            stack.push(new Point(p.i, p.j-1));
            stack.push(new Point(p.i, p.j+1));
        }
    }




}