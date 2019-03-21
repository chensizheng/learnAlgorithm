package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/16
 */

public class 汉明距离 {
    /***
     * 问题
     * 这个题目说的是，给你两个整数，你要计算出它们的二进制表示中，相应的二进制位有多少个是不同的。这个不同的个数，也称为这两个整数的汉明距离。
     *
     * 比如说，给你的两个整数是 3 和 8。它们的二进制表示分别是：
     *
     * 3: 0011
     * 8: 1000
     *
     * 这两个数有 3 个二进制位是不相同的，因此它们的汉明距离是 3。
     */
    int numberOfOne(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n &= (n - 1);
        }
        return count;
    }

    public int hammingDistance(int x, int y) {
        return numberOfOne(x ^ y);
    }

}