package com.leetcode.leetcode.linkedlist;

/**反转一个单链表。

    示例:

    输入: 1->2->3->4->5->NULL
    输出: 5->4->3->2->1->NULL*/

public class ReverseList {

  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


    public ListNode reverseList(ListNode head) {
      ListNode curNode = head;
      //当前节点下一个节点值为此
      ListNode newxNode = null;
      while(curNode!=null){
        //保存当前节点下一个节点
        ListNode tempNode = curNode.next;
        curNode.next = newxNode;
        //变量保存为当前节点的上一个节点
        newxNode = curNode;
        //循环到下一个节点
        curNode = tempNode;
      }
      return newxNode;
    }
}