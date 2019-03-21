package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2018/12/29
 */

public class 单身数字 {
//    这个题目说的是，给你一个非空的整数数组，这个数组中有一个整数只出现了一次，其它的整数都出现两次，你要找出这个只出现一次的整数。
//    比如说，给你的数组是：
//            5, 7, 5, 6, 6
//    这里 7 只出现了一次，因此你要返回的就是 7。

    //异或操作 x^x = 0   0^y = y
    public static int singleNumberWithXOR(int[] nums) {
        int result =0;
        for (int num : nums) result ^=num;
        return result;
    }

    //set操作
    public static int singleNumberWithSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0, uniqueSum = 0;
        for (int num : nums) {
            if (!set.contains(num)) {
                uniqueSum += num;
            }
            set.add(num);
            sum += num;

        }
        return uniqueSum * 2 -sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,6,5,6,7};
        int num = singleNumberWithXOR(nums);
        System.out.println(num);
    }
}