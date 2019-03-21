package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/29
 */

public class 第N个丑数 {
    /***
     * 问题
     * 这个题目说的是，给你一个整数 n，你要返回第 n 个丑数。丑数的定义是质因数只包含 2，3，5 的正整数。另外，1 作为特例，也定义为丑数。
     *
     * 比如说，给你的 n=6。前 6 个丑数是：
     *
     * 1, 2, 3, 4, 5, 6 // 它们的质因数都只包含 2，3，5
     *
     * 于是你要返回第 6 个丑数 6。
     */

    // Time: O(n*log(n)), Space: O(n)
    public int getNthUglyNumberMinHeap(int n) {
        int uglyNum = -1;
        Queue<Integer> q = new PriorityQueue<>();
        q.add(1);
        while (n > 0) {
            while (q.peek() == uglyNum) q.poll();
            uglyNum = q.poll();
            if (2L * uglyNum <= Integer.MAX_VALUE)
                q.add(2 * uglyNum);
            if (3L * uglyNum <= Integer.MAX_VALUE)
                q.add(3 * uglyNum);
            if (5L * uglyNum <= Integer.MAX_VALUE)
                q.add(5 * uglyNum);
            --n;
        }
        return uglyNum;
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    // Time: O(n), Space: O(n)
    public int getNthUglyNumberDP(int n) {
        if (n <= 0) return -1;
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; ++i) {
            int min = min(uglyNums[p2]*2, uglyNums[p3]*3, uglyNums[p5]*5);
            uglyNums[i] = min;
            if (min == uglyNums[p2]*2) ++p2;
            if (min == uglyNums[p3]*3) ++p3;
            if (min == uglyNums[p5]*5) ++p5;
        }
        return uglyNums[n-1];
    }


}