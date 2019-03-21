package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/25
 */

public class 二维数组的二分搜索 {
    /***
     * 问题
     * 这个题目说的是，给你一个二维数组 matrix，和一个目标值 target。你要在数组里找到这个目标值，然后返回它的行/列下标。如果找不到，则返回 [-1,-1]。
     *
     * 这个数组的每一行都是递增的，并且每一行的第一个数都比上一行的最后一个数要大。也就是，这个数组可以看成，从左到右、从上到下，呈 Z 字形递增。
     *
     * 比如说，给你的二维数组是：
     *
     * 1, 3, 5
     * 7, 9, 11
     *
     * 给你的目标值是 9。9 在这个数组中，找到后返回它的下标 [1, 1] 即可。
     *
     * 如果给你的目标值是 100。显然它不在这个二维数组中，你要返回 [-1，-1]。
     */
    // r行坐标 c列坐标
    // Time: O(log(m*n)), Space: O(1)
    public int[] binarySearchIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 ||
                matrix[0] == null || matrix[0].length == 0)
            return new int[]{-1, -1};

        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int r = mid / n, c = mid % n;
            if (target < matrix[r][c]) high = mid - 1;
            else if (target > matrix[r][c]) low = mid + 1;
            else return new int[]{r, c};
        }
        return new int[]{-1, -1};
    }

}