package com.leetcode1227.LRUCache;

import java.util.HashMap;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. put(key, value) - Set or insert the
 * value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new
 * item.
 * 
 * @author tangc
 *
 */


public class LRUCache {
	class Node {
		int key;
		int value;
		Node prev;
		Node next;
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private HashMap<Integer, Node> map;
	private int capacity;
	private Node head;
	private Node tail;
	
    public LRUCache(int capacity) {
    	this.map = new HashMap<>();
    	this.capacity = capacity;
    	head = null;
    	tail = null;
    }
    
    public int get(int key) {
        Node node  = map.get(key);
        if (node == null) {
        	return -1;
        } else {
        	if (node == head) {
        		head = head.next;
        	} else {
        		//node不为head时，删除该元素然后放到最后即可
        		node.prev.next = node.next;
        		node.next.prev = node.prev;
        	}
        	tail.next  = node;
        	node.prev = tail;
        	node.next = null;
        	tail = node;
        }
        return node.value;
        
    }
    
    public void put(int key, int value) {
        Node node  = map.get(key);
        if (node != null) {
        	
        	if (node == head) {
        		node.value = value;
        		head = head.next;
        	} else {
        		node.value = value;
        		//node不为head时，删除该元素然后放到最后即可
        		node.prev.next = node.next;
        		node.next.prev = node.prev;
        	}
        	tail.next  = node;
        	node.prev = tail;
        	node.next = null;
        	tail = node;
        } else {
        	Node newNode = new Node(key, value);
        	if (capacity == 0) {
        		Node temp = head;
        		head = head.next;
        		map.remove(temp.key);
        		capacity++;
        	} 
        	if (head == null && tail == null) {
        		head = newNode;
        	} else {
        		tail.next = newNode;
        		newNode.prev = tail;
        		newNode.next = null;
        	}
        	tail = newNode;
        	map.put(key, newNode);
        	capacity--;
        }
    }
}
