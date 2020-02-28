package com.ljw.第二章;

public class p106_最小生成树1 {
	private static final int maxNums = 10;
	private static final int inf = Integer.MAX_VALUE;
	public static int cost[][] = new int[maxNums][maxNums];
	private static int mincost[] = new int[maxNums];
	private static boolean used[] = new boolean[maxNums];
	int V;

	int prim(){
		//1.初始化
		for(int i = 0; i < V; i++){
			mincost[i] = inf;
			used[i] = false;
		}
		mincost[0] = 0;
		int res = 0;

		while(true){
			//1.选点
			int v = -1;
			for(int i = 0; i < V; i++){
				if(!used[i] && (v == -1 || (mincost[i] < mincost[v])) ){
					v = i;
				}
			}
			//2.加入
			if(v == -1){
				break;
			}
			used[v] = true;
			res += mincost[v];
			for(int i = 0; i < V; i++){
				mincost[i] = Math.min(mincost[i], cost[v][i]);
			}
		}
		return res;
	}

}
