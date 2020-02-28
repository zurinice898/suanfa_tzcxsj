package com.ljw.leetcode;

import java.util.*;

public class He合并ksorted列表 {

//[[1,4,5],[1,3,4],[2,6]]
	public static void main(String[] args) {
		LinkedList<Integer> lindedList = new LinkedList<>();
		lindedList.push(1);
		lindedList.pop();
		lindedList.addLast(1);
		lindedList.removeFirst();
		lindedList.peek();


		ListNode[] lists = new ListNode[3];

		ListNode _1 = new ListNode(1);
		ListNode _4 = new ListNode(4);
		ListNode _5 = new ListNode(5);
		_1.next = _4;
		_4.next = _5;
		lists[0] = _1;

		ListNode _21 = new ListNode(1);
		ListNode _23 = new ListNode(3);
		ListNode _24 = new ListNode(4);
		_21.next = _23;
		_23.next = _24;
		lists[1] = _21;

		ListNode _32 = new ListNode(2);
		ListNode _36 = new ListNode(6);
		_32.next = _36;
		lists[2] = _32;


		ListNode result = new He合并ksorted列表().mergeKLists(lists);

	}


static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0){
			return null;
		}
		int length = lists.length;
		// 进行合并操作
		while(length > 1){
			int i = 0, j = length - 1;
			while(i < j){
				ListNode temp = mergeTwoList(lists[i], lists[j]);
				lists[i]  = temp;
				lists[j]  = null;
				length--;
				i++;
				j--;
			}
		}

		return lists[0];
	}

	ListNode mergeTwoList(ListNode a, ListNode b){
		if(a == null){
			return b;
		}

		if(b == null){
			return a;
		}

		ListNode rst = null, cur = null;

		//初始化rst
		if(a.val < b.val){
			rst = a;
			a = a.next;
		}else{
			rst = b;
			b = b.next;
		}
		cur = rst;

		while(a != null && b != null){

			if(a.val < b.val){
				cur = cur.next = a;
				a = a.next;
			}else{
				cur = cur.next = b;
				b = b.next;
			}

		}

		if(a != null){
			cur.next = a;
		}

		if(b != null){
			cur.next = b;
		}

		return rst;
	}
}
