package com.java.Recursion;

public class ReverseLinkedList {
	static ListNode res = new ListNode(-1);

	public static void main(String[] args) {

		ListNode head = new ListNode(0);
		ListNode l1 = new ListNode(1);
		head.next = l1;
		ListNode l2 = new ListNode(2);
		l1.next = l2;
		ListNode l3 = new ListNode(3);
		l2.next = l3;
		ListNode l4 = new ListNode(4);
		l3.next = l4;
		printList(head);
		ListNode temp = reverseList(head);
		printList(temp);
	}

	private static ListNode reverseList(ListNode head) {
		if (head.next == null) {
			return head;
		}
		ListNode temp = reverseList(head.next);
		
		head.next.next = head;
		head.next = null;
		return temp;
	}

	private static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val);
			head = head.next;
		}
		System.out.println();
	}

}
