package com.ljw.第二章;

public class p67最长公共子序列 {
	public static int n = 4;
	public static int m = 4;
	public static char[] s = {'0','a', 'b', 'c', 'd','0','a', 'b', 'c', 'd'};
	public static char[] t = {'0','b', 'e', 'c', 'd','0','a', 'b', 'c', 'd'};

	public static int[][] dp = new int[n+1][m+1];

	public static void main(String[] args) {
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= m; j++){
				int t1 = 0, t2, t3;
				t2 = dp[i-1][j];
				t3 = dp[i][j-1];
				if(s[i] == t[j]){
					t1 = dp[i-1][j-1] + 1;
				}
				dp[i][j] = Math.max(t1,Math.max(t2,t3));
			}
		}
		System.out.println(dp[n][m]);
	}

}
