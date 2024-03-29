package com.leetcode.leetcode.tree;

/**给定一个二叉树，找出其最大深度。

    二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

    说明: 叶子节点是指没有子节点的节点。*/
public class MaxDepth {
   public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  public int maxDepth(TreeNode root) {
    if(root==null){
      return 0;
    }
    return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
  }
}
