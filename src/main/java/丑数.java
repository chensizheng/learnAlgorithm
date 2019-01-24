/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/23
 */

public class 丑数 {
    /***
     * 问题
     * 这个题目说的是，给你一个数字，你要判断它是不是一个丑数。丑数的定义是质因数只包含 2，3，5 的正整数。另外，1 作为特例，也定义为丑数。
     *
     * 比如说给你的数字是 45，45 做质因数分解，可以写成：
     *
     * 45 = 3 x 3 x 5
     *
     * 不包含 2，3，5 以外的质因数，因此它是一个丑数。
     *
     * 再比如说 42，它做质因数分解得到：
     *
     * 42 = 2 x 3 x 7
     *
     * 7 不在 2，3，5 中，因此 42 不是丑数。
     */

    // Time: O(m+n+l), Space: O(1)
    public boolean isUglyNumber(int num) {
        if (num <= 0) return false;
        while(num % 2 == 0) num /= 2;
        while(num % 3 == 0) num /= 3;
        while(num % 5 == 0) num /= 5;
        return num == 1;
    }


}