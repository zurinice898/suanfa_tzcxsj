package com.ljw.leetcode.树;

import javax.swing.tree.TreeNode;

/**
 * 这题是很有启发性的，要关注最终的解的构成是什么。我们要求的一个数包含几个，最终还是要落实到
 * 每颗子树有没有的问题
 */
public class lowestCommonAncestor_236 {

	public static void main(String[] args) {
		TreeNode node3= new TreeNode(3);
		TreeNode node5= new TreeNode(5);
		TreeNode node1= new TreeNode(1);
		TreeNode node6= new TreeNode(6);
		TreeNode node2= new TreeNode(2);
		TreeNode node0= new TreeNode(0);
		TreeNode node8= new TreeNode(8);
		TreeNode node7= new TreeNode(7);
		TreeNode node4= new TreeNode(4);

		node3.left = node5;
		node3.right = node1;
		node5.left = node6;
		node5.right = node2;
		node1.left = node0;
		node1.right = node8;
		node2.left =node7;
		node2.right = node4;
		lowestCommonAncestor_236 d = new lowestCommonAncestor_236();
		TreeNode result = d.lowestCommonAncestor(node3,node5,node4);
		System.out.println(result.val);
	}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		recurseTree(root, p, q);
		return this.ans;

	}


	private TreeNode ans;
	private boolean recurseTree(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || ans != null){
			return false;
		}


		int mid = (root.val == p.val || root.val == q.val) ? 1 : 0;

		int left = recurseTree(root.left, p, q) ? 1 : 0;


		int right = recurseTree(root.right, p, q) ? 1 : 0;



		int sum = left + mid + right;

		if(sum > 1){
			ans = root;
		}

		return sum > 0;

	}


	private static  class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
