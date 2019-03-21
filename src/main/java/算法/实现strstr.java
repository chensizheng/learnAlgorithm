package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/25
 */

public class 实现strstr {
    /***
     * 问题
     * 这个题目说的是，你要实现 C 语言里面的 strstr 函数，这个函数接收两个字符串，你要找到第二个字符串在第一个字符串中的开始下标，如果找不到则返回 -1。
     *
     * 比如说，给你的两个字符串分别是：
     *
     * marvel studio 和 studio
     *
     * 第二个字符串存在于第一个字符串中，于是你要返回它在第一个字符串中的开始下标 7。
     *
     * 再比如说给你的字符串是：
     *
     * doctor strange 和 master
     *
     * 第二个字符串没有在第一个字符串中出现，因此返回 -1。
     */

    // Time: O((n-m+1)*m), Space: O(1)
    public int strstr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (needle.length() == 0) return 0;
        int n = haystack.length(), m = needle.length();

        for (int i = 0; i <= n-m; ++i) {
            int j = 0, k = i;
            for (; j < m && k < n && needle.charAt(j) == haystack.charAt(k); ++j, ++k);
            if (j == needle.length()) return i;
        }
        return -1;
    }

}