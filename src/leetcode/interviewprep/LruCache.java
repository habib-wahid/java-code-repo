package leetcode.interviewprep;

import java.util.HashMap;

public class LruCache {

    static class CacheNode {
        int key, val;
        CacheNode next;
        CacheNode prev;

        public CacheNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    int capacity;
    HashMap<Integer, CacheNode> map;
    CacheNode head;
    CacheNode tail;

    public LruCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new CacheNode(-1, -1);
        tail = new CacheNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        CacheNode node = map.get(key);
        remove(node);
        insertNode(node);

        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            CacheNode node = map.get(key);
            node.val = value;
            remove(node);
            insertNode(node);
        } else {
            if (map.size() == capacity) {
                CacheNode lru = head.next;
                remove(lru);
                map.remove(lru.key);
            }

            CacheNode newNode = new CacheNode(key, value);
            insertNode(newNode);
            map.put(key, newNode);
        }
    }

    public void remove(CacheNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertNode(CacheNode node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    public static void main(String[] args) {

    }
}
