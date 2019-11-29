package com.leetcode.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 给定一个没有重复数字的序列，返回其所有可能的全排列。

 示例:

 输入: [1,2,3]
 输出:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 */
public class Permute {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    boolean[] visited = new boolean[nums.length];
    if(nums.length==0){
      return res;
    }
    permuteHelper(res,nums,0,tmp,visited);
    return res;
  }


  private void permuteHelper(List<List<Integer>> res,int[] nums,int index,List<Integer> tmp,boolean[] visited){
    if(index==nums.length){
      //add 复制对象
      res.add(new ArrayList<>(tmp));
      return;
    }
    for(int i = 0 ;i<nums.length;i++){
        if(!visited[i]){
          visited[i] = true;
          tmp.add(nums[i]);
          permuteHelper(res,nums,index+1,tmp,visited);
          //回溯到初始状态
          visited[i]=false;
          tmp.remove(tmp.size()-1);
        }
    }
  }


//  public static void main(String[] args) {
//    List<List<Integer>> res = new ArrayList<>();
//    List<Integer> tmp = new ArrayList<>();
//    tmp.add(1);
//    res.add(new ArrayList<>(tmp));
//    tmp.remove(0);
//    res.stream().forEach(ls->ls.forEach(System.out::println));
//    }
}
