package org.example.LinkedList;

import org.example.MultiThread.TestSemaphore;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    static class LRUCache {
        private int capacity;
        private int size;
        private Map<Integer, DLinkedNode> cache = new HashMap<>();
        class DLinkedNode{
            private int key;
            private int value;
            DLinkedNode prev;
            DLinkedNode next;
            public DLinkedNode(){}
            public DLinkedNode(int _key, int _value){
                key = _key;
                value = _value;
            }
        }
        private DLinkedNode head;
        private DLinkedNode tail;
        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.head = new DLinkedNode();
            this.tail = new DLinkedNode();
            this.head.next = tail;
            this.tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if(node == null){
                return -1;
            }
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if(node == null){
                DLinkedNode new_node = new DLinkedNode(key, value);
                addToHead(new_node);
                cache.put(key, new_node);
                size++;
                if(size > capacity){
                    DLinkedNode tail = removeTail();
                    size--;
                    cache.remove(tail.key);
                }
            }else{
                node.value = value;
                moveToHead(node);
            }
        }

        public void moveToHead(DLinkedNode node){
            removeNode(node);
            addToHead(node);
        }
        public void addToHead(DLinkedNode node){
            DLinkedNode head_next = head.next;
            head.next = node;
            node.prev = head;
            node.next = head_next;
            head_next.prev = node;
        }
        public void removeNode(DLinkedNode node){
            DLinkedNode left = node.prev;
            DLinkedNode right = node.next;
            left.next = node.next;
            right.prev = node.prev;
        }
        public DLinkedNode removeTail(){
            DLinkedNode temp = tail.prev;
            removeNode(temp);
            return temp;
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }
}
