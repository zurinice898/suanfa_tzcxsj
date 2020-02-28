package com.ljw.leetcode.树;

import java.util.ArrayList;
import java.util.List;

public class generateTrees_95 {

	public List<TreeNode> generateTrees(int n) {
		if(n == 0){
			return new ArrayList<>();
		}
		return generate(1,n);
	}

	private List<TreeNode> generate(int s, int e) {
		List<TreeNode> result = new ArrayList<>();
		if(s > e){
			result.add(null);
			return  result;
		}

		for(int i = s; i <= e; i++){
			//写程序要先思考正常流程
			List<TreeNode> left = generate(s, i - 1);
			List<TreeNode> right = generate(i + 1, e);
			for(TreeNode l : left)
				for(TreeNode r : right){
					TreeNode newNode = new TreeNode(i);
					newNode.left = l;
					newNode.right = r;
					result.add(newNode);
			}
		}
		return  result;
	}


	private static  class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

}
