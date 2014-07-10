package com.wzystal.day0710;

/**
 * LeetCode | Single Number
 * 
 * @author wzystal
 */
public class Solution {
	public int singleNumber(int[] A) {
		int x = 0;
		for (int i : A) {
			x = x ^ i;
		}
		return x;
	}
}
