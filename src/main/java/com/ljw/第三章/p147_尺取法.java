package com.ljw.第三章;


public class p147_尺取法 {
	private static int S = 11;
	private static int[] a = {1,2,3,4,5};

	public static void main(String[] args) {
		System.out.println(solve());
	}

	private static int solve() {
		int start = 0, end = 0, sum = 0;
		int result = a.length + 1;
		while(start < a.length){
			while((end < a.length) && sum < S){
				sum += a[end++];
			}
			if( sum < S ){
				break;
			}
			result = Math.min(result, end - start);
			sum -= a[start++];
		}
		return result;
	}
}
