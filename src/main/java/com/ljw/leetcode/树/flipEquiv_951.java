package com.ljw.leetcode.树;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Stack;

public class flipEquiv_951 {

	public static void main(String[] args) {
		TreeNode root1 = getRoot1();
		TreeNode root2 = getRoot2();
		flipEquiv_951 m = new flipEquiv_951();
		System.out.println(m.flipEquiv(root1,root2));

	}

	public boolean flipEquiv(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null){
			return true;
		}
		if(root1 == null || root2 == null){
			return false;
		}
		if(root1.val == root2.val){
			return flipEquiv(root1.left,root2.left) && flipEquiv(root1.right, root2.right)||
					flipEquiv(root1.left,root2.right) && flipEquiv(root1.left,root2.right);
		}

		return false;

	}

	private static TreeNode getRoot1() {
		TreeNode node1= new TreeNode(1);
		TreeNode node2= new TreeNode(2);
		TreeNode node3= new TreeNode(3);
		TreeNode node4= new TreeNode(4);
		TreeNode node5= new TreeNode(5);
		TreeNode node6= new TreeNode(6);
		TreeNode node7= new TreeNode(7);
		TreeNode node8= new TreeNode(8);

		node1.left = node2; node1.right = node3;
		node2.left = node4; node2.right = node5;
		node3.left = node6;
		node5.left = node7;node5.right = node8;
		return node1;

	}
	private static TreeNode getRoot2() {
		TreeNode node1= new TreeNode(1);
		TreeNode node2= new TreeNode(2);
		TreeNode node3= new TreeNode(3);
		TreeNode node4= new TreeNode(4);
		TreeNode node5= new TreeNode(5);
		TreeNode node6= new TreeNode(6);
		TreeNode node7= new TreeNode(7);
		TreeNode node8= new TreeNode(8);

		node1.left = node3; node1.right = node2;
		node2.left = node4; node2.right = node5;
		node3.left = node6;
		node5.left = node8;node5.right = node7;
		return node1;
	}

	private LinkedList<TreeNode> queue1 = new LinkedList<>();
	private LinkedList<TreeNode> queue2 = new LinkedList<>();
	//太麻烦了
	public boolean flipEquivL(TreeNode root1, TreeNode root2) {

		queue1.offer(root1);
		queue2.offer(root2);
		while(!(queue1.isEmpty() && queue2.isEmpty())){
			TreeNode n1 = queue1.poll();
			TreeNode n2 = queue2.poll();
			if(n1==null && n2 == null){
				continue;
			}
			if(!((n1 != null && n2 != null))){
				return false;
			}
			if(n1.val != n2.val){
				return false;
			}

			boolean fBoll = isEqual(n1.left,n2.left)&&isEqual(n1.right,n2.right);
			if(fBoll){
				queue1.offer(n1.left);queue1.offer(n1.right);
				queue2.offer(n2.left);queue2.offer(n2.right);
				continue;
			}

			boolean rBoll =isEqual(n1.left,n2.right)&&isEqual(n1.right,n2.left);
			if(rBoll){
				queue1.offer(n1.left);queue1.offer(n1.right);
				queue2.offer(n2.right);queue2.offer(n2.left);
				continue;
			}

			return false;
		}
		return true;
	}

	private boolean isEqual(TreeNode left, TreeNode right) {
		if(left == null && right == null){
			return true;
		}
		if(!(left != null && right != null)){
			return false;
		}
		return left.val == right.val;
	}


	private static  class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
