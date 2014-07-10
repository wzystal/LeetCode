package com.wzystal.day0625;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/**
 * LeetCode | Word Break II
 * @author wzystal@gmail.com
 */
public class Solution {
	List<String> records = new ArrayList<String>();

	public List<String> wordBreak(String s, Set<String> dict) {
		if (canBreak(s, dict)) {
			dfsSearch(s, dict, "");
		}
		return records;
	}

	private boolean canBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0 || dict == null || dict.size()==0)
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

	private void dfsSearch(String str, Set<String> dict, String result) {
		int len = str.length();
		if (len == 0) {
			records.add(result);
		}
		for (int i = 0; i <= len; i++) {
			String sub = str.substring(0,i);
			if(dict.contains(sub)){
				int curLen = result.length();
				if(!result.equals("")){
					result += " ";
				}
				result += sub;
				dfsSearch(str.substring(i), dict, result);
				result = result.substring(0, curLen);
			}
		}
	}

	// Time Limit Exceeded !
	public List<String> wordBreak1(String s, Set<String> dict) {
		if (s == null || s.length() <= 0 || dict == null || dict.size() <= 0)
			return null;
		int len = s.length();
		HashMap<Integer, List<String>> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		List<String> sentences = new ArrayList<String>();
		for (int i = 1; i <= len; i++) {
			list.clear();
			if (dict.contains(s.substring(0, i))) {
				list.add(s.substring(0, i));
			}
			for (int j = 1; j <= i; j++) {
				sentences = map.get(j);
				if (sentences.size() > 0 && dict.contains(s.substring(j, i))) {
					for (int k = 0; k < sentences.size(); k++) {
						String str = sentences.get(k);
						list.add(str + " " + s.substring(j, i));
					}
				}
			}
			map.put(i, list);
		}
		return map.get(len);
	}

}
