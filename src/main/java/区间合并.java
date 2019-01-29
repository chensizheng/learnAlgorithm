/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/29
 */

public class 区间合并 {
    /***
     * 问题
     * 这个题目说的是，给你一个区间集合，你要把有重叠的区间合并起来。
     *
     * 比如说，给你的区间集合是：
     *
     * [1, 8]
     * [2, 4]
     * [9, 10]
     * [10, 16]
     *
     * 这 4 个区间里，[1, 8] 区间包含了 [2, 4] 区间，于是它们合并后是 [1, 8]。
     *
     * [9, 10] 区间和 [10, 16] 区间相邻，合并起来后是 [9, 16]。最后得到合并后的区间有两个：
     *
     * [1, 8]
     * [9, 16]
     */

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    // Time: O(n*log(n)), Space: O(1)
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        intervals.sort((a, b) -> a.start - b.start);

        for (Interval in: intervals) {
            int n = result.size();
            if (result.isEmpty() || result.get(n-1).end < in.start) {
                result.add(in);
            } else {
                result.get(n-1).end = Math.max(result.get(n-1).end, in.end);
            }
        }
        return result;
    }


}