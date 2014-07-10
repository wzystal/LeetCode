package com.wzystal.day0611;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	}

	// 先序遍历--递归实现
	public List<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		list.add(root.val);
		list.addAll(preorderTraversal(root.left));
		list.addAll(preorderTraversal(root.right));
		return list;
	}

	// 中序遍历--递归实现
	public List<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		list.addAll(inorderTraversal(root.left));
		list.add(root.val);
		list.addAll(inorderTraversal(root.right));
		return list;
	}

	// 后序遍历--递归实现
	public List<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		list.addAll(postorderTraversal(root.left));
		list.addAll(postorderTraversal(root.right));
		list.add(root.val);
		return list;
	}

	// 先序遍历--非递归实现
	public List<Integer> preorderStack(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode cur = null;
		while (!stack.empty()) {
			cur = stack.pop();
			list.add(cur.val);
			if (cur.right != null)
				stack.push(cur.right);
			if (cur.left != null)
				stack.push(cur.left);
		}
		return list;
	}

	// 中序遍历--非递归实现
	public List<Integer> inorderStack(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while (!stack.empty() || cur != null) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				TreeNode temp = stack.pop();
				list.add(temp.val);
				cur = temp.right;
			}
		}
		return list;
	}

	// 后序遍历--非递归实现
	public List<Integer> postorderStack(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode pre = null;
		while (!stack.empty()) {
			TreeNode cur = stack.peek();
			if ((cur.left == null && cur.right == null) || 
				(pre != null && (pre == cur.left || pre == cur.right))) {
				list.add(cur.val);
				stack.pop();
				pre = cur;
			}else {
				if (cur.right != null)
					stack.push(cur.right);
				if (cur.left != null)
					stack.push(cur.left);
			}
		}
		return list;
	}
}
