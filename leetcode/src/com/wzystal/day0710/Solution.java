package com.wzystal.day0710;

/**
 * LeetCode | Single Number
 * 
 * @author wzystal
 */
public class Solution {
	// Given an array of integers, every element appears twice except for one.
	// Find that single one.
	// 时间复杂度O(N),空间复杂度O(1)
	public int singleNumber2(int[] A) {
		int result = 0;
		for (int i : A) {
			result ^= i;
		}
		return result;
	}

	// Given an array of integers, every element appears three times except for
	// one. Find that single one.
	// 时间复杂度O(N),空间复杂度O(N)
	public static int singleNumber3(int[] A) {
		if (A.length == 0)
			return 0;
		int[] bits = new int[32];
		int result = 0;
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < A.length; j++) {
				if (((A[j] >> i) & 1) == 1) {
					bits[i] = (bits[i] + 1) % 3;
				}
			}
			result |= (bits[i] << i);
		}
		return result;
	}

	// Given an array of integers, every element appears three times except for
	// one. Find that single one.
	// 时间复杂度O(N),空间复杂度O(1)
	public static int singleNumber(int[] A) {
		int len = A.length;
		if (len == 0)
			return 0;
		int ones = 0, twos = 0, threes = 0;
		for (int i = 0; i < len; i++) {
			twos |= (ones & A[i]);
			ones ^= A[i];
			threes = ~(ones & twos);
			ones &= threes;
			twos &= threes;
		}
		return ones;
	}

}
