package com.ljw.leetcode.回溯;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 这个回溯有借鉴意义
 */
public class combinationSum_39 {


	public static void main(String[] args) {
		combinationSum_39 m = new combinationSum_39();
		int[] candidates  = {2,3,6,7};
		int target = 7;
		m.combinationSum(candidates,target);
	}


	/**
	 * 不够优秀
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if(candidates == null || candidates.length == 0){
			return result;
		}

		Arrays.sort(candidates);

		backTrack(result, candidates, 0,new ArrayList<Integer>(), target);
		return result;
	}

	private void backTrack(List<List<Integer>> result, int[] candidates, int index, List<Integer> tempResult,  int target) {
		if(0 == target){
			result.add(new ArrayList<>(tempResult));
			return;
		}

		for(int i = index; i < candidates.length && candidates[i]<=target; i++ ){
			tempResult.add(candidates[i]);
			//这里是关键，这里决定下一步往哪走， 优先添加自己，然后才是下一个元素   （这个思路要理清楚）
			backTrack(result, candidates, i, tempResult, target - candidates[i]);
			tempResult.remove(tempResult.size() - 1);
		}
	}
}
