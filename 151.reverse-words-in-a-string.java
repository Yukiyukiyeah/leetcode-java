/*
 * @Author: your name
 * @Date: 2020-12-28 21:38:04
 * @LastEditTime: 2020-12-28 21:38:18
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/151.reverse-words-in-a-string.java
 */
class Solution {
  public String reverseWords(String s) {
      s = s.trim();
      List<String> wordList = Arrays.asList(s.split("\\s+"));
      Collections.reverse(wordList);
      return String.join(" ", wordList);
  }
}