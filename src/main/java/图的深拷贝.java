/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/15
 */

public class 图的深拷贝 {

    public class UndirectedGraphNode{
        int val;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            val = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    //深度优先算法
    //辅助map用于存储原图和copy图的节点对应关系
    private Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node==null) return null;
        UndirectedGraphNode copy = new UndirectedGraphNode(node.val);
        map.put(node,copy);
        for (UndirectedGraphNode n : node.neighbors) {
            //如果当前节点在map中，则copy增加节点，否则继续遍历
            if(map.containsKey(n)) copy.neighbors.add(map.get(n));
            else  copy.neighbors.add(cloneGraph(n));
        }
        return copy;
    }


    }