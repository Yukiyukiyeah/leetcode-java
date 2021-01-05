/*
 * @Author: your name
 * @Date: 2021-01-05 14:17:41
 * @LastEditTime: 2021-01-05 14:17:57
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/17.letter-combinations-of-a-phone-number.java
 */
class Solution {
  Map<Character, String> map = new HashMap<>(){{
          put('2', "abc");
          put('3', "def");
          put('4', "ghi");
          put('5', "jkl");
          put('6', "mno");
          put('7', "pqrs");
          put('8', "tuv");
          put('9', "wxyz");
  }};
  List<String> res = new ArrayList<>();
  public List<String> letterCombinations(String digits) {
      if (digits.length() == 0) return res;
      backtrack(digits, 0, new StringBuilder());
      return res;
  }

  private void backtrack(String digits, int start, StringBuilder str) {
      if (start == digits.length()) {
          res.add(new String(str.toString()));
          return;
      }
      String curr = map.get(digits.charAt(start));
      for (int i = 0; i < curr.length(); i++) {
          str.append(curr.charAt(i));
          backtrack(digits, start + 1, str);
          str.delete(str.length() - 1, str.length());
      }
  }
}