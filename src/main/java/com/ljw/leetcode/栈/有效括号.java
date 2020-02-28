package com.ljw.leetcode.栈;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 有效括号 {

	public static void main(String[] args) {
		String s = "((";
		System.out.println(isValid(s));
	}

	public static  boolean isValid(String s) {
		if(s==null || s.equals("")){
			return true;
		}
		char[] chars = s.toCharArray();
		if(chars.length < 2){
			return false;
		}
		Stack<Character> stack = new Stack<>();
		List<Character> inFlags = Arrays.asList('(','{','[');
		List<Character> outFlags =Arrays.asList(')','}',']');

		try {
			char c;
			stack.push(chars[0]);
			for (int i = 1; i < chars.length ;i++) {
				c  = chars[i];
				if (inFlags.contains(c)) {
					stack.push(c);
				}else if(outFlags.contains(c)){
					if( stack.pop() != getOther(c)){
						return false;
					}
				}
			}
			return  stack.isEmpty() ? true : false;
		}catch(Exception e){
			return false;
		}
	}

	private static Character getOther(char c) {
		switch (c){
			case ')': return '(';
			case '}': return '{';
			case ']': return '[';
			default: return null;
		}
	}
}
