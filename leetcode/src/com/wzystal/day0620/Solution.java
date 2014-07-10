package com.wzystal.day0620;

/**
 * LeetCode | Linked List Cycle
 * @author wzystal@gmail.com
 */
public class Solution {
	class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

	// 判断单链表是否有环
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) return false;
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) return true;
		}
		return false;
	}

	// 若单链表存在环，返回环的入口点
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) return null;
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) break;
		}
		if (fast == slow) {
			ListNode n1 = head, n2 = slow;
			while(n1 != n2){
				n1 = n1.next;
				n2 = n2.next;
			}
			return n1;
		}
		return null;
	}
}
