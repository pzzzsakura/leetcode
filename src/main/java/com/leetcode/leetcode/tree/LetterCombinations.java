package com.leetcode.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;

/**
 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

 输入："23"
 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinations {
  private String letterMap[] = {
      "",     //0
      "",     //1
      "abc",  //2
      "def",  //3
      "ghi",  //4
      "jkl",  //5
      "mno",  //6
      "pqrs", //7
      "tuv",  //8
      "wxyz"  //9
  };

  public List<String> letterCombinations(String digits) {
    List<String> res = new ArrayList<>();
    if(StringUtils.isEmpty(digits)){
      return res;
    }
    findCombination(digits,0,"" ,res);
    return res;
  }

  private void findCombination(String digits, int index, String s,List<String> res){
    if(index==digits.length()){
      res.add(s);
      return;
    }
    char character = digits.charAt(index);
    String letter = letterMap[character-'0'];
    for(int i = 0;i<letter.length();i++){
      findCombination(digits,index+1,s+String.valueOf(letter.charAt(i)),res);
    }
  }
}
