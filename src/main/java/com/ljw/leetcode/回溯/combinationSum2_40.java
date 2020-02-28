package com.ljw.leetcode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class combinationSum2_40 {

	public static void main(String[] args) {
		combinationSum2_40 m = new combinationSum2_40();
		int[] candidates  = {10,1,2,7,6,1,5};
		int target = 8;
		m.combinationSum2(candidates,target);
	}

	HashMap<String,Boolean> isOk = new HashMap<>();
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {

		List<List<Integer>> result = new ArrayList<>();
		if(candidates == null || candidates.length == 0){
			return result;
		}

		Arrays.sort(candidates);

		backTrack(result, candidates, 0, new ArrayList<Integer>(), target);

		return result;
	}

	private void backTrack(List<List<Integer>> result, int[] candidates, int index, ArrayList<Integer> tmp, int target) {

		if(target == 0 && isOk.put(toStr(tmp),true) == null){
			result.add(new ArrayList<>(tmp));
			return;
		}

		for(int i = index; i < candidates.length && target >= candidates[i]; i++){
			tmp.add(candidates[i]);
			backTrack(result, candidates, i + 1, tmp, target - candidates[i]);
			tmp.remove(tmp.size() - 1);
		}

	}

	private String toStr(ArrayList<Integer> tmp) {

		StringBuilder sb = new StringBuilder();
		for(Integer i : tmp){
			sb.append(i).append(",");
		}
		return sb.toString();
	}
}
