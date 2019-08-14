package com.leetcode.leetcode.array;


/**给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

    不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

    元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

    示例 1:

    给定 nums = [3,2,2,3], val = 3,

    函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

    你不需要考虑数组中超出新长度后面的元素。
    示例 2:

    给定 nums = [0,1,2,2,3,0,4,2], val = 2,

    函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。

    注意这五个元素可为任意顺序。

    你不需要考虑数组中超出新长度后面的元素。

    链接：https://leetcode-cn.com/problems/remove-element*/
public class RemoveElement {
  public int removeElement(int[] nums, int val) {
    int k = 0;
    for(int i=0;i<nums.length;i++){
      if(nums[i]!=val){
        nums[k++] = nums[i];
      }

    }
    for(int l:nums){
      System.out.println(l);
    }

    return k;
  }

  /**
   * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

   不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

   示例 1:

   给定数组 nums = [1,1,2],

   函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

   你不需要考虑数组中超出新长度后面的元素。
   示例 2:

   给定 nums = [0,0,1,1,1,2,2,3,3,4],

   函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

   你不需要考虑数组中超出新长度后面的元素。
   链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
   */
  public int removeDuplicates(int[] nums) {
    int k = 0;
    for(int i=1;i<nums.length;i++){
      if(nums[k]!=nums[i]){
        nums[++k] = nums[i];
      }
    }
    for(int l:nums){
      System.out.println(l);
    }
    return k+1;
  }
/**  给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。

  不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

  示例 1:

  给定 nums = [1,1,1,2,2,3],

  函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。

  你不需要考虑数组中超出新长度后面的元素。
  示例 2:

  给定 nums = [0,0,1,1,1,1,2,3,3],

  函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。

  你不需要考虑数组中超出新长度后面的元素。

  链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii*/
  public int removeDuplicates2(int[] nums) {
    int k = 1;
    for(int i=2;i<nums.length;i++){
      if(nums[k-1]!=nums[i]){
        nums[++k] = nums[i];
      }
    }
    return k+1;
  }

  public static void main(String[] args) {
    System.out.println(new RemoveElement().removeDuplicates(new int[]{1,1,2}));
  }
}
