package com.ljw.第二章;

public class p87_并查集 {
	public static int[] par = new int[50];
	public static int[] rank= new int[50];

	void init(int n){
		for(int i = 0; i < n; i++){
			par[i] = i;
			rank[i] = 0;
		}
	}

	int find(int x){
		if(par[x] == x){
			return x;
		}else{
			return par[x] = find(par[x]);
		}
	}

	void unite(int x, int y){
		x = find(x);
		y = find(y);

		if(x == y){
			return;
		}else if(rank[x] < rank[y]){
			par[x] = y;
		}else{
			par[y] = x;
			if(rank[x] == rank[y]){
				rank[x]++;
			}
		}
	}

	boolean same(int x, int y){
		return find(x) == find(y);
	}

}
