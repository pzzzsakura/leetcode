package com.leetcode.leetcode;

/**给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

    你的算法时间复杂度必须是 O(log n) 级别。

    如果数组中不存在目标值，返回 [-1, -1]。

    示例 1:

    输入: nums = [5,7,7,8,8,10], target = 8
    输出: [3,4]
    示例 2:

    输入: nums = [5,7,7,8,8,10], target = 6
    输出: [-1,-1]

    链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array*/
public class SearchRange {

  //将所有数字遍历一遍，O(n)
  public int[] searchRange(int[] nums, int target) {
    int[] result = new int[]{-1,-1};
  for(int l=0;l< nums.length;l++){
    if(target==nums[l]){
      if(result[0]==-1){
        result[0] = l;
        result[1] = l;
      }else{
        result[1] = l;
      }
    }
  }
    return result;
  }

  public int[] searchRange2(int[] nums, int target) {
    int left = 0;
    int right = nums.length;
//    二分法找到一个元素
    int flag = helper(left,right,nums,target);
    //判断这个元素左右是否还有元素得到左右索引
    int l = flag ;
    int r = flag ;
    while(l>=1&&nums[l-1]==target){
      l--;
    }
    while(r<nums.length-1&&nums[r+1]==target){
      r++;
    }
    return new int[]{l,r};
    }


    int helper(int left,int right,int[] nums,int target){
    while(left<right){
      int mid = left + (right-left)/2;
        if(nums[mid]== target){
          return mid;
        }else if (nums[mid]<target){
          left = mid+1;
        }else{
          right = mid;
        }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{5,7,7,8,8,10};
    int[] re = new SearchRange().searchRange2(nums,11);
    for(int i:re){
      System.out.println(i);
      System.out.println();
    }
  }
}
