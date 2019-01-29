/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

import java.util.*;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/29
 */

public class 寻找天际线 {
    /***
     * 问题
     * 这个题目说的是，给你一组矩形表示的楼房，它们的底边在同一水平线上，
     * 并且楼房之间可以相邻，也可以重叠。你要找到这组楼房的轮廓线或者叫天际线，并返回这个轮廓线的关键点。
     */

    // n 是矩形数量
    // Time: O(n^2), Space: O(n)
    // Every element of buildings is (leftXCoordinate, rightXCoordinate, height)
    public List<int[]> skylineKeyPointsMaxHeap(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] b: buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        height.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        // 使用 reverseOrder 来使优先队列作为最大堆
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        int preHeight = 0;
        for (int[] h: height) {
            if (h[1] < 0) pq.add(-h[1]); // start point of rectangle
            else pq.remove(h[1]); // T: O(n), end point of rectangle

            if (pq.peek() != preHeight) {
                result.add(new int[]{h[0], pq.peek()});
                preHeight = pq.peek();
            }
        }
        return result;
    }

    // TreeMap 的实现是红黑树，也就是一棵自平衡的排序二叉树
    // 使用 TreeMap 做优化, 时间复杂度降到 O(nlogn)
    // Time: O(nlog(n)), Space: O(n)
    public List<int[]> skylineKeyPointsTreeMap(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] b: buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        height.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        TreeMap<Integer, Integer> heightMap = new TreeMap<>();
        heightMap.put(0, 1);
        int prevHeight = 0;
        for (int[] h: height) {
            if (h[1] < 0) {
                // 这里和使用最大堆不同，TreeMap 中每个元素是一对 (key, value)，并按 key 排序
                // 如果直接把高度值（height, 1）加入 TreeMap，会导致多个相同的高度值互相覆盖，从而出错。
                // 因此这里要把相同的高度值的计数也保存下来，在遇到矩形结束时，只有在当前高度值只剩 1 个，才 remove
                Integer cnt = heightMap.get(-h[1]);
                cnt = (cnt == null) ? 1 : cnt + 1;
                heightMap.put(-h[1], cnt);
            } else {
                // 在遇到矩形结束时，只有在当前高度值只剩 1 个，才 remove
                Integer cnt = heightMap.get(h[1]);
                if (cnt == 1) {
                    heightMap.remove(h[1]); // Time: O(log(n))
                } else {
                    heightMap.put(h[1], cnt - 1);
                }
            }
            // 由于是从小到大排序,所以最大值在 lastKey
            // Time: O(log(n))
            int currHeight = heightMap.lastKey();
            if (prevHeight != currHeight) {
                result.add(new int[]{h[0], currHeight});
                prevHeight = currHeight;
            }
        }
        return result;
    }

}