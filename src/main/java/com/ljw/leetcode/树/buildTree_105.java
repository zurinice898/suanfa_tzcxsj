package com.ljw.leetcode.树;

import java.util.HashMap;

public class buildTree_105 {

	public static void main(String[] args) {
		int[] preorder ={3,9,20,15,7};
		int[] inorder  = {9,3,15,20,7};
		TreeNode result = new buildTree_105().buildTree(preorder,inorder);
	}
	public TreeNode buildTree(int[] preorder, int[] inorder) {

		if(preorder.length < 1){
			return null;
		}

		return generate(preorder,inorder,0,preorder.length-1);

	}



	private TreeNode generate(int[] preorder, int[] inorder, int start, int end) {

		if(start > end){
			return null;
		}
		if(start ==end){
			return new TreeNode(preorder[start]);
		}
		//找根的坐标
		int rootIndex = find(inorder,start,end,preorder[start]);

		//分割preorder
		split(preorder,start,rootIndex);

		TreeNode result = new TreeNode(preorder[rootIndex]);
		TreeNode left = generate(preorder,inorder,start, rootIndex -1);
		TreeNode right = generate(preorder,inorder,rootIndex + 1, end);
		result.left = left;
		result.right = right;
		return  result;
	}

	private void split(int[] preorder, int start,  int rootIndex) {
		int temp = preorder[start];
		for(int i = start+1; i <=rootIndex; i++){
			preorder[i-1] = preorder[i];
		}
		preorder[rootIndex]  = temp;
	}

	private int find(int[] inorder, int start, int end, int num) {
		for(int i = start; i <= end; i++){
			if(num == inorder[i]){
				return i;
			}
		}
		return -1;
	}


	private static  class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}


}
