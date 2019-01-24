/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/24
 */

public class 求两个有序数组的中位数 {
    /***
     * 问题
     * 这个题目说的是，给你两个排好序的整数数组 nums1 和 nums2，假设数组是以递增排序的，数组的大小分别是 m 和 n。你要找到这两个数组的中位数。要求算法的时间复杂度是 O(log(m+n))。
     *
     * 这里两个数组中位数的意思是，两个数组合到一起排序后，位于中间的那个数，如果一共有偶数个，则是位于中间的两个数的平均数。
     *
     * 比如说，给你的两个数组是：
     *
     * 1, 3
     * 2
     *
     * 它们放在一起排序后是：
     *
     * 1, 2, 3
     *
     * 所以中位数就是 2。
     *
     * 再比如说，给你的两个数组是：
     *
     * 1, 3
     * 2, 4
     *
     * 它们放在一起排序后是：
     *
     * 1, 2, 3, 4
     *
     * 所以中位数就是 (2 + 3) / 2 = 2.5。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if ((total & 1) == 1) {
            return findKthSmallestInSortedArrays(nums1, nums2, total / 2 + 1);
        } else {
            double a = findKthSmallestInSortedArrays(nums1, nums2, total / 2);
            double b = findKthSmallestInSortedArrays(nums1, nums2, total / 2 + 1);
            return (a + b) / 2;
        }
    }

    // Time: O(log(k)) <= O(log(m+n)), Space: O(1)
    public static double findKthSmallestInSortedArrays(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length, base1 = 0, base2 = 0;
        while (true) {
            if (len1 == 0) return nums2[base2 + k - 1];
            if (len2 == 0) return nums1[base1 + k - 1];
            if (k == 1) return Math.min(nums1[base1], nums2[base2]);

            int i = Math.min(k / 2, len1);
            int j = Math.min(k - i, len2);
            int a = nums1[base1 + i - 1], b = nums2[base2 + j - 1];

            if (i + j == k && a == b) return a;

            if (a <= b) {
                base1 += i;
                len1 -= i;
                k -= i;
            }
            if (a >= b) {
                base2 += j;
                len2 -= j;
                k -= j;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5};
        int[] nums2 = {6,7,8,9,0};
        double kthSmallestInSortedArrays = findKthSmallestInSortedArrays(nums1, nums2, 5);
        System.out.println(kthSmallestInSortedArrays);
    }
}