package com.leetcode.leetcode.array;


/**
 * @author: Ma.li.ran
 * @datetime: 2019/07/24 22:20
 * @desc: 两数相加
 *
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are
 * stored in reverse order and each of their nodes contain a single digit. Add the two numbers and
 * return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 + 465 = 807.
 */
public class AddTwoSum {



  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    //初始化一个两结点相加的固定节点
    ListNode dummy = new ListNode(-1);
    //临时第一个节点
    ListNode cur = dummy;
    //判断是否有相加超过10，有则进一位
    int carry = 0;

    while (l1 != null || l2 != null) {
      //l1和l2的起始节点，如果为空则为0
      int d1 = l1 == null ? 0 : l1.val;
      int d2 = l2 == null ? 0 : l2.val;
      //carry 为上次相加 1进位
      int sum = d1 + d2 + carry;
      //此次相加是否像下一次进位
      carry = sum >= 10 ? 1 : 0;
      //此次相加节点的数字
      cur.next = new ListNode(sum % 10);
      //临时节点下次从此节点开始
      cur = cur.next;
      if (l1 != null) l1 = l1.next;
      if (l2 != null) l2 = l2.next;
    }
    if (carry == 1) cur.next = new ListNode(1);
    //返回最初的固定父节点
    return dummy.next;
  }


  //定义链表类，只有值和下个节点
  class ListNode{

    private int val;

    private ListNode next;

    ListNode(int val){
      this.val = val;
    }

  }

}
