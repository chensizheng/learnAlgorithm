package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/24
 */

public class 判断单链表是否有环 {
    /***
     * 问题
     * 这个题目说的是，给你一个单链表，你要判断它是否会形成环，也就是链表的最后一个节点指向了前面一个已经存在的节点。
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // Time: O(n), Space: O(n)
    public boolean hasCycleWithHashSet(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        for (ListNode p = head; p != null; p = p.next) {
            if (set.contains(p)) return true;
            set.add(p);
        }
        return false;
    }

    // Time: O(n), Space: O(1)
    //快指针走两步 慢指针走一步
    public boolean hasCycleWithTwoPointer(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

}