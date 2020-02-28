package com.ljw.leetcode;

import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class z柱状图中矩形的最大面积 {
	public static void main(String[] args) {
		int[] heights = {2,1,2};
		System.out.println(new z柱状图中矩形的最大面积().largestRectangleArea2(heights));
	}

	public int largestRectangleArea(int[] heights) {
		if(heights == null || heights.length == 0){
			return 0;
		}

		int result = 0;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		stack.push(heights[0]);



		for(int i = 1; i < heights.length; i++){
			Integer pVal = stack.peek();
			if(pVal == null){
				pVal = 0;
			}

			if(heights[i] >= pVal){
				//入栈
				stack.push(heights[i]);
			}else{
				//出栈，每一次出栈就对应一个新面积的产生
				Integer t1 = stack.pop();
				result = Math.max(result, t1);
				int tIndex = 2;
				while((!stack.isEmpty()) && stack.peek() > heights[i]){
					int t2 = stack.pop();
					result = Math.max(result, t2 * tIndex);
					tIndex++;
				}

				stack.push(heights[i]);
			}
		}

		int tIndex = 1;
		while(!stack.isEmpty()){
			int t2 = stack.pop();
			result = Math.max(result, t2 * tIndex);
			tIndex++;
		}

		return result;



	}

	public int largestRectangleArea2(int[] heights) {
		int maxArea = 0;
		Stack<Integer> stack = new Stack<>();
		int p = 0;
		while (p < heights.length) {
			//栈空入栈
			if (stack.isEmpty()) {
				stack.push(p);
				p++;
			} else {
				int top = stack.peek();
				//当前高度大于栈顶，入栈
				if (heights[p] >= heights[top]) {
					stack.push(p);
					p++;
				} else {
					//保存栈顶高度
					int height = heights[stack.pop()];
					//左边第一个小于当前柱子的下标
					int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
					//右边第一个小于当前柱子的下标
					int RightLessMin = p;
					//计算面积
					int area = (RightLessMin - leftLessMin - 1) * height;
					maxArea = Math.max(area, maxArea);
				}
			}
		}
		while (!stack.isEmpty()) {
			//保存栈顶高度
			int height = heights[stack.pop()];
			//左边第一个小于当前柱子的下标
			int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
			//右边没有小于当前高度的柱子，所以赋值为数组的长度便于计算
			int RightLessMin = heights.length;
			int area = (RightLessMin - leftLessMin - 1) * height;
			maxArea = Math.max(area, maxArea);
		}
		return maxArea;
	}


}
