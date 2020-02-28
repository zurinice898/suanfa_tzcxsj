package com.ljw.leetcode.树;

import sun.reflect.generics.tree.Tree;

public class flatten_114 {


	public void flatten(TreeNode root) {
		if(root == null){
			return ;
		}
		TreeNode result = generate(root);
		return;
	}

	private TreeNode generate(TreeNode root) {
		if(root == null){
			return null;
		}
		TreeNode rightTemp = root.right;
		root.right =generate(root.left);
		root.left = null;
		TreeNode lastIndex = root;
		while(lastIndex.right != null){
			lastIndex = lastIndex.right;
		}
		 lastIndex.right = generate(rightTemp);
		return root;
	}

	// 先获取到左子树的先序遍历的最后一个节点，将该节点右边指向右子树，再让根节点的右边指向左子树
	// 递归下去
	// 参数：当前树根节点
	// 返回值：当前树先序遍历的最后一个节点
	private TreeNode helper(TreeNode node) {
		if (node.left == null) {
			return node.right != null ? helper(node.right) : node;
		} else {
			TreeNode last = helper(node.left);
			last.right = node.right;
			node.right = node.left;
			node.left = null;
			return last.right != null ? helper(last.right) : last;
		}
	}


	private static  class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
