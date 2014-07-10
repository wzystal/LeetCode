package com.wzystal.day0504;

import java.util.HashMap;

public class Solution {

	class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	// 求最大公约数 		gcd(0,1)=1,	gcd(0,-1)=0, gcd(0,0)=0
	private static int gcd(int a, int b) {
		return (b!=0) ? gcd(b, a % b) : a;
	}

	public static int maxPoints(Point[] points) {
		if (points == null)
			return 0;
		int len = points.length;
		if (len <= 2)
			return len;

		HashMap<String, Integer> records = new HashMap<>();
		int result = 0;
		Point pa, pb;
		int x, y;

		for (int i = 0; i < len - 1; i++) {
			records.clear();
			int same = 1;	
			int max = 0;
			pa = points[i];
			for (int j = i + 1; j < len; j++) {
				pb = points[j];				
				if (pa.x >= pb.x) {
					x = pa.x - pb.x;
					y = pa.y - pb.y;
				} else {
					x = pb.x - pa.x;
					y = pb.y - pa.y;
				}
				int gcdXY = gcd(Math.abs(x), Math.abs(y));
				if (gcdXY == 0) {
					++same;
				} else {
					x /= gcdXY;
					y /= gcdXY;
					if (x == 0 || y == 0) {  //与x轴或y轴平行的情况
                        x = Math.abs(x);  
                        y = Math.abs(y);  
                    }  
					String key = y + "/" + x;
					int value = 0;
					if (records.containsKey(key)) {
						value = records.get(key);
					}
					records.put(key, ++value);
					max = Math.max(max, value);
				}
			}
			result = Math.max(result, max+same);
		}
		return result;
	}

}
