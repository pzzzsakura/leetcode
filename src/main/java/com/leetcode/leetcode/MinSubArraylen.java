package com.leetcode.leetcode;

/**给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。

    示例: 

    输入: s = 7, nums = [2,3,1,2,4,3]
    输出: 2
    解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。

    链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum*/
public class MinSubArraylen {

  //循环遍历
  //时间复杂度(n^2)
  public int minSubArrayLen(int s, int[] nums) {
    if(nums.length==0)return 0;
    int result = nums.length+1;
    int sum = 0;
    for(int i=0;i<nums.length;i++){
      for(int j=i;j<nums.length;j++){
        if(i==j){//是本身直接返回
          sum = nums[i];
        }else{
          sum = sum+nums[j];
        }
        if(sum >= s){
          if(result>(j-i)){
            result = (j-i);
          }
        }
      }
    }
    if(result==nums.length+1){
      return 0;
    }
    return result+1;
  }


  //滑动窗口
  //O(n)
  public int minSubArrayLen2(int s, int[] nums) {
    int n = nums.length;
    int ans = Integer.MAX_VALUE;
    int left = 0;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += nums[i];
      while (sum >= s) {
        ans = Math.min(ans, i + 1 - left);
        sum -= nums[left++];
      }
    }
    return (ans != Integer.MAX_VALUE) ? ans : 0;
  }








  public static void main(String[] args) {

    System.out.println(new MinSubArraylen().minSubArrayLen2(16,new int[]{1,2,13,14,15}));



  }

}
