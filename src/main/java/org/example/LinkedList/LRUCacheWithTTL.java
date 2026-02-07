package org.example.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheWithTTL {

    // 双向链表节点
    class Node {
        int key;
        int value;
        long expireTime;  // 过期时间戳（毫秒）
        Node prev;
        Node next;

        Node() {}

        Node(int key, int value, long ttlMillis) {
            this.key = key;
            this.value = value;
            // 当前时间 + TTL = 过期时间
            this.expireTime = System.currentTimeMillis() + ttlMillis;
        }

        // 检查是否过期
        boolean isExpired() {
            return System.currentTimeMillis() > expireTime;
        }
    }

    private int capacity;
    private int size;
    private Map<Integer, Node> cache;
    private Node head;  // 虚拟头节点
    private Node tail;  // 虚拟尾节点

    public LRUCacheWithTTL(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cache = new HashMap<>();

        // 初始化双向链表
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 获取值
     * @return 值，如果不存在或已过期返回 -1
     */
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }

        // 检查是否过期
        if (node.isExpired()) {
            // 过期了，删除节点
            removeNode(node);
            cache.remove(key);
            size--;
            return -1;
        }

        // 未过期，移动到头部（最近使用）
        moveToHead(node);
        return node.value;
    }

    /**
     * 插入/更新键值对
     * @param ttlSeconds 过期时间（秒）
     */
    public void put(int key, int value, int ttlSeconds) {
        long ttlMillis = ttlSeconds * 1000L;
        Node node = cache.get(key);

        if (node != null) {
            // key 已存在，更新值和过期时间
            node.value = value;
            node.expireTime = System.currentTimeMillis() + ttlMillis;
            moveToHead(node);
        } else {
            // key 不存在，创建新节点
            Node newNode = new Node(key, value, ttlMillis);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;

            // 超出容量，删除最久未使用的
            if (size > capacity) {
                Node removed = removeTail();
                cache.remove(removed.key);
                size--;
            }
        }
    }

    /**
     * 重载：不带 TTL 的 put（永不过期）
     */
    public void put(int key, int value) {
        put(key, value, Integer.MAX_VALUE / 1000);
    }

    // ============ 双向链表操作 ============

    // 添加到头部
    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // 删除节点
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 移动到头部
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    // 删除尾部节点（最久未使用）
    private Node removeTail() {
        Node removed = tail.prev;
        removeNode(removed);
        return removed;
    }

    // ============ 可选：主动清理过期数据 ============

    /**
     * 清理所有过期数据
     */
    public void cleanExpired() {
        Node current = head.next;
        while (current != tail) {
            Node next = current.next;
            if (current.isExpired()) {
                removeNode(current);
                cache.remove(current.key);
                size--;
            }
            current = next;
        }
    }

    /**
     * 获取当前有效缓存大小
     */
    public int size() {
        return size;
    }

    // ============ 测试 ============

    public static void main(String[] args) throws InterruptedException {
        LRUCacheWithTTL cache = new LRUCacheWithTTL(3);

        // 测试基本功能
        cache.put(1, 100, 2);  // 2秒后过期
        cache.put(2, 200, 5);  // 5秒后过期
        cache.put(3, 300, 10); // 10秒后过期

        System.out.println("get(1): " + cache.get(1));  // 100
        System.out.println("get(2): " + cache.get(2));  // 200

        // 等待 3 秒
        System.out.println("\n等待 3 秒...");
        Thread.sleep(3000);

        System.out.println("get(1): " + cache.get(1));  // -1（已过期）
        System.out.println("get(2): " + cache.get(2));  // 200（未过期）
        System.out.println("get(3): " + cache.get(3));  // 300（未过期）

        // 测试 LRU 淘汰
        cache.put(4, 400, 10);
        cache.put(5, 500, 10);

        System.out.println("\n添加新元素后：");
        System.out.println("get(2): " + cache.get(2));  // 可能被淘汰
        System.out.println("get(4): " + cache.get(4));  // 400
        System.out.println("get(5): " + cache.get(5));  // 500
    }
}