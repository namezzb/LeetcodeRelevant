package org.example.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRU {


    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1, 1);
        lru.put(2, 2);
        int i = lru.get(1);
        lru.put(3, 3);
        int i1 = lru.get(2);
        lru.put(4, 4);
        int i2 = lru.get(1);
        int i3 = lru.get(3);
        int i4 = lru.get(4);
        System.out.println();
        System.out.println("");
    }



    static class LRUCache {
        public LRUCache() {

        }
        class DListNode{
            int key;
            int val;
            DListNode prev;
            DListNode next;
            public DListNode(int key, int val){
                this.key = key;
                this.val = val;
            }
        }

        int capacity;
        int size;
        Map<Integer, DListNode> cache;
        DListNode begin;
        DListNode end;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.cache = new HashMap<>();
            this.begin = new DListNode(-1, -1);
            this.end = new DListNode(-2 , -2);
            begin.next = end;
            end.prev = begin;
        }

        public int get(int key) {
            DListNode node = cache.get(key);
            if(node == null){
                return -1;
            }
            moveTohead(node);
            return node.val;
        }

        public void put(int key, int value) {
            DListNode node = cache.get(key);
            if(node == null){
                DListNode newNode = new DListNode(key, value);
                if(size == capacity){
                    DListNode tail = removetail();
                    cache.remove(tail.key);
                    size--;
                }
                addToHead(newNode);
                cache.put(key, newNode);
                size++;
            }else{
                node.val = value;
                moveTohead(node);
            }
        }

        private void addToHead(DListNode node){
            node.prev = begin;
            node.next = begin.next;
            begin.next.prev = node;
            begin.next = node;
        }

        private void moveTohead(DListNode node){
            removeNode(node);
            addToHead(node);
        }

        private DListNode removetail(){
            DListNode tail = end.prev;
            removeNode(tail);
            return tail;
        }

        private void removeNode(DListNode node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

}
