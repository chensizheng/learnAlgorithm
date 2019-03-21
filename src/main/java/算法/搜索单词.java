package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/30
 */

public class 搜索单词 {
    /***
     * 问题
     * 这个题目说的是，给你一个二维字符矩阵和一个单词，矩阵中的字符可以和它上/下/左/右的字符连接起来形成单词，并且每个位置的字符不能重复使用。你要判断给你的单词是否存在于字符矩阵中。
     *
     * 比如说，给你的字符矩阵是：
     *
     * a, a, c, b
     * i, r, a, r
     * b, e, y, r
     *
     * 给你的单词是 car。car 存在于字符矩阵中，因此返回 true。
     *
     * 如果给你的单词是 cab，cab 不存在于字符矩阵中，因此返回 false。
     */

    private boolean exist(char[][] board, boolean[][] visited, int i, int j,
                          String word, int idx) {
        if (idx == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
                visited[i][j] || board[i][j] != word.charAt(idx))
            return false;
        visited[i][j] = true;
        boolean existed = exist(board, visited, i-1, j, word, idx+1) ||
                exist(board, visited, i+1, j, word, idx+1) ||
                exist(board, visited, i, j-1, word, idx+1) ||
                exist(board, visited, i, j+1, word, idx+1);
        visited[i][j] = false;
        return existed;
    }

    // Time: O(m*n*3^k), Space: O(m*n)
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 ||
                board[0] == null || board[0].length == 0)
            return false;
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (exist(board, visited, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }

}