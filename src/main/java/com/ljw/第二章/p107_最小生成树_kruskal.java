package com.ljw.第二章;

import java.util.Arrays;

public class p107_最小生成树_kruskal {


	private static edge es[] = new edge[10];
	int V, E;

	int kruskal(){
		Arrays.sort(es);
		BiChaJi.init(V);
		int res = 0;
		for(int i = 0; i < E; i++){
			edge e = es[i];
			if(BiChaJi.same(e.u, e.v)){
				continue;
			}
			BiChaJi.unite(e.u, e.v);
			res += e.cost;
		}
		return res;
	}



	public class edge implements  Comparable<edge>{
		int u, v, cost;

		public edge(int u, int v, int cost) {
			this.u = u;
			this.v = v;
			this.cost = cost;
		}


		@Override
		public int compareTo(edge o) {
			return this.cost - o.cost;
		}
	}


	public static class BiChaJi{
		public static int par[] = new int[50];
		public static int rank[] = new int[50];

		public static void  init(int V){
			for(int i = 0; i < V; i++){
				par[i] = i;
				rank[i] = 0;
			}
		}

		public static int find(int x){
			if(par[x] == x){
				return x;
			}else{
				return par[x] = find(par[x]);
			}
		}

		public static void unite(int x, int y){
			x = find(x);
			y = find(y);
			if(x == y){
				return ;
			}else if(rank[x] < rank[y]){
				par[x] = y;
			}else{
				par[y] = x;
				if(rank[x] == rank[y]){
					rank[x]++;
				}
			}
		}

		public static boolean same(int x, int y){
			return find(x) == find(y);
		}

	}
}


