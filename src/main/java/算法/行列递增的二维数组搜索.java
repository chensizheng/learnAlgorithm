package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/21
 */

public class 行列递增的二维数组搜索 {
    /***
     * 问题
     * 这个题目说的是，给你一个二维数组 matrix，和一个目标值 target。你要在数组里找到这个目标值，然后返回它的行/列下标。如果找不到，则返回 [-1,-1]。
     *
     * 这个数组的每一行都是从左向右递增，每一列都是从上到下递增。和「二维数组的二分搜索」不同，这道题目并不保证每一行的第一个数都比上一行的最后一个数要大。
     *
     * 比如说，给你的二维数组是：
     *
     * 1, 3, 5
     * 2, 4, 6
     *
     * 给你的目标值是 4。目标值 4 在这个数组中，找到后返回它的下标 [1, 1] 即可。
     *
     * 如果给你的目标值是 100，显然它不在这个二维数组中，你要返回 [-1，-1]。
     */
    // Time: O(m+n), Space: O(1)
    //从左上角开始:如果[i][j]>target 抛弃这一列，否则抛弃这一行
    public int[] searchIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 ||
                matrix[0] == null || matrix[0].length == 0)
            return new int[]{-1, -1};

        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (target < matrix[i][j]) --j;
            else if (target > matrix[i][j]) ++i;
            else return new int[]{i, j};
        }
        return new int[]{-1, -1};
    }

}