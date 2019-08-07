package com.leetcode.leetcode;

import java.util.ArrayList;

/**
    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    示例:
    输入: [0,1,0,3,12]
    输出: [1,3,12,0,0]
    说明:
    必须在原数组上操作，不能拷贝额外的数组。
    尽量减少操作次数。
    链接：https://leetcode-cn.com/problems/move-zeroes
    */
public class MoveZeros {
  // 时间复杂度: O(n)
  // 空间复杂度: O(n)
  public void moveZeroes(int[] nums) {
    ArrayList<Integer> nonZeroElements = new ArrayList<Integer>();

    // 将vec中所有非0元素放入nonZeroElements中
    for(int i = 0 ; i < nums.length ; i ++)
      if(nums[i] != 0)
        nonZeroElements.add(nums[i]);

    // 将nonZeroElements中的所有元素依次放入到nums开始的位置
    for(int i = 0 ; i < nonZeroElements.size() ; i ++)
      nums[i] = nonZeroElements.get(i);

    // 将nums剩余的位置放置为0
    for(int i = nonZeroElements.size() ; i < nums.length ; i ++)
      nums[i] = 0;
  }

  // 时间复杂度: O(n)
  // 空间复杂度: O(1)
  public void moveZeroes2(int[] nums) {

    int k = 0; // nums中, [0...k)的元素均为非0元素
    for(int i=0;i<nums.length;i++){
      //如果当前元素不等于0则依次放入k在k++ ，如等于0则不对k操作，i进行下一次
      if(nums[i]==0){
        nums[k++] = nums[i];
      }
    }
    //再把其余补0
    for(int i=k;i<nums.length;i++){
      nums[i] = 0;
    }

  }


  public void moveZeroes3(int[] nums) {

    int k = 0; // nums中, [0...k)的元素均为非0元素

    // 遍历到第i个元素后,保证[0...i]中所有非0元素
    // 都按照顺序排列在[0...k)中
    // 同时, [k...i] 为 0
    for(int i = 0 ; i < nums.length ; i ++)
      if(nums[i] != 0)
        swap(nums, k++, i);
  }

  private void swap(int[] nums, int i, int j){
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
  }


  public void moveZeroes4(int[] nums) {

    int k = 0; // nums中, [0...k)的元素均为非0元素

    // 遍历到第i个元素后,保证[0...i]中所有非0元素
    // 都按照顺序排列在[0...k)中
    // 同时, [k...i] 为 0
    for(int i = 0 ; i < nums.length ; i ++)
      if(nums[i] != 0){
        if(i!=k){
          swap(nums, k++, i);
        }else{
          //省去自己和自己交换的步骤
          k++;
        }
      }
  }


}
