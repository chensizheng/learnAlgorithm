package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/23
 */

public class 实现平方根函数 {

    /***
     * 问题
     * 这个题目说的是，你要实现一个函数，来计算非负整数 n 的平方根，平方根只需返回整数部分即可。
     *
     * 比如，使用你实现的函数来计算 9 的平方根是 3：
     *
     * f(9) = 3
     *
     * 由于 8 的平方根是 2 点几，使用你实现的函数只需要返回整数部分 2 即可：
     *
     * f(8) = 2
     */

    // Time: O(log(n)), Space: O(1)
    public int sqrtBinarySearch(int n) {
        long low = 0, high = n;
        while (low <= high) {
            long mid = low + (high - low)/2;
            long mid2 = mid * mid;
            if (mid2 < n) low = mid + 1;
            else if (mid2 > n) high = mid - 1;
            else return (int)mid;
        }
        return (int)high;
    }

    // Time: O(log(n)), Space: O(1)
    public int sqrtNewton(int n) {
        long x = n;
        while (x*x > n) {
            x = (x + n/x) / 2;
        }
        return (int)x;
    }

}