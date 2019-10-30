package com.leetcode.leetcode.heapstack;

import java.util.LinkedList;
import java.util.Queue;

/**给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

    示例 1:

    输入: n = 12
    输出: 3
    解释: 12 = 4 + 4 + 4.
    示例 2:

    输入: n = 13
    输出: 2
    解释: 13 = 4 + 9.*/

//    从n到0每个数字代表一个节点;
//    如果两个数 x 到 y 相差一个完全平方数则连接一条边
//    我们就得到了一个无权图
//    原来的问题就转化为在这个无权图中找出从 n 到 0 的最短路径需要 BFS 来完成
public class NumSquares {
  class Node {
    int val;
    int step;

    public Node(int val, int step) {
      this.val = val;
      this.step = step;
    }
  }
  public int numSquares(int n) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(n, 0));
    // 其实一个真正的图的 BSF 是一定会加上 visited 数组来过滤元素的
    boolean[] visited = new boolean[n+1];
    while (!queue.isEmpty()) {
      int num = queue.poll().val;
      int step = queue.poll().step;
      for (int i = 1; ; i++) {
        //例如13 可以有1 4 9 ，得到12 9 4 节点再继续进行bfs遍历，等于0时为最短的。
        int a = num - i * i;
        if (a < 0) {
          break;
        }
        // 若 a 已经计算到 0 了，就不必再往下执行了
        if (a == 0) {
          return step + 1;
        }
        if (!visited[a]) {
          queue.add(new Node(a, step + 1));
          visited[a] = true;
        }
      }
    }
    return -1;
  }

}
