package com.leetcode.leetcode.heapstack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: Ma.li.ran
 * @datetime: 2019/10/24 17:00
 * @desc:
 * @environment: jdk1.8.0_121/IDEA 2017.2.6/Tomcat8.0.47/mysql5.7
 */
public class InorderTraversal {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }


  /**
   * 递归的写法 左 根 右
   */

  public List<Integer> inorderTraversal(TreeNode root) {
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
    list.add(t.val);
    if (t.right != null) {
      add(list, t.right);
    }
    return list;
  }


 //  迭代
 public List<Integer> inorderTraversal2(TreeNode root) {
  List<Integer> list = new ArrayList<>();
  if (root == null) {
    return list;
  }
   Stack<TreeNode> stack = new Stack<>();
   TreeNode tmp = root;
   while(tmp!=null||!stack.empty()){
     while(tmp!=null){
       stack.push(tmp);
       tmp = tmp.left;
     }
     tmp = stack.pop();
     list.add(tmp.val);
     tmp = tmp.right;
   }
   return list;


}

}
