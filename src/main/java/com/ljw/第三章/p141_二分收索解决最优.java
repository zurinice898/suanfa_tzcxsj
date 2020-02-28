package com.ljw.第三章;

public class p141_二分收索解决最优 {
	static int N = 4, K = 6;
	static double[] L = new double[N];

	static boolean C(double x){
		int sum  =0;
		for(int i =0; i < N; i++){
			sum += (int)(L[i] / x);
		}
		return sum >= K;
	}

	static void  solve(){
		double lb = 0, ub = Integer.MAX_VALUE, mid = (lb + ub) / 2;
		while((ub - lb) > 0.01f){
			if(C(mid)){
				lb = mid;
			}else{
				ub = mid;
			}

		}

	}
}
