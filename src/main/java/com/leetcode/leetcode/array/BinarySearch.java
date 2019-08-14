package com.leetcode.leetcode.array;

/**
 * @author: Ma.li.ran
 * @datetime: 2019/08/07 15:51
 * @desc: 二分查找法  最坏时间复杂度为O(logn)，最优O(1)
 * @environment: jdk1.8.0_121/IDEA 2017.2.6/Tomcat8.0.47/mysql5.7
 */
public class BinarySearch {


  public static int BinarySearch(int[] arr, int target){
    int left = 0;    //(left..mid]
    int right = arr.length-1;//[mid..right)
     //解决整数越界问题
    while (left<right){
      int mid = left+ (right-left)/2;
      if(target<arr[mid]){
        right = mid;
      }else if(target>arr[mid]){
        left = arr[mid];
      }else{
        return mid;
      }
    }
    return -1;
  }



  public static void main(String[] args) {

    System.out.println(BinarySearch(new int[]{1,2,3,3,5,6},3));

  }


}
