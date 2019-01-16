/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/3
 */

public class 有序数组中的单身数字 {
    // Time: O(n), Space: O(1)
    public int singleNumInSortedArrayWithXOR(int[] nums) {
        int result = 0;
        for (int num: nums) result ^= num;
        return result;
    }

    // Time: O(log(n)), Space: O(1)
    public int singleNumInSortedArrayBinarySearch(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (mid-1 >= 0 && nums[mid-1] == nums[mid]) {
                --mid;
            } else if (mid+1 < nums.length && nums[mid+1] == nums[mid]) {
            } else {
                return nums[mid];
            }
            if ((mid-low) % 2 == 1) high = mid - 1;
            else low = mid + 2;
        }
        return -1;
    }
}