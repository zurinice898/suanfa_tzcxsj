package com.ljw.leetcode.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 加了顺序的排列就是组合了，组合实现起来更简单
 */
public class combine_77 {

	public static void main(String[] args) {
		combine_77 m = new combine_77();
		m.combine(4,2);
	}

	public List<List<Integer>> combine(int n, int k) {

		int[] nums = new int[n];
		for(int i = 0; i < n; i++){
			nums[i]  = i + 1;
		}
		List<List<Integer>> result = new ArrayList<>();
		backTrack(result, nums, new Stack<Integer>(),0, k);
		return result;

	}

	private void backTrack(List<List<Integer>> result, int[] nums, Stack<Integer> tmp, int index, int k) {
		if(k == 0){
			result.add(new ArrayList<>(tmp));
			return;
		}

		for(int i = index; i + k <= nums.length ;i++ ){
			tmp.push(nums[i]);
			backTrack(result,nums,tmp,i+1,k-1);
			tmp.pop();
		}
	}
}
