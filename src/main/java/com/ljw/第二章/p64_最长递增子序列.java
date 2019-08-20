package com.ljw.第二章;

/**
 * dp[i] =  maxof
 * dp[n-1]
 * dp[j] 且 nj < ni
 *
 */
public class p64_最长递增子序列 {
	public static int[] a= {1,2,3,21,22,23,4,5,6,11};
	public static int[] dp = new int[10];
	static{
		for(int i = 0; i < 10; i++){
			dp[i] = 1;
		}
	}
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++){
			for(int j = i + 1; j < 10; j++){
				if(a[i] < a[j]){
					dp[j] = Math.max(dp[j], dp[i] + 1);
					dp[j] = Math.max(dp[j], dp[j -1]);
				}

			}
		}

		System.out.println(dp[9]);
	}
}
