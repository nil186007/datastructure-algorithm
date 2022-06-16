package com.nilesh.practice.frequecy;

import java.util.HashMap;

public class LRUCache {

    class DoubleLinkListNode {
        int key;
        int value;
        DoubleLinkListNode next;
        DoubleLinkListNode prev;
    }

    DoubleLinkListNode head;
    DoubleLinkListNode tail;

    int capacity;
    int currentSize;

    HashMap<Integer, DoubleLinkListNode> keyToNode = new HashMap<>();

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new DoubleLinkListNode();
        this.tail = new DoubleLinkListNode();
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int value) {
        DoubleLinkListNode nodeToAdd = new DoubleLinkListNode();
        nodeToAdd.key = key;
        nodeToAdd.value = value;
        if (currentSize == capacity) {
            keyToNode.remove(tail.prev.key);
            removeLast();
            currentSize--;
        }
        addBeginning(nodeToAdd);
        keyToNode.put(key, nodeToAdd);
        currentSize++;
    }

    public int get(int key) {
        DoubleLinkListNode node = keyToNode.get(key);
        if (node != null) {
            remove(node);
            addBeginning(node);
            return node.value;
        } else {
            return -1;
        }

    }

    private void addBeginning(DoubleLinkListNode nodeToAdd) {
        nodeToAdd.next = head.next;
        head.next.prev = nodeToAdd;
        head.next = nodeToAdd;
        nodeToAdd.prev = head;
    }

    private void removeLast() {
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
    }

    private void remove(DoubleLinkListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));
        cache.put(5, 5);
        cache.put(6, 6);
        System.out.println(cache.get(2));
    }

}
