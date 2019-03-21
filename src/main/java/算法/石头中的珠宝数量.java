package 算法;/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/15
 */

public class 石头中的珠宝数量 {
    // Time: O(m*n), Space: O(1)
    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null || J.length() == 0 || S.length() == 0)
            return 0;
        int cnt = 0;
        for (int i = 0; i < J.length(); ++i)
            for (int j = 0; j < S.length(); ++j)
                if (J.charAt(i) == S.charAt(j))
                    ++cnt;
        return cnt;
    }

    // Time: O(m+n), Space: O(k)
    public int numJewelsInStonesHashMap(String J, String S) {
        if (J == null || S == null || J.length() == 0 || S.length() == 0)
            return 0;
        boolean[] d = new boolean[256];
        int cnt = 0;
        for (int i = 0; i < J.length(); ++i)
            d[J.charAt(i)] = true;
        for (int i = 0; i < S.length(); ++i)
            if (d[S.charAt(i)]) ++cnt;
        return cnt;
    }

}