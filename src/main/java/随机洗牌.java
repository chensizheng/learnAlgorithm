/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

import java.util.Random;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/25
 */

public class 随机洗牌 {
    private Random rnd = new Random();

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // Time: O(n), Space: O(1)
    public int[] shuffle(int[] nums) {
        for (int i = nums.length - 1; i > 0; --i) {
            int j = rnd.nextInt(i+1);
            swap(nums, i, j);
        }
        return nums;
    }



}