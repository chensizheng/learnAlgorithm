/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

import java.util.Stack;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/21
 */

public class 带有min函数的栈 {
    /***
     * 问题
     * 这个题目说的是，你要实现一个栈，除了提供 push，pop，top 等常用函数，还需要提供一个函数在 O(1) 时间内取得这个栈里的最小元素。
     */

    class MinStackWithTwoStack {

        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> min = new Stack<>();

        public void push(int x) {
            stack.push(x);
            if(min.isEmpty()||x<=min.peek()) min.push(x);

        }

        public void pop() {
            if(stack.peek() == getMin())min.pop();
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return  min.peek();
        }
    }

    //出栈时，若head节点和min相同，则head的上一节点，就是下一个最小值，更新min，head前移2
    class MinStackWithLinkedList {

        private class Node {
            int val;
            Node next;

            Node(int val, Node next) {
                this.val = val;
                this.next = next;
            }
        }

        private Node head = null;
        private int min = Integer.MAX_VALUE;

        public void push(int x) {
            if(x<=min){
                head = new Node(min,head);
                min = x;
            }
        }

        public void pop() {
            if(head.val == min){
                min = head.next.val;
                head = head.next.next;
            }else{
                head = head.next;
            }
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return min;
        }
    }
}