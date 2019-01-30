/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/30
 */

public class 荷兰国旗问题 {
    /***
     * 问题
     * 这个题目说的是，给你一些红色/白色/蓝色的条状物，你要排序把相同颜色的放在一起，并且整体的颜色是按照红/白/蓝的顺序排列的。这三种颜色放在一起后就形成了荷兰国旗。
     *
     * 维基百科链接：Dutch national flag problem
     *
     * 比如说，我们用 0, 1, 2 表示红/白/蓝三种颜色，给你一个包含 0, 1, 2 的整数数组：
     *
     * 2, 1, 2, 1, 0
     *
     * 你要返回排序后的结果是：
     *
     * 0, 1, 1, 2, 2
     */

    // Time: O(n), Space: O(1)  计算数量 重新填充数组
    public void sortThreeColorsCount(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for (int num: nums) {
            if (num == 0) ++cnt0;
            else if (num == 1) ++cnt1;
            else ++cnt2;
        }
        int k = 0;
        for (int i = 0; i < cnt0; ++i) nums[k++] = 0;
        for (int i = 0; i < cnt1; ++i) nums[k++] = 1;
        for (int i = 0; i < cnt2; ++i) nums[k++] = 2;
    }


    // Time: O(n), Space: O(1)
    public void sortThreeColorsSwap(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int left = 0, mid = 0, right = nums.length - 1;
        while (mid <= right) {
            if (nums[mid] == 0) swap(nums, left++, mid++);
            else if (nums[mid] == 1) ++mid;
            else swap(nums, mid, right--);
        }
    }

    private void swap(int[] nums, int i , int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }



}