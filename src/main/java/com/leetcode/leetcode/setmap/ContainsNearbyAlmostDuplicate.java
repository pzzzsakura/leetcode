package com.leetcode.leetcode.setmap;

import java.util.HashSet;
import java.util.TreeSet;

/**
给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。

    示例 1:

    输入: nums = [1,2,3,1], k = 3, t = 0
    输出: true
    示例 2:

    输入: nums = [1,0,1,1], k = 1, t = 2
    输出: true
    示例 3:

    输入: nums = [1,5,9,1,5,9], k = 2, t = 3
    输出: false
*/
public class ContainsNearbyAlmostDuplicate {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if(nums.length <= 1) {
      return false;
    }
    //    TreeSet（Java）数据结构使用红黑树实现，是平衡二叉树的一种。
    //    该数据结构支持如下操作：
    //    floor()方法返set中小于等于给定元素的最大元素；如果不存在这样的元素，则返回 null。
    //    ceiling()方法返回set中大于等于给定元素的最小元素；如果不存在这样的元素，则返回 null
    TreeSet<Long> set = new TreeSet<>();
    for(int i = 0; i < nums.length; i ++) {
      //在查找表中找比v-t大的最小元素，若存在且该元素小于等于v+t，说明该元素正好在[v-t,v+t]之间，符合条件
      //这里使用 long 整数类型，是因为 int 类型在 nums[i] + t 时可能会出现整形越界。
      //时间复杂度: O(nlogk)
      //空间复杂度: O(k)
      if(set.ceiling(((long)nums[i] - (long)t)) != null && set.ceiling(((long)nums[i] - (long)t)) <= (long)nums[i] + (long)t) {
        return true;
      }else {
        set.add((long) nums[i]);
        if(set.size() == k + 1) {
          set.remove((long)nums[i - k]);
        }
      }
    }
    return false;
  }

}
