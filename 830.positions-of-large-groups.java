/*
 * @Author: your name
 * @Date: 2021-01-05 15:16:29
 * @LastEditTime: 2021-01-05 15:18:51
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/830.positions-of-large-groups.java
 */
class Solution {
  public List<List<Integer>> largeGroupPositions(String s) {
      List<List<Integer>> res = new ArrayList<>();
      char[] sArr = s.toCharArray();
      int count = 1;
      int start = 0;
      for (int i = 0; i < sArr.length; i++) {
          if (i == sArr.length - 1 || sArr[i] != sArr[i + 1]) {
              if (count >= 3) {
                  res.add(Arrays.asList(start, i));
              }
              count = 1;
              start = i + 1;
          } else {
              count++;
          }
      }
      return res;
  }
}
