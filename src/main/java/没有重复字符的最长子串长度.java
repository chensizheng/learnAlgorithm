/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

import java.util.Arrays;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2018/12/28
 */

public class 没有重复字符的最长子串长度 {

    // Time: O(n), Space: O(m), m 是字符集大小
    public int lengthOfLongestSubstring2N(String s) {
        int[] counts = new int[256];
        int i = 0, j = 0, maxLen = 0;
        for (; i < s.length(); ++i) {
            for (; j < s.length(); ++j) {
                if (counts[s.charAt(j)] != 0) break;
                counts[s.charAt(j)] += 1;
            }
            maxLen = Math.max(maxLen, j - i); // j - i is current length
            counts[s.charAt(i)] -= 1;
        }
        return maxLen;
    }

    // Time: O(n), Space: O(m)，m 是字符集大小
    public static int lengthOfLongestSubstring1N(String s) {
        int[] index = new int[256];
        Arrays.fill(index, -1);
        int maxLen = 0;
        for (int i=0, j=0; j < s.length(); ++j) {
            i = Math.max(index[s.charAt(j)] + 1, i);
            maxLen = Math.max(maxLen, j - i + 1);
            index[s.charAt(j)] = j;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "1bcdefgabcdefghabc";
        int i = lengthOfLongestSubstring1N(s);
        System.out.println(i);
        System.out.println(s.charAt(1));
    }

}