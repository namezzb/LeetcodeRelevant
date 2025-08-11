package org.example.LinkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LRUWithTTL {
    /* ====================== 节点定义 ====================== */
    private static class DLinkedNode {
        int key;
        int value;
        long expireAt;               // 过期时间戳
        DLinkedNode prev, next;
    }

    /* ====================== 核心字段 ====================== */
    private final Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int capacity;
    private int size;

    // 虚拟头尾节点，简化边界
    private DLinkedNode head, tail;

    // 过期优先队列：显式 Lambda 写法
    private final PriorityQueue<DLinkedNode> expireQ =
            new PriorityQueue<>((o1, o2) -> Long.compare(o1.expireAt, o2.expireAt));

    /* ====================== 构造器 ====================== */
    public LRUWithTTL(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    /* ====================== 公共 API ====================== */
    public int get(int key) {
        purgeExpired();              // 先全局清理
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;
        if (isExpired(node)) {       // 已过期
            removeNode(node);
            cache.remove(key);
            expireQ.remove(node);
            size--;
            return -1;
        }
        moveToHead(node);            // 更新 LRU
        return node.value;
    }

    public void put(int key, int value, int ttlMs) {
        purgeExpired();
        long now = System.currentTimeMillis();
        long expireAt = ttlMs <= 0 ? Long.MAX_VALUE : now + ttlMs;

        DLinkedNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            node.expireAt = expireAt;
            moveToHead(node);
            // 先删再加，保持堆正确
            expireQ.remove(node);
            expireQ.offer(node);
            return;
        }

        // 新节点
        if (size == capacity) {
            purgeExpired();          // 先清过期
            if (size == capacity) {  // 仍满，按 LRU 淘汰
                DLinkedNode last = popTail();
                cache.remove(last.key);
                expireQ.remove(last);
                size--;
            }
        }

        DLinkedNode newNode = new DLinkedNode();
        newNode.key = key;
        newNode.value = value;
        newNode.expireAt = expireAt;

        cache.put(key, newNode);
        addToHead(newNode);
        expireQ.offer(newNode);
        size++;
    }

    /* ====================== 内部工具 ====================== */
    private boolean isExpired(DLinkedNode node) {
        return node.expireAt <= System.currentTimeMillis();
    }

    private void purgeExpired() {
        long now = System.currentTimeMillis();
        while (!expireQ.isEmpty() && expireQ.peek().expireAt <= now) {
            DLinkedNode node = expireQ.poll();
            if (cache.get(node.key) == node) { // 未被删除
                removeNode(node);
                cache.remove(node.key);
                size--;
            }
        }
    }

    /* ---------- 双向链表工具 ---------- */
    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode popTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
