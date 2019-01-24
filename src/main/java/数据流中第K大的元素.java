/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/23
 */

public class 数据流中第K大的元素 {

    /***
     * 问题
     * 这个题目说的是，你要实现一个类，用来求数据流中第 K 大的元素。你需要实现这个类中的两个函数。第一个是构造函数，它接收一个整数数组以及一个整数 K，整数数组作为初始数据流。第二个是 add 函数，接收一个整数表示新流入的数据，然后返回当前第 K 大的元素。
     *
     * 比如说，给你的 K 是 3，初始的数组是：
     *
     * 1, 5, 2, 8
     *
     * 这时假如调用 add 函数增加一个数字 9，数据流变成：
     *
     * 1, 5, 2, 8, 9
     *
     * 你要返回第 3 大的元素是 5。
     *
     * 假如再调用 add 函数增加一个数字 0，数据流变成：
     *
     * 1, 5, 2, 8, 9, 0
     *
     * 这时你要返回的第 3 大元素仍然是 5。
     */

    public class KthLargestElementInStream {

        private Queue<Integer> minHeap = new PriorityQueue<>();
        private int k;

        // Time: O(n*log(k))
        public KthLargestElementInStream(int k, int[] nums) {
            this.k = k;
            for (int num: nums) add(num);
        }

        // Time: O(log(k))
        public int add(int val) {
            if (minHeap.size() < k) {
                minHeap.add(val);
            } else if (val > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(val);
            }
            return minHeap.peek();
        }
    }
}