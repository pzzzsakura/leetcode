package com.leetcode.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

 示例:

 输入: n = 4, k = 2
 输出:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */
public class Combine {

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    if (n <= 0 || k <= 0 || n < k) {
      return result;
    }
    findCombinations(result,n, k, 1, new Stack<>());
    return result;
  }

  // p 可以声明成一个栈
  // i 的极限值满足： n - i + 1 = (k - pre.size())。
  // 【关键】n - i + 1 是闭区间 [i,n] 的长度。
  // k - pre.size() 是剩下还要寻找的数的个数。
  private void findCombinations(List<List<Integer>> result,int n, int k, int index, Stack<Integer> p) {
    if (p.size() == k) {
      result.add(new ArrayList<>(p));
      return;
    }
    for (int i = index; i <= n - (k - p.size()) + 1; i++) {
      p.push(i);
      findCombinations(result,n, k, i + 1, p);
      p.pop();
    }
  }
}
