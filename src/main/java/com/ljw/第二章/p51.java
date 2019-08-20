package com.ljw.第二章;

import java.util.ArrayList;
import java.util.List;

public class p51 {

	public static int bound = 5;
	public static List<Item> objs = new ArrayList<>();
	static {
		objs.add(new Item(2, 3));
		objs.add(new Item(1, 2));
		objs.add(new Item(3, 4));
		objs.add(new Item(2, 2));
	}
	public static int max = 0;

	public static void main(String[] args) {
		dfs(bound,3,0);
		System.out.println(max);
	}

	private static void dfs(int bound, int level, int sum) {
		if(bound <= 0 || level < 0){
			return;
		}
		if(sum > max){
			max = sum;
		}
		dfs(bound, level - 1, sum);
		if(bound - objs.get(level).weight >= 0){
			max = Math.max(max, sum + objs.get(level).value);
			dfs(bound - objs.get(level).weight, level - 1, sum + objs.get(level).value);
		}

	}


	static class Item{
		private int weight;
		private int value;

		public Item(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
	}
}

