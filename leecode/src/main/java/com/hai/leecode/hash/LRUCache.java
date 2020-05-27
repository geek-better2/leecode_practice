package com.hai.leecode.hash;

import java.util.HashMap;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 *  
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * 示例：
 * LRUCache cache = new LRUCache( 2);
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 * <p>
 *
 * @author hai
 * @date 2020-05-25 10:53
 */
public class LRUCache {

    private int size;
    private int capacity;
    private HashMap<Integer, LinkedNode> cache = new HashMap<>();
    private LinkedNode head = new LinkedNode(-2, -2);
    private LinkedNode tail = new LinkedNode(-3, -3);

    private class LinkedNode {
        int key;
        int value;
        LinkedNode prev;
        LinkedNode next;

        LinkedNode() {
        }

        LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;


    }

    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        removeToHead(node);
        return node.value;


    }

    private void removeToHead(LinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(LinkedNode node) {
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
        node.prev = head;

    }

    private void removeNode(LinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            LinkedNode newNode = new LinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                LinkedNode temp = tail.prev;
                removeNode(temp);
                cache.remove(temp.key);
                size--;
            }
        } else {
            node.value = value;
            removeToHead(node);
        }

    }

    public static void main(String[] args) {
        LRUCache instance = new LRUCache(2);
        instance.put(1, 1);
        instance.put(2, 2);
        int a = instance.get(1);
        System.out.println(a);
        instance.put(3, 3);
        System.out.println(instance.get(2));
        System.out.println(instance.get(3));
        instance.put(4, 4);
        System.out.println(instance.get(1));


    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
