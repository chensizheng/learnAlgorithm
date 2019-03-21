package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/29
 */

public class 最长回文串的长度 {
    /***
     * 问题
     * 这个题目说的是，给你一个包含大小写英文字母的字符串，你要用这些字母构建一个最长的回文字符串，并返回它的长度。
     *
     * 比如说，给你的字符串 s 是：
     *
     * aaabccdd
     *
     * 你能用它构建的回文串的最大长度是 7，因此你要返回的就是数字 7。
     *
     * 长度为 7 的回文串有多种构建方式，随便举一种，比如 acdbdca
     */

    //找奇数次出现的字符，odd , unUsed =  Math.max(0, odd-1)

    // Time: O(n), Space: O(m)
    public int lengthOfLongestPalindrome(String s) {
        int[] d = new int[256];
        int oddNum = 0;
        for (char c: s.toCharArray())
            ++d[c];
        for (int count: d)
            if (count % 2 == 1)
                ++oddNum;
        int unUsed = Math.max(0, oddNum-1);
        return s.length() - unUsed;
    }


}