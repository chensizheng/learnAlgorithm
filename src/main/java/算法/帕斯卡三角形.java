package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/24
 */

public class 帕斯卡三角形 {
    /***
     * 这个题目说的是，给你一个非负整数 n，你要返回帕斯卡三角形的前 n 行。帕斯卡三角形又称为杨辉三角形，它的特点是左右两条边上的数字都为 1，其它位置的数字等于左上方与右上方的两个数字之和。
     *
     * 比如说，给你的数字是 5，你要返回帕斯卡三角形的前 5 行。
     *
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1]
     */

    /**
     * a(i,0) = 1
     * a(i,i) = 1
     * a(i,j) = a(i-1,j-1)+a(i-1,j)
      */
    // Time: O(n^2), Space: O(1)
    public List<List<Integer>> generatePascalTriangle(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < 1) return result;

        for (int i = 0; i < n; ++i) {
            List<Integer> list = Arrays.asList(new Integer[i+1]);
            list.set(0, 1); list.set(i, 1);
            for (int j = 1; j < i; ++j) {
                list.set(j, result.get(i-1).get(j-1) + result.get(i-1).get(j));
            }
            result.add(list);
        }
        return result;
    }


}