package com.ljw.第二章;

import java.util.ArrayList;
import java.util.List;

public class p99_二分图判定 {
	private static final int NUM = 10;
	public static List<Integer> G[] = new ArrayList[NUM];
	public static int V;
	public static int color[] = new int[NUM];

	public static void main(String[] args) {
		//1.准备图
		V = 3;
		List<Integer> lin0 = new ArrayList<>();
		lin0.add(1);
		lin0.add(2);
		G[0] = lin0;
		List<Integer> lin1 = new ArrayList<>();
		lin1.add(0);
		lin1.add(2);
		G[1] = lin1;
		List<Integer> lin2 = new ArrayList<>();
		lin2.add(0);
		lin2.add(1);
		G[2] = lin2;

		//2.solve
		solve();
	}

	 static boolean dfs(int v, int c){
		//1.给点作色
		color[v] = c;
		//2.处理相邻节点
		for(int i = 0; i < G[v].size(); i++){
			if(color[G[v].get(i)] == c){
				//冲突
				return false;
			}else if((color[G[v].get(i)] == 0) && (!dfs(G[v].get(i), -c))){
				//未着色，进行作色
				return false;
			}
		}
		return true;
	}



	static void solve(){
		for(int i = 0; i < V; i++){
			if(color[i] == 0){
				if(!dfs(i,1)){
					System.out.println("can not!!");
					return;
				}
			}
		}
		System.out.println("ok!!!");
	}

}
