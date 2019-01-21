/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/21
 */

public class 翻转单列表 {
    /***
     * 问题
     * 这个题目说的是，给你一个单链表，你需要反转它，然后返回。
     *
     * 比如说给你的单链表是：
     *
     * 1 -> 2 -> 3 -> 4 -> 5 -> null
     *
     * 你要返回的反转后的链表是：
     *
     * 5 -> 4 -> 3 -> 2 -> 1 -> null
     */

    public class AlgoCasts {

        public class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
            }
        }

        // Time: O(n), Space: O(1)
        public ListNode reverseList(ListNode head) {
            ListNode cur = head, pre = null;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }

    }

}