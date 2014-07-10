package com.wzystal.day0708;

/**
 * LeetCode | Reverse Words in a String
 * @author wzystal@gmail.com
 */
public class Solution {
	public String reverseWords(String s) {
		String[] strs = s.trim().split("\\s+");
		String result = "";
		for (int i = strs.length - 1; i >= 0; i--) {
			if (i == 0) {
				result += strs[i].trim();
			} else {
				result += strs[i].trim() + " ";
			}
		}
		return result;
	}
}
