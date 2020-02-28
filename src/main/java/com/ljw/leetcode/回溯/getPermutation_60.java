package com.ljw.leetcode.回溯;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class getPermutation_60 {


	public static void main(String[] args) {
		getPermutation_60 m = new getPermutation_60();
		System.out.println(m.getPermutation(3,5));
	}

	public String getPermutation(int n, int k) {

		StringBuilder sb = new StringBuilder();
		// 候选数字
		List<Integer> candidates = new ArrayList<>();
		// 分母的阶乘数
		int[] factorials = new int[n+1];
		factorials[0] = 1;
		int fact = 1;
		for(int i = 1; i <= n; ++i) {
			candidates.add(i);
			fact *= i;
			factorials[i] = fact;
		}
		k -= 1;
		for(int i = n-1; i >= 0; --i) {
			// 计算候选数字的index
			int index = k / factorials[i];
			sb.append(candidates.remove(index));
			k -= index*factorials[i];
		}
		return sb.toString();
	}




}
