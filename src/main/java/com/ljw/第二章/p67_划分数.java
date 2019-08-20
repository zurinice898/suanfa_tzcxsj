package com.ljw.第二章;

import java.sql.Time;
import java.util.concurrent.ConcurrentHashMap;

public class p67_划分数 {
	public static int n = 4, m = 3;

	public static int[][] dp = new int[m + 1][n + 1];

	// dp[i][j] = dp[i][j - i] + dp[i -1][j];

	public static void main(String[] args) {
		ConcurrentHashMap concurrentHashMap;
		dp[0][0]  = 1;
		for(int i = 1; i <= m; i++){
			for(int j = 0; j <= n; j++){
				if(i > j){
					dp[i][j] = dp[i -1][j];
					continue;
				}
				dp[i][j] = dp[i][j - i] + dp[i -1][j];
			}
		}
		System.out.println(dp[3][4]);
	}
}
