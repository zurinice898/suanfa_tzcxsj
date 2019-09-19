package com.ljw.第二章;

public class p101_单元最短路径2 {
	public static final int inf = Integer.MAX_VALUE;
	static int cost[][]  = new int[7][7];
	static int d[] = new int[7];
	static boolean used[] = new boolean[7];
	static int V = 7;


	static  void dijkstra(int s){
		//1.初始化
		for(int i =0; i < d.length; i++){
			d[i] = inf;
			used[i] = false;
		}
		d[s] = 0;
		while(true){
			int houxuan = -1;
			//找到最小值
			for(int i = 0; i < used.length; i++){
				if((!used[i]) && ((houxuan == -1) || (d[houxuan] > d[i]))){
					houxuan = i;

				}
			}

			if(houxuan == -1){
				break;
			}
			used[houxuan] = true;
			for(int i = 0; i < V; i++){
				if((d[houxuan] + cost[houxuan][i]) < d[i]){
					d[i] = d[houxuan] + cost[houxuan][i];
				}
			}
		}
	}

}
