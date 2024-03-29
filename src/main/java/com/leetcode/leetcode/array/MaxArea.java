package com.leetcode.leetcode.array;

/**给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

    说明：你不能倾斜容器，且 n 的值至少为 2。



    图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

     

    示例:

    输入: [1,8,6,2,5,4,8,3,7]
    输出: 49

    链接：https://leetcode-cn.com/problems/container-with-most-water*/
public class MaxArea {

  public int maxArea(int[] height) {

    int max = 0;
    for(int i = 0;i<height.length;i++){
      for(int j = height.length-1;j>i;j--){
        int t = (j-i)*((height[i]<height[j])?height[i]:height[j]);
        max = Math.max(max,t);
      }

    }
    return max;
  }

  public int maxArea2(int[] height) {

    int maxarea = 0, l = 0, r = height.length - 1;
    while (l < r) {
      maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
      //当移动大的线时，受小线高度限制，面积只能更小，所以舍弃
      if (height[l] < height[r])
        l++;
      else
        r--;
    }
    return maxarea;
  }
}
