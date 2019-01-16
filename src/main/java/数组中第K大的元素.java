/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/3
 */

public class 数组中第K大的元素 {

    public int findKthLargestMinHeap(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int num: nums) {
            if(minHeap.size()<k){
                minHeap.add(num);
            }else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(num);
            }
        }
        return minHeap.peek();
    }

    //快速选择法
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    int partition(int[] nums, int low, int high) {
        int pivot = nums[low], i = low, j = high;
        while (i < j) {
            while (i < j && nums[j] < pivot) --j;
            if (i < j) swap(nums, i, j);
            while (i < j && nums[i] >= pivot) ++i;
            if (i < j) swap(nums, i, j);
        }
        return i;
    }

    // Time(avg): O(n), Time(worst): O(n^2), Space: O(1)
    public int findKthLargestQuickSelect(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int p = partition(nums, low, high);
            if (p == k-1) return nums[p];
            else if (p > k-1) high = p - 1;
            else low = p + 1;
        }
        return -1;
    }

}