package com.leetcode.leetcode.linkedlist;

/**删除链表中等于给定值 val 的所有节点。

    示例:

    输入: 1->2->6->3->4->5->6, val = 6
    输出: 1->2->3->4->5*/
public class RemoveElements {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
   }
  class Solution {

    public ListNode removeElements(ListNode head, int val) {
      //创建一个虚拟头结点
      ListNode dummyNode = new ListNode(val - 1);
      dummyNode.next = head;
      ListNode prev = dummyNode;
      //确保当前结点后还有结点
      while (prev.next != null) {
        if (prev.next.val == val) {
          prev.next = prev.next.next;
        } else {
          prev = prev.next;
        }
      }
      return dummyNode.next;
    }
  }
}
