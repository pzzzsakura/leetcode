package com.leetcode.leetcode.tree;

import com.leetcode.leetcode.tree.MaxDepth.TreeNode;

/**
 * @author: Ma.li.ran
 * @datetime: 2019/11/15 11:24
 * @desc:
 * @environment: jdk1.8.0_121/IDEA 2017.2.6/Tomcat8.0.47/mysql5.7
 */
public class InvertTree {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode right = invertTree(root.right);
    TreeNode left = invertTree(root.left);
    root.left = right;
    root.right = left;
    return root;
  }

}
