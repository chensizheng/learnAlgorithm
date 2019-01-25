/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/25
 */

public class 字符串转整数 {
    /***
     * 问题
     * 这个题目说的是，给你一个字符串，你要把它转成一个 int 类型的数字。这个字符串里可能会包含空格，字母或是其它字符。
     *
     * 一个可以有效地转成数字的字符串包含以下特点：
     *
     * 1. 可以有前导空格或前导 0，但不能有其它前导字符
     * 2. 可能会有一个加号或减号表示正负，也可能没有，连续的多个加号或减号则视为不合法
     * 3. 紧接着是一段连续的数字，如果没有数字则示为不合法
     * 4. 数字后的其它字符都可以忽略
     * 5. 如果数字大于 int 的最大值或小于 int 的最小值，返回相应的极值即可
     * 6. 字符串如果不能合法地转为整数，则返回 0
     */

    public int string2Integer(String str) {
        //起始，游标，字符串长度
        int start = 0, p = 0, n = str.length();
        boolean negative = false;
        while (p<n && str.charAt(p) == ' ') ++p; //去除前导空格
        if(p == n) return 0;//全是空格或者为空

        if (str.charAt(p) == '+'){
            ++p;
        }else if(str.charAt(p) == '-'){
            ++p;
            negative = true;
        }

        while (p<n && str.charAt(p) == '0') ++p; //去除前导0

        start = p;

        while (p<n && str.charAt(p) >= '0'  && str.charAt(p) <= '9')++p; //扫过所有数字
        if (p == start) return 0;  //不包含数字

        if (p - start > 10) { //超过了int最大值
            if (negative) return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }

        long num = 0;
        for (int i = start; i < p; ++i)
            num = num * 10 + (str.charAt(i) - '0');
        num = negative ? -num : num;

        if (num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else return (int)num;

    }


}