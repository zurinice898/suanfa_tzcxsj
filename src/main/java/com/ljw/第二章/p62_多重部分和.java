package com.ljw.第二章;

public class p62_多重部分和 {
	public static int[] a={3, 5, 8};
	public static int[] m={3, 2, 2};
	public static int target = 17;

	public static boolean[][] dp = new boolean[4][18];
	{
		dp[0][0]  = true;
	}

	public static void main(String[] args) {
		for(int i = 0; i < 3; i++){
			for(int k = 0; k <=17; k++){
				for(int j = 0; j  <= m[i] && j*a[i] <= k; j ++ ){
						dp[i + 1][k] |= dp[i][k - j * a[i]];
				}
			}
		}

		System.out.println(dp[3][17]);
	}

}
