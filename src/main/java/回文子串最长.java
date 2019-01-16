/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/16
 */

public class 回文子串最长 {
    /***
    * 问题
    * 这个题目说的是，给你一个字符串，你要在它所有的回文子串中，找到长度最长的子串，并返回它。
    *
    * 比如说，给你的字符串是：
    *
    * abcbab
    *
    * 你要返回的最长回文子串是：
    *
    * abcba
    */
    // Time: O(n^2), Space: O(n^2)
    //动态规划 通过保存子问题的解 求主问题的解
    public String longestPalindromeDP(String s) {
        if (s == null || s.length() == 0) return "";
        int n = s.length(), start = 0, maxLen = 0;
        boolean[][] d = new boolean[n][n];

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                if (i == j) d[i][j] = true;
                else if (i+1 == j) d[i][j] = s.charAt(i) == s.charAt(j);
                else d[i][j] = s.charAt(i) == s.charAt(j) && d[i+1][j-1];

                if (d[i][j] && (j-i+1) > maxLen) {
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }

        return s.substring(start, start+maxLen);
    }

    int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left; ++right;
        }
        // (right-1) - (left+1) + 1
        return right - left - 1;
    }

    // Time: O(n^2), Space: O(1)
    //把当前字符作为回文字符串的中心，向两边扩展
    public String longestPalindromeExpand(String s) {
        if (s == null || s.length() == 0) return "";
        int start = 0, maxLen = 0;
        for (int i = 0; i < s.length(); ++i) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                start = i - (len-1)/2;
                maxLen = len;
            }
        }
        return s.substring(start, start+maxLen);
    }

}