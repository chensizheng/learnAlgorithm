package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2018/12/29
 */

public class 回文数字判断 {
    //将数字转换成字符串判断
    // Time: O(m), Space: O(1)
    public boolean isPalindromeString(int x) {
        String s = String.valueOf(x);
        int i=0,j=s.length();
        while (i<j){
            if (s.charAt(i) != s.charAt(j)) return false;
            ++i;
            --j;
        }
        return true;
    }

    // Time: O(m), Space: O(1)
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int tmp = x;
        long y = 0;
        while (tmp != 0) {
            int num = tmp % 10;
            y = y * 10 + num;
            tmp = tmp / 10;
        }
        return y == x;
    }
}