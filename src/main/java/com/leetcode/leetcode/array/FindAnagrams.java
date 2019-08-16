package com.leetcode.leetcode.array;

import java.util.ArrayList;
import java.util.List;
//找到字符串中所有字母异位词
 /**给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

     字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

     说明：

     字母异位词指字母相同，但排列不同的字符串。
     不考虑答案输出的顺序。
     示例 1:

     输入:
     s: "cbaebabacd" p: "abc"

     输出:
     [0, 6]

     解释:
     起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
     起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
      示例 2:

     输入:
     s: "abab" p: "ab"

     输出:
     [0, 1, 2]

     解释:
     起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
     起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
     起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。

     链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string*/

public class FindAnagrams {

  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();
    if (s.length() < p.length())
      return result;
    int i = 0;
    while (i <= (s.length() - p.length())) {
      if (isvalid(s.substring(i, i + p.length()), p)) {
        result.add(i);
      }
      i++;
    }
    return result;
  }


  private boolean isvalid(String temp, String p) {
    if (temp.length() != p.length()) {
      return false;
    }
    int[] array = new int[26];
    for (char a : temp.toCharArray()) {
      array[a - 'a']++;
    }
    for (char b : p.toCharArray()) {
      array[b - 'a']--;
    }
    for (int num : array) {
      if (num != 0) {
        return false;
      }
    }
    return true;
  }


  public List<Integer> findAnagrams2(String s, String p) {
    List<Integer> list = new ArrayList<>();
    int[] record = new int[128];
    for (char c : p.toCharArray()) {
      record[c]++;
    }
    char[] arr = s.toCharArray();
    int l = 0, r = 0;
    while (r < s.length()) {
     if (record[arr[r]] > 0) {
       record[arr[r]]--;
       r++;
       if ((r - l) == p.length()) {
         list.add(l);
       }
     } else{
       record[arr[l]]++;
       l++;
     }
    }
    return list;
  }




  public static void main(String[] args) {
//   List<Integer> ss = new FindAnagrams().findAnagrams2("cbaebabacd" ,"ab");
//    for(Integer s :  ss){
//      System.out.println(s);
//    }
  }
}
