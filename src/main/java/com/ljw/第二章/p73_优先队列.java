package com.ljw.第二章;

public class p73_优先队列 {


	public static int[] A = {10, 14, 20, 21};
	public static int[] B = {10, 5, 2, 4};
	public static final int P = 10;
	public static final int L = 25;

	public static void main(String[] args) {
		int hadGo = 0;
		int index = 0;
		int result = 0;
		push(P);
		while(size > 0 && hadGo < L){
			//1.加油
			hadGo += pop();
			result++;
			for(int i = index; i < A.length; i++){
				if(A[i] <= hadGo){
					push(B[i]);
					index = i + 1;
				}
			}
		}

		System.out.println((hadGo < L) ? -1 : result - 1);
	}























	public static int[] heap = new int[1000];
	public static int size = 0;

	static void  push(int x){
		int index = size++;
		int p;
		while(index > 0){
			p = (index - 1) / 2;
			if(heap[p] < x){
				heap[index] = heap[p];
				index = p;
			}else{
				break;
			}
		}

		heap[index] = x;
		return;
	}

	static int pop(){
		int result  = heap[0];
		int x = heap[--size];
		int index = 0;
		while((2 * index + 1) < size){
			int left = 2 * index + 1;
			int right = 2 * index + 2;
			if(right < size && heap[right] > heap[left]){
				left = right;
			}
			int next = left;
			if(x < heap[next]){
				heap[index]  = heap[next];
				index = next;
			}else{
				break;
			}
		}
		heap[index]  = x;
		return result;
	}



}
