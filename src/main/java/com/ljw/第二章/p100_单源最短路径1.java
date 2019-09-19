package com.ljw.第二章;

public class p100_单源最短路径1 {
	public static final int INF = Integer.MAX_VALUE;
	static edge es[] = new edge[20];
	static int d[] = new int[20];
	static int V = 7,E = 20;

	public static void main(String[] args) {
		edge ab = new edge(0,1, 2);
		edge ba = new edge(1,0, 2);
		edge ac = new edge(0,2, 5);
		edge ca = new edge(2,0, 5);
		edge bc = new edge(1,2, 4);
		edge cb = new edge(2,1, 4);
		edge bd = new edge(1,3, 6);
		edge db = new edge(3,1, 6);
		edge be = new edge(1,4, 10);
		edge eb = new edge(4,1, 10);
		edge cd = new edge(2,3, 2);
		edge dc = new edge(3,2, 2);
		edge df = new edge(3,5, 1);
		edge fd = new edge(5,3, 1);
		edge ef = new edge(4,5, 3);
		edge fe = new edge(5,4, 3);
		edge eg = new edge(4,6, 5);
		edge ge = new edge(6,4, 5);
		edge fg = new edge(5,6, 9);
		edge gf = new edge(6,5, 9);
		es[0] = ab;es[1] = ac;es[2] = bc;es[3] = bd;es[4] = be;
		es[5] = cd;es[6] = df;es[7] = ef;es[8] = eg;es[9] = fg;
		es[10] = ba;es[11] = ca;es[12] = cb;es[13] = db;es[14] = eb;
		es[15] = dc;es[16] = fd;es[17] = fe;es[18] = ge;es[19] = gf;
		shortest_path(0);
		System.out.println(d[6]);


	}

	static void shortest_path(int s){
		for(int i = 0; i < V;i++){
			d[i] = INF;
		}
		d[s]  = 0;
		while(true){
			boolean flag = false;
			for(int i = 0; i < E; i++){
				if((d[es[i].from] != INF) && ((d[es[i].from] + es[i].cost) < d[es[i].to])){
					d[es[i].to] = d[es[i].from] + es[i].cost;
					flag = true;
				}
			}
			if(!flag){
				break;
			}
		}
	}



	public static class edge{
		int from ,to, cost;

		public edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		public int getFrom() {
			return from;
		}

		public void setFrom(int from) {
			this.from = from;
		}

		public int getTo() {
			return to;
		}

		public void setTo(int to) {
			this.to = to;
		}

		public int getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}
	}
}
