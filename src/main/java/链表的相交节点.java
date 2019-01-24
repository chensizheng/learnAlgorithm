/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/24
 */

public class 链表的相交节点 {
    /***
     * 问题
     * 这个题目说的是，给你两个单链表，你要找到它们相交的第一个节点。
     * 如果两个链表没有相交，则返回空指针。假设链表无环，并且你不能改变它的原始结构。
     * 另外要求算法是线性时间复杂度，空间复杂度要求是 O(1)。
     *
     * 比如说，两条链表分别是：
     *
     * A:     1 -> 2
     *               \
     *                6 -> 7 -> null
     *               /
     * B: 3 -> 4 -> 5
     *
     * 你要返回的是 6 这个节点。
     */


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    // Time: O(m+n), Space: O(1)
    //先去两个链表的长度，长的先走差值
    public ListNode getIntersectionNodeWithLen(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        for (ListNode p = headA; p != null; p = p.next, ++lenA);
        for (ListNode p = headB; p != null; p = p.next, ++lenB);
        ListNode p = headA, q = headB;
        if (lenA > lenB)
            for (int i = 0; i < lenA - lenB; ++i) p = p.next;
        else
            for (int i = 0; i < lenB - lenA; ++i) q = q.next;
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }

    // Time: O(m+n), Space: O(1)
    //一起走，走到头后换头，直到相等
    public ListNode getIntersectionNodeWithoutLen(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode p = headA, q = headB;
        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }
}