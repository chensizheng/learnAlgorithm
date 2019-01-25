/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/25
 */

public class 求两个单链表之和 {
    /***
     * 问题
     * 这个题目说的是，给你两个非空的单链表，它们代表两个非负整数，并且逆序表示。你要将这两个数求和，并将结果以链表形式返回。你不需要考虑前导 0 这种情况，也就说 3 不会表示成 003 这样子。
     *
     * 比如说给你的两个链接表是：
     *
     * 1 -> 2 -> 3
     * 6 -> 7 -> 8 -> 9
     *
     * 1 -> 2 -> 3 表示的整数是 321，6 -> 7 -> 8 -> 9 表示的整数是 9876。我们需要输出的是它们求和后的链表：
     *
     * 7 -> 9 -> 1 -> 0 -> 1
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    // Time: O(max(m, n)), Space: O(max(m, n))
    public ListNode addTwoLinkedListNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0),p=dummy;
        int carry=0; //进位
        while (l1 !=null || l2!=null || carry !=0){
            int sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(sum % 10);
            p = p.next;
            carry = sum / 10;
        }
        return dummy.next;

    }

}