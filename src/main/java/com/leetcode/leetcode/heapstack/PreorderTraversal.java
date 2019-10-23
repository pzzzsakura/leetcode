package com.leetcode.leetcode.heapstack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3] 1 \ 2 / 3
 *
 * 输出: [1,2,3] 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class PreorderTraversal {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  /**
   * 递归的写法
   */

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    return add(list, root);

  }

  List<Integer> add(List<Integer> list, TreeNode t) {
    list.add(t.val);
    if (t.left != null) {
      add(list, t.left);
    }
    if (t.right != null) {
      add(list, t.right);
    }
    return list;
  }


  /**
   * 迭代遍历
   * @param root
   * @return
   */
  public List<Integer> preorderTraversal2(TreeNode root) {
    if (root == null)
      return new ArrayList<Integer>();
    Stack<TreeNode> nodeStack = new Stack<TreeNode>();
    nodeStack.push(root);
    List<Integer> list = new ArrayList<Integer>();

    while (nodeStack.size() != 0) {
      TreeNode node = nodeStack.pop();
      list.add(node.val);
      if (node.right != null)
        nodeStack.push(node.right);
      if (node.left != null)
        nodeStack.push(node.left);
    }

    return list;

  }

}