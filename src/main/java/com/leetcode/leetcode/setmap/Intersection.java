package com.leetcode.leetcode.setmap;

import java.util.HashSet;
import java.util.Set;

/**
 给定两个数组，编写一个函数来计算它们的交集。

    示例 1:

    输入: nums1 = [1,2,2,1], nums2 = [2,2]
    输出: [2]
    示例 2:

    输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    输出: [9,4]
    说明:

    输出结果中的每个元素一定是唯一的。
    我们可以不考虑输出结果的顺序。
*/

public class Intersection {

  public int[] intersection(int[] nums1, int[] nums2) {

    Set<Integer> re = new HashSet<Integer>();
    Set<Integer> set = new HashSet<Integer>();
    for(int i = 0;i<nums1.length;i++){
      set.add(nums1[i]);
    }
    for(int i = 0;i<nums2.length;i++){
      if(set.contains(nums2[i])){
        re.add(nums2[i]);
      }
    }
    int[] resu = new int[re.size()];
    int index = 0;
    for(int i : re){
      resu[index++] = i;
    }


    return resu;
  }
}