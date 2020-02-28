package com.ljw.leetcode.堆;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest_第k大的数 {
	private int k;
	private static  PriorityQueue<Integer> heap;


	public static void main(String[] args) {
		int k = 3;
		int[] arr = {4,5,8,2};
		KthLargest_第k大的数 mm = new KthLargest_第k大的数(k,arr);
		mm.add(3);
		mm.add(5);
		mm.add(10);
		mm.add(9);
		mm.add(4);




	}
	public KthLargest_第k大的数(int k, int[] nums) {
		this.k = k;
		heap = new PriorityQueue<Integer>(k);
		for(int i : nums){
			add(i);
		}
	}

	public int add(int val) {
		if(heap.size() < k){
			heap.add(val);
		}else if(heap.peek() < val){
			heap.poll();
			heap.add(val);
		}
		return heap.peek();


	}

}
