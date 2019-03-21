package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2018/12/27
 */

public class 不用加减求两数之和 {
    public static int getSumRecursive(int a,int b){
        return b == 0?a:getSumRecursive(a^b,(a&b)<<1);
    }

    public static void main(String[] args) {
        System.out.println(getSumRecursive(9,11));
    }

}