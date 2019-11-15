package com.leetcode.leetcode.tree;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 给定一个二叉树，返回所有从根节点到叶子节点的路径。

 说明: 叶子节点是指没有子节点的节点。

 示例:

 输入:

 1
 /   \
 2     3
 \
 5

 输出: ["1->2->5", "1->3"]

 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class BinaryTreePaths {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new CopyOnWriteArrayList<>();
    if(root==null){
      return res;
    }

    binaryTreePaths_helper(root,res,"");
    return res;
  }
//  值传递：
//
//  方法调用时，实际参数把它的值传递给对应的形式参数，函数接收的是原始值的一个copy，
// 此时内存中存在两个相等的基本类型，即实际参数和形式参数，
// 后面方法中的操作都是对形参这个值的修改，不影响实际参数的值。
//
//  引用传递：
//
//  也称为传地址。方法调用时，实际参数的引用(地址，
// 而不是参数的值)被传递给方法中相对应的形式参数，函数接收的是原始值的内存地址；
//  在方法执行中，形参和实参内容相同，指向同一块内存地址，
// 方法执行中对引用的操作将会影响到实际对象。
  private void binaryTreePaths_helper(TreeNode root, List<String> res, String stringBuilder) {
    stringBuilder+=root.val;
    stringBuilder+="->";
    if(root.left==null&&root.right==null){
      res.add(new String(stringBuilder).substring(0,stringBuilder.length()-2));
      return;
    }
    if(root.left!=null){
      binaryTreePaths_helper(root.left,res,stringBuilder);
    }
    if(root.right!=null){
      binaryTreePaths_helper(root.right,res,stringBuilder);
    }
  }

}
