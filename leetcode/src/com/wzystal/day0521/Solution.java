package com.wzystal.day0521;

public class Solution {
	
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode index = head.next;
		while (index != null) {
			ListNode temp = head;
			while (temp.val < index.val && temp != index)
				temp = temp.next;
			if (temp != index) {
				while (temp != index) {
					int t = temp.val;
					temp.val = index.val;
					index.val = t;
					temp = temp.next;
				}
			}
			index = index.next;
		}
		return head;
	}

	static void print(ListNode head) {
		if (head != null) {
			System.out.print(" " + head.val);
			while (head.next != null) {
				head = head.next;
				System.out.print(" " + head.val);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		print(n1);
		print(insertionSortList(n1));
	}

}
