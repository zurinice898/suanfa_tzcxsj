package com.ljw.第二章;

public class p61_01背包 {
	public static int n = 4;
	public static int[] w = {2,1,3,2};
	public static int[] v = {3,2,4,2};
	public static int bound = 5;
	public static int[][] dp = new int[5][6];


	/**
	 *
	 * dp[i + 1][j] =
	 * 1.dp[i][j] j < w[i]
	 * 2.max{d[i ][j], dp[i][j - w[i]] + v[i]}
	 */
	public static void main(String[] args) {
		for(int i = 0; i < n; i++){
			for(int j = 0; j <= bound; j++){
				if(j < w[i]){
					dp[i + 1][j] = dp[i][j];
				}else {
					dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - w[i]] + v[i]);
				}
			}
		}

		System.out.println(dp[4][5]);
	}
}
