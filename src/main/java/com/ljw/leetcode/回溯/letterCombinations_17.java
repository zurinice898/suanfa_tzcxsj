package com.ljw.leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

public class letterCombinations_17 {

	public static void main(String[] args) {
		letterCombinations_17 m = new letterCombinations_17();
		String inp = "23";
		m.letterCombinations(inp);
	}
	private static String letterMap[] = {
			"",     //0
			"",     //1
			"abc",  //2
			"def",  //3
			"ghi",  //4
			"jkl",  //5
			"mno",  //6
			"pqrs", //7
			"tuv",  //8
			"wxyz"  //9
	};

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if(digits == null || digits.length() == 0){
			return result;
		}
		char[] input = digits.toCharArray();
		backTrace(result, input, 0, "");
		return result;
	}

	private void backTrace(List<String> result, char[] input, int level,String temp) {
		if(level == input.length){
			result.add(temp);
			return;
		}
		char[] next = letterMap[input[level]-'0'].toCharArray();
		for(char c : next){
			backTrace(result, input, level+1, temp + c);
		}
	}
}
