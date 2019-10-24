package com.leetcode.leetcode.heapstack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**给定一个二叉树，返回它的 后序 遍历。

    示例:

    输入: [1,null,2,3]
    1
    \
    2
    /
    3

    输出: [3,2,1]*/
public class PostorderTraversal {

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

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    return add(list, root);

  }

  List<Integer> add(List<Integer> list, TreeNode t) {
    if(t.left!=null){
      add(list, t.left);
    }
    if (t.right != null) {
      add(list, t.right);
    }
    list.add(t.val);
    return list;
  }




  //迭代
  //前序遍历是 根左右，我们把入站操作左右取反，变成根右左，再逆序输出，就是后序 左右根。。
  public List<Integer> postorderTraversal2(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if(root==null){
      return list;
    }
    Stack<TreeNode> treeNode = new Stack<TreeNode>();
    treeNode.push(root);
    while(!treeNode.empty()){
      TreeNode tmp = treeNode.pop();
      list.add(0,tmp.val);
      if(tmp.left!=null){
        treeNode.push(tmp.left);
      }
      if(tmp.right!=null){
        treeNode.push(tmp.right);
      }
    }
    return list;
  }

}
