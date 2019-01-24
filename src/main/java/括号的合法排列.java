/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/23
 */

public class 括号的合法排列 {

    /***
     * 问题
     * 这个题目说的是，给你 n 对括号，你要返回这 n 对括号的所有合法排列方式。
     *
     * 比如说，n 等于 3 时，合法的排列有 5 个：
     *
     *  ((()))
     *  (()())
     *  (())()
     *  ()(())
     *  ()()()
     */
    //任何时候写'('都是合法的,只有'('的数量>')'的数量时，写')'才合法
    //result= 结果集 str=当前结果 left=左括号数量  right=又括号数量
    private void generate(List<String> result, String str, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(str);
        } else {
            if (left > 0) generate(result, str + '(', left - 1, right);
            if (right > left) generate(result, str + ')', left, right - 1);
        }
    }

    // Time: O(4^n / sqrt(n)), Space: O(n)
    public List<String> generateParentheses(int n) {
        if (n <= 0) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        generate(result, "", n, n);
        return result;
    }



    //用 卡特兰数 解决
    // Time: O(4^n / n*sqrt(n)), Space: O(4^n / n*sqrt(n))
    public List<String> generateParenthesesDP(int n) {
        if (n <= 0) return new ArrayList<>();
        List<List<String>> d = new ArrayList<>(n+1);
        for (int i = 0; i < n+1; ++i) d.add(new ArrayList<>());
        d.get(0).add("");
        for (int i = 1; i < n+1; ++i)
            for (int j = 0; j < i; ++j)
                for (String left: d.get(j))
                    for (String right: d.get(i-j-1))
                        d.get(i).add('(' + left + ')' + right);

        return d.get(n);
    }
}