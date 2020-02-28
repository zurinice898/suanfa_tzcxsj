package com.ljw.leetcode.堆;

import java.util.*;

public class topKFrequent_频率最高的k个 {





	public List<Integer> topKFrequentL(int[] nums, int k) {
		HashMap<Integer,Integer> count = new HashMap<>();
		for(int n : nums){
			count.put(n, count.getOrDefault(n, 0) + 1);
		}

		PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> count.get(a)-count.get(b));

		for(int n : count.keySet()){
			heap.offer(n);
			if(heap.size() > k){
				heap.poll();
			}
		}

		List<Integer> result = new ArrayList<>();
		while(heap.size() > 0){
			result.add(heap.poll());
		}
		Collections.reverse(result);
		return result;


	}

	public List<Integer> topKFrequent(int[] nums, int k) {
		// build hash map : character and how often it appears
		HashMap<Integer, Integer> count = new HashMap();
		for (int n: nums) {
			count.put(n, count.getOrDefault(n, 0) + 1);
		}

		// init heap 'the less frequent element first'
		PriorityQueue<Integer> heap =
				new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

		// keep k top frequent elements in the heap
		for (int n: count.keySet()) {
			heap.add(n);
			if(heap.size() > k){
				heap.poll();
			}

		}

		// build output list
		List<Integer> top_k = new LinkedList();
		while (!heap.isEmpty()){

			top_k.add(heap.poll());
		}
		Collections.reverse(top_k);
		return top_k;
	}


}
