/*
 * @Author: your name
 * @Date: 2020-12-06 15:05:59
 * @LastEditTime: 2020-12-06 15:06:00
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/89.gray-code.java
 */
class Solution {
  public List<Integer> grayCode(int n) {
      ArrayList<Integer> ans = new ArrayList();
      for (int i = 0; i < 1 << n; i++) {
          ans.add(i ^ (i >> 1));
      }
      return ans;
  }
}