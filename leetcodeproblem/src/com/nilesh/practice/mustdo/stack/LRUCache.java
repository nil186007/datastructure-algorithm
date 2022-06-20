package com.nilesh.practice.mustdo.stack;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class DoubleLinkListNode{
        int key;
        int value;
        DoubleLinkListNode next;
        DoubleLinkListNode prev;
    }

    int capacity;
    int currentSize;
    Map<Integer, DoubleLinkListNode> entryMap;
    DoubleLinkListNode head;
    DoubleLinkListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.currentSize = 0;
        this.entryMap = new HashMap<>();
        this.head = new DoubleLinkListNode();
        this.tail = new DoubleLinkListNode();
        head.next=tail;
        tail.prev= head;
    }

    void put(int key, int value){
        DoubleLinkListNode node = entryMap.get(key);
        if(node==null){
            node = new DoubleLinkListNode();
            node.key = key;
            node.value = value;
            entryMap.put(key, node);

            if(currentSize==capacity){
                deleteNode(tail.prev);
                entryMap.remove(tail.prev.key);
            }
            addToBegining(node);
            currentSize++;
        }
    }

    int get(int key){
        DoubleLinkListNode node = entryMap.get(key);
        int valueToReturn = -1;
        if(node!=null){
            valueToReturn =  node.value;
            deleteNode(node);
            addToBegining(node);
        }
        return valueToReturn;
    }

    private void addToBegining(DoubleLinkListNode node) {
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
        node.prev=head;
    }

    private void deleteNode(DoubleLinkListNode node) {
        node.next.prev=node.prev;
        node.prev.next=node.next;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        System.out.println(cache.get(1));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(4));
    }

}
