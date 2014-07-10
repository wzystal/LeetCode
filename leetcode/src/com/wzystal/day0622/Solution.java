package com.wzystal.day0622;

import java.util.Set;

/**
 * LeetCode | Word Break
 * 
 * @author wzystal@gmail.com
 */
public class Solution {
	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0 || dict == null || dict.size() == 0)
			return false;
		int len = s.length();
		boolean[] can = new boolean[len + 1];
		can[0] = true;
		for (int i = 1; i <= len; i++) {
			for (int j = 0; j < i; j++) {
				if (can[j] && dict.contains(s.substring(j, i))) {
					can[i] = true;
					break;
				}
			}
		}
		return can[len];
	}
}
