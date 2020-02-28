package com.ljw.leetcode.树;

import java.util.ArrayList;
import java.util.List;

public class inorderTraversal_94 {


	public List<Integer> inorderTraversal(TreeNode root) {
		if(root == null){
			return null;
		}
		List<Integer>  result = new ArrayList<>();
		travel(result,root);
		return result;
	}

	private void travel(List<Integer> result, TreeNode root) {
		if(root == null){
			return;
		}
		travel(result, root.left);
		result.add(root.val);
		travel(result, root.right);
	}


	private static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }
}
