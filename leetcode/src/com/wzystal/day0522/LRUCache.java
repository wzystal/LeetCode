package com.wzystal.day0522;

import java.util.HashMap;

public class LRUCache {

	class CacheNode {
		public int key;
		public int value;
		public CacheNode pre;
		public CacheNode next;

		public CacheNode(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private int capacity;
	private int size = 0;
	private HashMap<Integer, CacheNode> map = new HashMap<>();
	private CacheNode head;
	private CacheNode tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		head = null;
		tail = null;
	}

	private void removeNode(CacheNode node) {
		CacheNode pre = node.pre;
		CacheNode next = node.next;
		if (pre != null) {
			pre.next = next;
		} else {
			head = next;
		}
		if (next != null) {
			next.pre = pre;
		} else {
			tail = pre;
		}
	}

	private void setHead(CacheNode node) {
		node.next = head;
		node.pre = null;
		if (head != null) {
			head.pre = node;
		}
		head = node;
		if (tail == null) {
			tail = node;
		}
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			CacheNode oldNode = map.get(key);
			oldNode.value = value;
			removeNode(oldNode);
			setHead(oldNode);
		} else {
			CacheNode newNode = new CacheNode(key, value);
			if (size < capacity) {
				size++;
			} else {
				map.remove(tail.key);
				tail = tail.pre;
				if (tail != null) {
					tail.next = null;
				}
			}
			setHead(newNode);
			map.put(key, newNode);
		}
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			CacheNode lastest = map.get(key);
			removeNode(lastest);
			setHead(lastest);
			return lastest.value;
		} else {
			return -1;
		}
	}

}
