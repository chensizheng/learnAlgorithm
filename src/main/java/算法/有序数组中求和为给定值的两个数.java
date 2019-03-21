package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2018/12/27
 */

public class 有序数组中求和为给定值的两个数 {
    public static int[] getTwoNumSumToGivenValueHashMap(int[] nums,int target){
        int i=0,j=nums.length-1;
        while (i<j){
            if(nums[i]+nums[j]>target) --j;
            else if(nums[i]+nums[j]<target) ++i;
            else return new int[]{i+1,j+1};
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 6, 8, 11};
        int[] result = getTwoNumSumToGivenValueHashMap(nums, 10);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}