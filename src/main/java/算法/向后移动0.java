package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/29
 */

public class 向后移动0 {

    /***
     * 问题
     * 这个题目说的是，给你一个整数数组，你要把数组中的 0 都移动到数组末端，同时还要保持非 0 元素的相对位置不变。另外，操作直接在原数组上进行即可。
     *
     * 比如说，给你的数组是：
     *
     * 0, 1, 2, 0, 4
     *
     * 把 0 都移动到数组末端，得到的数组是：
     *
     * 1, 2, 4, 0, 0
     *
     * 注意，这里 1,2,4 保持了它们在原来数组中的相对顺序。
     */

    // Time: O(n), Space: O(1)
    public void moveZeroesAssign(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int slow = 0;
        for (int fast = 0; fast < nums.length; ++fast) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                ++slow;
            }
        }
        for (int i = slow; i < nums.length; ++i)
            nums[i] = 0;
    }

    // Time: O(n), Space: O(1)
    public void moveZeroesSwap(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int slow = 0;
        for (int fast = 0; fast < nums.length; ++fast) {
            if (nums[fast] != 0) {
                int tmp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = tmp;
                ++slow;
            }
        }
    }


}