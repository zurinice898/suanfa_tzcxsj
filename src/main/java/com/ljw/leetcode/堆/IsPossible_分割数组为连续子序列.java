package com.ljw.leetcode.堆;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class IsPossible_分割数组为连续子序列 {

	public static void main(String[] args) {
		IsPossible_分割数组为连续子序列 m = new IsPossible_分割数组为连续子序列();
		int[] num = {1,2,3,3,4,5};
		System.out.println(m.isPossible(num));
	}

	/**
	 * 这个解法是我觉得最优秀的 这种解法的核心就是找到一个可行解删掉，找下一个。可行解的终点判断有技巧
	 * @param nums
	 * @return
	 */
	public boolean isPossible(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0)+1);
		}
		for (int i : nums) {
			//子数组的元素个数
			int subNum = 0;
			int p = 1;
			//下个元素
			int next = i;
			while (map.getOrDefault(next, 0) >= p) {
				p = map.get(next);
				map.put(next, p-1);
				++subNum;
				++next;
			}
			if (subNum > 0 && subNum < 3) {
				return false;
			}
		}
		return true;
	}


}
