package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/21
 */

public class 逻辑距离 {
    /***
     * 问题
     * 这个题目说的是，给你两个字符串，你要求出由其中一个字符串转成另一个所需要的最少编辑操作次数。允许的操作有 3 种，分别是：替换一个字符，插入一个字符和删除一个字符。
     *
     * 比如说，给你的两个字符串是 car 和 ba。
     *
     * s1: car
     * s2: ba
     *
     * 你要把 car 转成 ba，需要先把 c 替换成 b，然后再删除 r。总共操作 2 次，因此它们的编辑距离是 2。
     */
    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    // Time: O(m*n), Space: O(m*n)
    public int editDistance(String s, String t) {
        if (s == null || t == null) return 0;

        int m = s.length() + 1, n = t.length() + 1;
        int[][] d = new int[m][n];

        for (int i = 0; i < m; ++i)
            d[i][0] = i;
        for (int j = 0; j < n; ++j)
            d[0][j] = j;

        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    d[i][j] = d[i-1][j-1];
                } else {
                    d[i][j] = min(d[i-1][j-1], d[i-1][j], d[i][j-1]) + 1;
                }
            }

        }
        return d[m-1][n-1];
    }


    // Time: O(m*n), Space: O(n)
    public int editDistance1dArray(String s, String t) {
        if (s == null || t == null) return 0;

        int m = s.length() + 1, n = t.length() + 1;
        int[] d = new int[n];

        for (int j = 0; j < n; ++j)
            d[j] = j;

        for (int i = 0; i < m; ++i){
            int pre = d[0];
            for (int j = 1; j < n; ++j) {
                int tmp = d[j];
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    d[j] = pre;
                } else {
                    d[j] = min(pre, d[j], d[j-1]) + 1;
                }
                pre = tmp;
            }
        }
        return d[n-1];

    }


}