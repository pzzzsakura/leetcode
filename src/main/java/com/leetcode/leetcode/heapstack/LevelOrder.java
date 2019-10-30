package com.leetcode.leetcode.heapstack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

    例如:
    给定二叉树: [3,9,20,null,null,15,7],

    3
    / \
    9  20
    /  \
    15   7
    返回其层次遍历结果：

    [
    [3],
    [9,20],
    [15,7]
    ]*/

public class LevelOrder {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new LinkedList<>();
    if (root == null) {
      return res;
    }

    Deque<TreeNode> deque = new ArrayDeque();
    deque.add(root);
    while (!deque.isEmpty()) {
      List<Integer> integers = new ArrayList<>();
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        TreeNode treeNode = deque.poll();
        integers.add(treeNode.val);
        if (treeNode.left != null) {
          deque.add(treeNode.left);
        }
        if (treeNode.right != null) {
          deque.add(treeNode.right);
        }
      }
      res.add(integers);
    }
    return res;
  }
}
