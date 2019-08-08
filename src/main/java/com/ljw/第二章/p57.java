package com.ljw.第二章;

public class p57 {
	static int[] l = {3, 4, 5, 1, 2};
	static int[][] temp = new int[l.length+1][l.length+1];
	static {
		for(int i  = 0; i < temp.length; i++){
			for(int j = 0; j < temp[i].length; j++){
				if(i - j >= -1){
					temp[i][j] = 0;
				}else{
					temp[i][j] = -1;
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(solve(0,l.length));
	}

	private static int solve(int start, int end) {
		if(temp[start][end] != -1){
			return temp[start][end];
		}
		int result = Integer.MAX_VALUE;
		for(int i = start+1; i < end; i++){
			result = Math.min(result, solve(start,i) + solve(i, end) + getLength(start,end));
		}
		temp[start][end] = result;
		return result;
	}

	private static int getLength(int start, int end) {
		int sum = 0;
		for(int i = start; i < end; i++){
			sum += l[i];
		}
		return sum;
	}



}
