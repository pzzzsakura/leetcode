package com.leetcode.leetcode.array;

/**给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

    说明:

    初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
    你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
    示例:

    输入:
    nums1 = [1,2,3,0,0,0], m = 3
    nums2 = [2,5,6],       n = 3

    输出: [1,2,2,3,5,6]

    链接：https://leetcode-cn.com/problems/merge-sorted-array*/
public class Merge {

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    //因为nums1足够大，所以从两数组末尾定义两个指针,不占用多余空间
    int p1 = m-1;
    int p2 = n-1;
    int p = m+n-1;

    //从最后一个元素开始，比较两个数组大小
    //有序元素，第一次比较肯定会有最大的出现
    while(p1>=0&&p2>=0){
      nums1[p--] = (nums1[p1]<nums2[p2])?nums2[p2--]:nums1[p1--];
    }

    //因为nums1[]初始元素还在，不怕p2 = 0 ,所以当p1 = 0时就截止循环了可能会有剩余的nums2元素
    if(p2>=0){
      System.arraycopy(nums2,0,nums1,0,p2+1);
    }

    for(int i : nums1){
      System.out.println(i);
    }

  }

  public static void main(String[] args) {
    new Merge().merge(new int[]{1,2,3,0},2,new int[]{1,2,4},2);
  }
}
