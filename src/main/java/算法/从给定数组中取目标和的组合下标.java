package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2018/12/27
 */

public class 从给定数组中取目标和的组合下标 {

    //在map中存储key=nunm value = num的下标
    public int[] getTwoNumSumToGivenValueHashMap(int[] nums,int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int needNum = target - nums[i];
            if(map.containsKey(needNum)){
                return new int[]{map.get(needNum),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}