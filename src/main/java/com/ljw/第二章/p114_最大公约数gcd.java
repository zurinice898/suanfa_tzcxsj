package com.ljw.第二章;

public class p114_最大公约数gcd {

	public static void main(String[] args) {
		System.out.println(ged(1324,1345));
	}

	static int ged(int a, int b){
		if(b == 0){
			return a;
		}
		return ged(b, a % b);
	}
}
