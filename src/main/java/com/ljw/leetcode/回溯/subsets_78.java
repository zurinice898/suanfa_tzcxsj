package com.ljw.leetcode.回溯;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 这题是个特殊的回溯，同层只有加和不加两种状态
 */
public class subsets_78 {

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if(nums == null || nums.length == 0){
			return result;
		}

		backTrack(result, nums, new Stack<Integer>(), 0, nums.length);

		return result;
	}

	private void backTrack(List<List<Integer>> result, int[] nums, Stack<Integer> tmp, int index, int target) {
		if(index == target ){
			result.add(new ArrayList<>(tmp));
			return;
		}
		//加
		tmp.push(nums[index]);
		backTrack(result, nums, tmp, index+1, target);
		tmp.pop();

		//不加
		backTrack(result, nums, tmp, index + 1, target);
	}
}
