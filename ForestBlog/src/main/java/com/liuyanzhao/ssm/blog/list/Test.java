package com.liuyanzhao.ssm.blog.list;

/**
 * @author lhzlhz
 * @create 2020/3/4
 */
public class Test {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		//ListNode l6 = new ListNode(6);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		//l5.next = l6;

		reorderList(l1);
	}

	public static void print(ListNode node) {
		if (node == null) {
			return;
		}
		System.out.println(node.val);
		print(node.next);
	}


	public static void reorderList(ListNode head) {
		if(head==null||head.next==null|| head.next.next == null) return;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy;
		ListNode fast = dummy;
		while(fast.next!=null&&fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}

		fast = slow.next;
		slow.next = null;
		slow = dummy.next;
		//反转后半部分
		ListNode pre = null;
		while(fast!=null){
			ListNode next = fast.next;
			fast.next= pre;
			pre = fast;
			fast = next;
		}
		//拼接
		while(pre!=null){
			ListNode w = pre.next;
			pre.next = slow.next;
			slow.next = pre;
			slow = pre.next;
			pre = w;
		}
	}
}
