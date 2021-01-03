/*
 * @Author: your name
 * @Date: 2021-01-03 14:41:46
 * @LastEditTime: 2021-01-03 14:49:42
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/6.zigzag-conversion-2.java
 */
class Solution {
  public String convert(String s, int numRows) {
      if (numRows == 1 || numRows > s.length()) return s;
      char[] sArr = s.toCharArray();
      List<StringBuilder> res = new ArrayList<>();
      for (int i = 0; i < numRows; i++) {
        res.add(new StringBuilder());
      }
      int curRow = 0;
      int goingDown = -1;
      for (char c: sArr) {
        res.get(curRow).append(c);
        if (curRow == 0 || curRow == numRows - 1) {
          goingDown = -goingDown;
        }
        curRow += goingDown;
      }
      StringBuilder ans = new StringBuilder();
      for (StringBuilder string: res) {
        ans.append(string);
      }
      return ans.toString();
  }
}