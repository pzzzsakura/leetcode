package com.leetcode.leetcode.heapstack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

    示例 1:

    输入: nums = [1,1,1,2,2,3], k = 2
    输出: [1,2]
    示例 2:

    输入: nums = [1], k = 1
    输出: [1]
    说明：

    你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
    你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
*/
public class TopKFrequent {

  public List<Integer> topKFrequent(int[] nums, int k) {
    List<Integer> res = new ArrayList<>();
    //维护每个元素次数
    Map<Integer,Integer> map = new HashMap<>();
    for(int i : nums){
      map.put(i,map.getOrDefault(i,0)+1);
    }
    //优先队列
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>((a,b) -> map.get(a) - map.get(b));
    for(Map.Entry entry : map.entrySet()){
      priorityQueue.add((Integer) entry.getKey());
      if(priorityQueue.size()>k) {
        priorityQueue.poll();
      }
    }
    while (!priorityQueue.isEmpty()) res.add(priorityQueue.poll());
    return res;
  }


}
