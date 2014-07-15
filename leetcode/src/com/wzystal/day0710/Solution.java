package com.wzystal.day0710;

/**
 * LeetCode | Single Number
 * @author wzystal
 */
public class Solution {
	// Given an array of integers, every element appears twice except for one.
	// Find that single one.
	// 时间复杂度O(N),空间复杂度O(1)
	public int singleNumber(int[] A) {
		int result = 0;
		for (int i : A) {
			result ^= i;
		}
		return result;
	}
}
