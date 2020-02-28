package com.ljw.leetcode;

import javax.swing.tree.TreeNode;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;

/**
 * https://segmentfault.com/a/1190000015684648
 */
public class e二叉搜索树转化为双向链表 {


	public  TreeNode convert(TreeNode root){

		PriorityQueue queue = new PriorityQueue();
		Random random = new Random();
		random.nextInt();
		Set<Integer> set = new HashSet<>();
		set.add(3);

		if(root  == null ){
			return null;
		}

		TreeNode lastNode = null;
		lastNode =  converNode(root, lastNode);

		TreeNode head = null;
		while(lastNode != null){
			head = lastNode;
			lastNode = lastNode.left;
		}
		return head;
	}



	TreeNode converNode(TreeNode root, TreeNode lastLoad){
		if(root == null){
			return null;
		}

		if(root.left != null){
			lastLoad = converNode(root.left, lastLoad);
		}

		TreeNode cur = root;
		cur.left = lastLoad;
		if(lastLoad != null){
			lastLoad.right = cur;
		}
		lastLoad = cur;

		if(root.right != null){
			lastLoad = converNode(root.right,lastLoad);
		}
		return lastLoad;
	}


	static  class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

		public TreeNode() {
		}
	}
}
