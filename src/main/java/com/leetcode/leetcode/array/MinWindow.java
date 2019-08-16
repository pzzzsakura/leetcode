package com.leetcode.leetcode.array;

import java.util.Map;
import java.util.HashMap;

/**给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。

    示例：

    输入: S = "ADOBECODEBANC", T = "ABC"
    输出: "BANC"
    说明：

    如果 S 中不存这样的子串，则返回空字符串 ""。
    如果 S 中存在这样的子串，我们保证它是唯一的答案。

    链接：https://leetcode-cn.com/problems/minimum-window-substring*/

public class MinWindow {

  public String minWindow(String s, String t) {
    if (s.length() == 0 || t.length() == 0) {
      return "";
    }
    //t中所有唯一字符计数
    Map<Character, Integer> dictT = new HashMap<Character, Integer>();
    for (int i = 0; i < t.length(); i++) {
      int count = dictT.getOrDefault(t.charAt(i), 0);
      dictT.put(t.charAt(i), count + 1);
    }
    // t中的唯一字符数
    int required = dictT.size();
    // 左 右 指针
    int l = 0, r = 0;
    /*
    formed 用于跟踪当前窗口中以其所需频率存在多少个唯一字符。
    例如 如果t是“AABC”那么窗口必须有两个A，一个B和一个C.
    因此，当满足所有这些条件时，formed = 3。
    */
    int formed = 0;
    // 字典，用于保存当前窗口中所有唯一字符的计数。
    Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();
    // (窗口长度, 左指针, 右指针)
    int[] ans = {-1, 0, 0};
    while (r < s.length()) {
      // 窗口开始滑动
      char c = s.charAt(r);
      int count = windowCounts.getOrDefault(c, 0);
      windowCounts.put(c, count + 1);
      //如果添加的当前字符的频率等于t中的所需计数，则将formed增加1。
      if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
        formed++;
      }
      // 尝试并收缩窗口，直到它不再是“理想的”。
      while (l <= r && formed == required) {
        c = s.charAt(l);
        // 更新满足条件的最小的窗口和 l r 指针
        if (ans[0] == -1 || r - l + 1 < ans[0]) {
          ans[0] = r - l + 1;
          ans[1] = l;
          ans[2] = r;
        }
        //Left”指针指向的位置处的字符不再是窗口的一部分。
        windowCounts.put(c, windowCounts.get(c) - 1);
        if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
          formed--;
        }
        // 将左指针向前移动，这将有助于查找新窗口。
        l++;
      }
      // 继续扩大窗口
      r++;
    }
    return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
  }


}
