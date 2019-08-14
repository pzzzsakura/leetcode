package com.leetcode.leetcode.array;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of
 * the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue
 * respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0] Output: [0,0,1,1,2,2] Follow up:
 *
 * A rather straight forward solution is a two-pass algorithm using counting sort. First, iterate
 * the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's,
 * then 1's and followed by 2's. Could you come up with a one-pass algorithm using only constant
 * space?
 */
public class SortColor {

  // 时间复杂度: O(n)
  // 空间复杂度: O(k), k为元素的取值范围
  // 计数排序的思路
  // 对整个数组遍历了两遍
  public void SortColor1(int[] nums) {
    //三种颜色，定义每种颜色出现的频率
    int[] count = new int[]{0, 0, 0};

    for (int i = 0; i < nums.length; i++) {
      count[nums[i]]++;
    }

    //然后依次将三种颜色按顺序填充到nums中
    int index = 0;
    for (int i = 0; i < count[0]; i++) {
      nums[index++] = 0;
    }
    for (int i = 0; i < count[1]; i++) {
      nums[index++] = 1;
    }
    for (int i = 0; i < count[2]; i++) {
      nums[index++] = 2;
    }

  }


  // 时间复杂度: O(n)
  // 空间复杂度: O(1)
  // 三路快速排序的思想
  // 对整个数组只遍历了一遍
  public void sortColor2(int[] nums) {
    //三种，定义两个边界
    int first = -1; //[0...i]
    int second = nums.length; //[i...second)
    //从开始判断中间的颜色，小于则与前者置换，大于则与后者置换，直到遍历完成
    for(int i=0;i<second;){
      if(nums[i]==1){
        i++;
      }else if(nums[i]==2){
        second--;
        swap(nums,second,i);
      }else{
        first++;
        swap(nums,first,i++);
      }
    }

  }

  private void swap(int[] nums, int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
  }

  public static void printArr(int[] nums) {
    for (int num : nums) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {

    int[] nums = {0,2, 1, 2, 2,2, 2, 2,2,1, 0 ,2,0};
    (new SortColor()).sortColor2(nums);
    printArr(nums);
  }
}
