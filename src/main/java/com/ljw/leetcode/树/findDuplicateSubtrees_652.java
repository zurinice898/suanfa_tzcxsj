package com.ljw.leetcode.树;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 这题的精华就是怎样标识一颗二叉数。加上空节点标识符，任何一种遍历方法都可以唯一标识一个数。
 */
public class findDuplicateSubtrees_652 {

	public static void main(String[] args) {
		TreeNode node1= new TreeNode(1);
		TreeNode node2= new TreeNode(2);
		TreeNode node3= new TreeNode(3);
		TreeNode node4= new TreeNode(4);
		TreeNode node2_3= new TreeNode(2);
		TreeNode node4_3= new TreeNode(3);
		TreeNode node4_4= new TreeNode(4);

		node1.left = node2;node1.right = node3;
		node2.left = node4;
		node3.left = node2_3;node3.right = node4_3;
		node2.left = node4_4;
		findDuplicateSubtrees_652 m = new findDuplicateSubtrees_652();
		m.findDuplicateSubtrees(node1);
	}

	HashMap<String, Integer> map = new HashMap<>();
	List<TreeNode> result = new ArrayList<>();
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		if(root == null){
			return result;
		}
		serialize(root);
		return result;
	}

	private String serialize(TreeNode root) {
		if(root == null){
			return "#";
		}
		String str = root.val +","+ serialize(root.left) +","+ serialize(root.right);
		map.put(str, map.getOrDefault(str, 0) + 1);
		if(map.get(str) == 2){
			result.add(root);
		}
		return str;
	}


	private static  class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
