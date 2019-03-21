package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/24
 */

public class 第n个斐波那契数 {
    /***
     * 问题
     * 这个题目说的是，给你一个非负整数 n，你要写一个函数返回第 n 个斐波那契数。其中斐波那契数列最开始的两项是 0 和 1，后面任意一项都是它前面两个数字之和。
     *
     * 比如说，你写的函数是 f，那么就有：
     *
     * f(0) = 0,
     * f(1) = 1,
     * f(2) = 0 + 1 = 1,
     * f(3) = 1 + 1 = 2,
     * f(4) = 1 + 2 = 3,
     * f(5) = 2 + 3 = 5,
     * ...
     *
     * 以此类推。
     */

    // Time: O(2^n), Space: O(n)
    public int fibRecursive(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fibRecursive(n-1) + fibRecursive(n-2);
    }


    // Time: O(n), Space: O(n)
    public int fibIterative(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int[] d = new int[n+1];
        d[0] = 0; d[1] = 1;
        for (int i = 2; i <= n; ++i)
            d[i] = d[i-1] + d[i-2];
        return d[n];
    }


    // Time: O(n), Space: O(1)
    public int fibIterativeO1(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int first = 0, second = 1;
        for (int i = 2; i <= n; ++i) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }



}