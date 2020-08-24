package tw.com.bill.leecode.easy;


import java.util.ArrayList;

import tw.com.bill.leecode.easy.MergeTwoSortedList.ListNode;


public class MergeTwoSortedList {
	
	 public class ListNode {
		    int val;
		    ListNode next;
		    ListNode() {}
		    ListNode(int val) { this.val = val; }
		    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public static void main(String[] args) {
		
	}

	public static ListNode mergeTwoLists(ListNode l1,ListNode l2) {		
		if(l1==null) return l2;
		if(l2==null) return l1;
		
		if(l1.val<l2.val) {//當L1當前的鍵值，比L2當前的鍵值小，則鍵入l2當前的鍵值進入實例
			l1.next =mergeTwoLists(l1.next, l2);
			return l1;
		}else {
			l2.next=mergeTwoLists(l1,l2.next);
			return l2;
		}
		
	}
}
