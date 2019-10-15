package com.leetcode.leetcode.linkedlist;

/**
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

     

    示例:

    给定 1->2->3->4, 你应该返回 2->1->4->3.*/
public class SwapPairs {

  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

  public ListNode swapPairs(ListNode head) {
    //设置虚拟头节点
    ListNode pre = new ListNode(0);
    pre.next = head;
    ListNode temp = pre;
    while(temp.next != null && temp.next.next != null) {
      ListNode start = temp.next;
      ListNode end = temp.next.next;
      temp.next = end;
      start.next = end.next;
      end.next = start;
      temp = start;
    }
    return pre.next;
  }
}
