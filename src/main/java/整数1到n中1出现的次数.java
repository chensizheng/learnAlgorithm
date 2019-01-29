/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/29
 */

public class 整数1到n中1出现的次数 {
    /***
     * 问题
     * 这个题目说的是，给你一个整数 n，你要计算出 1 到 n 这 n 个整数中，数字 1 出现的次数。
     *
     * 比如说，给你的整数 n 等于 12：
     *
     * n = 12
     *
     * 1 到 12 中包含数字 1 的整数有：
     *
     * 1, 10, 11, 12
     *
     * 这里面数字 1 出现了 5 次，因此你要返回 5。
     */
    // Time: O(n*log10(n)), Space: O(1)
    public int countDigitOneBruteForce(int n) {
        if(n<1) return 0;
        int count = 0;
        for(int i=1;i<n;i++){
            int num =i;
            while (num !=0){
                if(num % 10 ==1) count++;
                num = num / 10;
            }
        }
        return count;
    }

    // Time: O(log10(n)), Space: O(1)
    public int countDigitOneMath(int n) {
        if(n<1) return 0;
        long count=0,factor = 1;
        while (n/factor !=0){
            long digit = (n/factor)%10;
            long high = n/(factor *10);
            if(digit == 0 ){
                count += high * factor;
            }else if(digit == 1){
                count += high * factor;
                count += (n%factor)+1;
            }else {
                count += (high+1) * factor;
            }
            factor = factor *10;
        }
        return (int)count;
    }


}