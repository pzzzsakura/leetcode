package com.leetcode.leetcode.array;

import java.util.Arrays;

/**
 * @author: Ma.li.ran
 * @datetime: 2019/08/14 16:28
 * @desc:
 * @environment: jdk1.8.0_121/IDEA 2017.2.6/Tomcat8.0.47/mysql5.7
 */
public class FindKthLargest {

  public int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length-k];
  }


  public int findKthLargest2(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length-k];
  }

}
