/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/25
 */

public class 二分搜索插入位置 {

    /***
     * 问题
     * 这个题目说的是，给你一个递增排序的整数数组 nums，和一个目标值 target。你要在数组里找到 target，然后返回它的下标。
     * 如果找不到，则返回目标值应该插入的位置的下标，要求插入目标值后，数组仍然保持有序。
     */
    // Time: O(log(n)), Space: O(1)
    public int binarySearchInsertPosition(int[] nums, int target) {
        if (nums == null) return -1;

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < nums[mid]) high = mid - 1;
            else if (target > nums[mid]) low = mid + 1;
            else return mid;
        }
        return low;
    }
}