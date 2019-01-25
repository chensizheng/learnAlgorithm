/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

import java.util.Stack;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/25
 */

public class 有效的括号序列 {
    /***
     * 问题
     * 这个题目说的是，给你一个括号序列，里面包含小括号，中括号和大括号。你要判断这个括号序列是否有效。有效的括号序列要求，每个左括号都必须有一个同类的右括号与它正确配对。另外，空字符串认为是有效的括号序列。
     *
     * 比如说，给你的序列是：
     *
     * ()[]{}
     *
     * 小括号/中括号/大括号的左右括号都能正确配对，因此这是一个有效的括号序列。
     *
     * 再比如说给你的序列是：
     *
     * ([)]
     *
     * 这里面虽然正好有一对小括号和一对中括号，但它们的顺序不对，括号间无法正确配对，因此这不是一个有效的括号序列。
     */


    // Time: O(n), Space: O(n)
    //辅助栈
    public boolean isValidBrackets(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (stack.isEmpty()) {
                return false;
            } else {
                if (s.charAt(i) == ')' && stack.peek() != '(') return false;
                if (s.charAt(i) == ']' && stack.peek() != '[') return false;
                if (s.charAt(i) == '}' && stack.peek() != '{') return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }



    // Time: O(n), Space: O(n)
    //优化版 读到左库尔好，直接入栈对应的右括号
    public boolean isValidBracketsShort(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') stack.push(')');
            else if (s.charAt(i) == '[') stack.push(']');
            else if (s.charAt(i) == '{') stack.push('}');
            else if (stack.isEmpty() || s.charAt(i) != stack.pop()) return false;
        }
        return stack.isEmpty();
    }


}