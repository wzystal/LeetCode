package com.wzystal.day0522;

import java.util.LinkedHashMap;

public class LRUCache1 extends LinkedHashMap<Integer, Integer> {
	private static final long serialVersionUID = -7812413405672793813L;
	private int capacity;

	public LRUCache1(int capacity) {
		super(capacity+1, 0.75f, true);
		this.capacity = capacity;
	}

	@Override
	protected boolean removeEldestEntry(
			java.util.Map.Entry<Integer, Integer> eldest) {
		return size() > capacity; //当缓存大小超出容量时，移除最久未被使用的缓存
	}

	public int get(int key) {
		return super.get(key) != null ? super.get(key) : -1;
	}

	public void set(int key, int value) {
		super.put(key, value);
	}

	public int size() {
		return super.size();
	}

}
