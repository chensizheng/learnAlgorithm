/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/15
 */

public class 回文子串个数 {
    /***
     * 问题
     * 这个题目说的是，给你一个字符串，你要计算出它所包含的回文子串个数。只要起始下标或终止下标不同，即使子串相同，我们也认为是不同的回文子串。
     *
     * 比如说，给你的字符串是：
     *
     * abc
     *
     * 这个字符串中总共有 3 个回文子串，分别是 a， b 和 c。因此你要返回的个数是 3。
     *
     * 再比如说，给你的字符串是：
     *
     * aba
     *
     * 这个字符串中总共有 4 个回文子串，分别是 a，b，a，和 aba。因此你要返回的个数是 4。
     */


    // Time: O(n^2), Space: O(n^2)
    public int countPalindromicSubstringsDP(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length(), count = 0;
        boolean[][] d = new boolean[n][n];

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                if (i == j) d[i][j] = true;
                else if (i+1 == j) d[i][j] = s.charAt(i) == s.charAt(j);
                else d[i][j] = s.charAt(i) == s.charAt(j) && d[i+1][j-1];

                if (d[i][j]) ++count;
            }
        }

        return count;
    }

    int expand(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            ++count;
            --left; ++right;
        }
        return count;
    }

    // Time: O(n^2), Space: O(1)
    public int countPalindromicSubstringsExpand(String s) {
        if (s == null || s.length() == 0) return 0;
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            count += expand(s, i, i);
            count += expand(s, i, i+1);
        }
        return count;
    }
}