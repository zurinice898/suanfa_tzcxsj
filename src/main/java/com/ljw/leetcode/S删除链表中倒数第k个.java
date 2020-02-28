package com.ljw.leetcode;

public class S删除链表中倒数第k个 {


	/**
	 * [1,2,3,4,5]
	 * 2
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		new S删除链表中倒数第k个().removeNthFromEnd(n1,2);

	}

	static class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null){
			return null;
		}

		ListNode p1 = head;
		ListNode p2 = p1.next;
		for(int i = 0; i < n; i++){
			if(i == 0){
				p2  = p1.next;
			}else {
				p2 = p2.next;
			}
			if(p2 == null){
				return p1;
			}
		}

		while(p2.next != null){
			p1 = p1.next;
			p2 = p2.next;
		}

		p1.next = p1.next.next;
		return head;


	}
}
