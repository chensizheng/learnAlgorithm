package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/24
 */

public class 数组中超过一半的数字 {
    /***
     * 问题
     * 这个题目说的是，给你一个数组，里面有一个数字出现的次数超过了一半，你要找到这个数字并返回。
     *
     * 比如说，给你的数组是
     *
     * 1, 3, 3, 1, 3, 1, 1
     *
     * 这个数组的长度是 7，这里我们只考虑整数除法，长度 7 除以 2 是 3。数组里面 1 出现了 4 次，超过了一半的数量 3，因此你要返回的就是 1。
     */

    // Time: O(n), Space: O(n)
    public int getMajorityWithHashMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxNum = 0, maxCount = 0;
        for (int num: nums) {
            int newCnt = map.getOrDefault(num, 0) + 1;
            map.put(num, newCnt);
            if (newCnt > maxCount) {
                maxCount = newCnt;
                maxNum = num;
            }
        }
        return maxNum;
    }

    //摩尔投票算法
    // Time: O(n), Space: O(1)
    public int getMajority(int[] nums) {
        int num = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (count == 0) {
                num = nums[i];
                count = 1;
            } else if (nums[i] == num) {
                ++count;
            } else --count;
        }
        return num;
    }

}