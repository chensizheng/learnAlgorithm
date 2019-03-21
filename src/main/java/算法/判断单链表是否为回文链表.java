package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

import java.util.Stack;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/21
 */

public class 判断单链表是否为回文链表 {
    /***
     * 问题
     * 这个题目说的是，给你一个单链表表示的数，你要判断它是不是一个回文数字。回文数字就是正着读和反着读都相同的数字。
     *
     * 比如说，给你的链表是：
     *
     * 4 -> 2
     *
     * 它表示 42，反过来是 24，不是一个回文数字，因此你要返回 false。
     *
     * 再比如说，给你的链表是：
     *
     * 4 -> 2 -> 2 -> 4
     *
     * 它表示 4224，反过来也是 4224，它是一个回文数字，因此你要返回 true。
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    // Time: O(n), Space: O(n)
    public boolean isPalindromeUsingStack(ListNode head) {
        Stack<Integer> s = new Stack<>();
        for (ListNode p = head; p != null; p = p.next)
            s.push(p.val);

        for (ListNode p = head; p != null; p = p.next)
            if (p.val != s.pop())
                return false;

        return true;
    }

    // Time: O(n), Space: O(1)
    //翻转一半列表
    public boolean isPalindromeReverseList(ListNode head) {
        int len = 0;
        for(ListNode p = head;p!=null;++len);

        ListNode cur = head, pre = null;

        for (int i = 0; i < len / 2; ++i) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        if (len % 2 == 1) cur = cur.next;
        for (; pre != null && cur != null; pre = pre.next, cur = cur.next) {
            if (pre.val != cur.val) return false;
        }
        return true;
    }

}