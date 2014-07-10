package com.wzystal.day0615;

//Reorder List
public class Solution {
	class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode middle = slow.next;
		slow.next = null;
		middle = reverseList(middle);
		ListNode n1 = head, n2 = middle;
		mergeList(n1, n2);
	}

	//反转单链表
	private ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode pre = head, cur = head.next;
		while (cur != null) {
			ListNode temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		head.next = null; //important!
		return pre;
	}

	//穿插合并单链表
	private void mergeList(ListNode n1, ListNode n2) {
		ListNode t1, t2;
		while (n2 != null) {
			t1 = n1.next;
			t2 = n2.next;
			n1.next = n2;
			n2.next = t1;
			n1 = t1;
			n2 = t2;
		}
	}
}
