package com.wzystal.day0520;

public class Solution {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode sortList(ListNode head) {
		ListNode head1, head2;
		if (head == null || head.next == null)
			return head;
		ListNode slow = head, fast = head;
		while (fast.next != null) {
			fast = fast.next;
			if (fast.next != null) {
				fast = fast.next;
				slow = slow.next;
			}
		}
		head1 = head;
		head2 = slow.next;
		slow.next = null;
		head1 = sortList(head1);
		head2 = sortList(head2);
		return merge(head1, head2);
	}

	private static ListNode merge(ListNode head1, ListNode head2) {
		if (head1 == null) {
			return head2;
		} else if (head2 == null) {
			return head1;
		}
		ListNode head, index;
		if (head1.val <= head2.val) {
			head = head1;
			head1 = head1.next;
		} else {
			head = head2;
			head2 = head2.next;
		}
		index = head;
		while (head1 != null && head2 != null) {
			if (head1.val <= head2.val) {
				index.next = head1;
				head1 = head1.next;
			} else {
				index.next = head2;
				head2 = head2.next;
			}
			index = index.next;
		}
		if (head1 != null) {
			index.next = head1;
		}
		if (head2 != null) {
			index.next = head2;
		}
		return head;
	}

	static void print(ListNode head){
		if(head!=null){
			System.out.print(" " + head.val);
			while(head.next!=null){
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
		ListNode n = sortList(n1);
		print(n);
	}

}
