/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/21
 */

public class 数组的全排列 {
    /***
     * 问题
     * 这个题目说的是，给你一个整数数组，并且数组中没有重复元素，你要返回这个数组所有可能的排列。
     *
     * 比如说给你的数组是：
     *
     * 0, 1, 2
     *
     * 你要返回的所有排列是：
     *
     * 0, 1, 2
     * 0, 2, 1
     * 1, 0, 2
     * 1, 2, 0
     * 2, 0, 1
     * 2, 1, 0
     */

    //递归求数组中的所有元素都固定在当前nums第一个，然后求第二个位置开始的子数组排列
    void permuteRec(List<Integer> nums, int start, List<List<Integer>> result) {
        if (start == nums.size()) {
            result.add(new ArrayList<>(nums));
        } else {
            for (int i = start; i < nums.size(); ++i) {
                Collections.swap(nums, i, start);
                permuteRec(nums, start + 1, result);
                Collections.swap(nums, i, start);
            }
        }
    }

    // Time: O(n*n!), Space: O(n)
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        for (int num: nums) list.add(num);

        permuteRec(list, 0, result);
        return result;
    }

}