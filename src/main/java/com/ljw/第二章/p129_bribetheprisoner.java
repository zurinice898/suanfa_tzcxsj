package com.ljw.第二章;


public class p129_bribetheprisoner {
    static int P = 20, Q = 3, A[] = {0,3,6,14,21};

    /*
    dp[i][j] := 释放【i，j】所需要的金币
    这题我的失误是把释放位置当作变量了，这样导致动态规划的状态非常多，释放位置可以由区间来决定，所以把区间作为影响结果的变量，变量数固定为2所以更好。
     */
    static int dp[][] = new int[4][5];

	public static void main(String[] args) {
		solve();
	}

     static void solve(){
     	A[0] = 0;
     	A[Q+1]  = P + 1;

     	for(int q = 0; q <= Q; q++){
     		dp[q][q+1] = 0;
        }

     	for(int w = 2; w <= Q + 1; w++){
			for(int i = 0; i + w <= Q + 1; i++){
				int j = i + w;
				int t = Integer.MAX_VALUE;
				for(int k = i + 1; k < j; k++){
					t = Integer.min(t, dp[i][k] + dp[k][j]);
				}

				dp[i][j] = t + A[j] - A[i] -2;
			}
        }
	     System.out.println( dp[0][Q + 1]);
     }

}
