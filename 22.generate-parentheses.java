/*
 * @Author: your name
 * @Date: 2021-01-06 21:55:17
 * @LastEditTime: 2021-01-06 21:55:18
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/22.generate-parentheses.java
 */
class Solution {
  List<String> res = new ArrayList<>();
  public List<String> generateParenthesis(int n) {
      generate(n, 0, 0, new StringBuilder());
      return res;
  }
  private void generate(int n, int left, int right, StringBuilder str) {
      if (left == n && right == n) {
          res.add(str.toString());
          return;
      }
      if (left < n) {
          str.append('(');
          generate(n, left + 1, right, str);
          str.deleteCharAt(str.length() - 1);
      }
      if (right < left && right < n) {
          str.append(')');
          generate(n, left, right + 1, str);
          str.deleteCharAt(str.length() - 1);
      }
  }
}
