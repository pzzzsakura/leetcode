package com.leetcode.leetcode.setmap;

import java.util.HashMap;
import java.util.Map;
/**给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。

    找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。

    示例:

    输入:
    [[0,0],[1,0],[2,0]]

    输出:
    2

    解释:
    两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]*/
public class NumberOfBoomerangs {
  public int numberOfBoomerangs(int[][] points) {
    int res = 0;
    Map<Integer,Integer> map = new HashMap<Integer, Integer>();
    for(int i =0;i<points.length;i++){
      //每次把i当作第一个点
      map.clear();
      for(int j =0;j<points.length;j++){
        if(i==j){
          continue;
        }
        int distance = (points[i][0]-points[j][0])*(points[i][0]-points[j][0])+(points[i][1]-points[j][1])*(points[i][1]-points[j][1]);
        //顺序规则 需要乘2
        res += map.getOrDefault(distance,0)*2;
        map.put(distance, map.getOrDefault(distance,0)+1);
      }
    }
    return res;
  }
}
