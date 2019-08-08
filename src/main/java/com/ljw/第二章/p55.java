package com.ljw.第二章;

public class p55 {
	public static void main(String[] args) {
		int R = 10;
		int[] X = new int[]{1, 7, 15, 20, 30, 50};
		System.out.println(solve(X, R));
	}

	private static int solve(int[] x, int r) {
		int result = 0;

		for (int index = 0; index < x.length;){
			//1.选点
			int bound = x[index] + r;
			int mark = -1;

			for(int i = index+1; i < x.length; i++){
				//寻找标记点
				if(x[i] <= bound){
					mark = i;
				}else {
					break;
				}
			}

			if(mark == -1){
				System.out.println(x[index]);
				index++;
			}else if(mark == x.length -1){
				System.out.println(x[mark]);
				index = x.length;
			}else{
				System.out.println(x[mark]);
				index = mark;
				do{
					mark++;
					if(!(x[mark] - x[index] <= r)){
						break;
					}
				}while(mark < x.length);
				index = mark + 1;

			}
			result++;
		}

		return result;

	}
}
