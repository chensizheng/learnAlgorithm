/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/3
 */

public class 二进制中1的个数 {

    public int numberOfOneWithMask(int n) {
        int mask=1,count=0;
        while(mask != 0){
            if((n & mask) != 0) count++;
            mask <<= 1;
        }
        return count;
    }

    public int numberOfOne(int n) {
        int count =0;
        while (n!=0){
            count++;
            n &= (n-1);
        }
        return count;
    }
}