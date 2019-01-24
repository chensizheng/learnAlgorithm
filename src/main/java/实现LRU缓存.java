/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/1/22
 */

public class 实现LRU缓存 {
    /***
     * 问题
     * 这个题目说的是，你要实现一个 LRU 缓存，提供 get 和 put 两个操作，并且要求两个操作的时间复杂度都是 O(1)。另外为了简单起见，在这个题目中，key 和 value 都是整数值，并且 value 只为正整数。因此在 get 操作中，当 key 不存在时，返回 -1 即可。
     */

    //基于双向链表+hashMap
    public class LRUCache {

        private class Node {
            int key, val;
            Node prev, next;

            Node(int key, int val, Node prev, Node next) {
                this.key = key;
                this.val = val;
                this.prev = prev;
                this.next = next;
            }
        }

        private Node head = new Node(-1, -1, null, null);
        private Map<Integer, Node> map = new HashMap<>();

        private void move2Head(Node cur) {
            if (cur == head) {
                head = head.prev;
                return;
            }
            // detach
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            // attach
            cur.next = head.next;
            cur.next.prev = cur;
            head.next = cur;
            cur.prev = head;
        }

        public LRUCache(int capacity) {
            Node cur = head;
            for (int i = 0; i < capacity-1; ++i) {
                cur.next = new Node(-1, -1, cur, null);
                cur = cur.next;
            }
            cur.next = head;
            head.prev = cur;
        }

        //get到的元素要移动到head
        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            Node cur = map.get(key);
            move2Head(cur);
            return cur.val;
        }


        //每次put head都要逆时针移动
        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node cur = map.get(key);
                cur.val = value;
                move2Head(cur);
            } else {
                if (head.val != -1) map.remove(head.key);
                head.key = key;
                head.val = value;
                map.put(key, head);
                head = head.prev;
            }
        }
    }

}