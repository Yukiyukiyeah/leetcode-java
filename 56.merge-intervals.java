/*
 * @Author: your name
 * @Date: 2020-12-31 21:24:25
 * @LastEditTime: 2020-12-31 21:24:36
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/56.merge-intervals.java
 */
class Solution {
  public int[][] merge(int[][] intervals) {
      if (intervals.length == 0) return new int[0][2];
      Arrays.sort(intervals, new Comparator<int[]>() {
          public int compare(int[] interval1, int[] interval2) {
              return interval1[0] - interval2[0];
          }
      });
      List<int []> merged = new ArrayList<int []>();
      merged.add(intervals[0]);
      for (int i = 1; i < intervals.length; i++) {
          if (intervals[i][0] > merged.get(merged.size() - 1)[1]) {
              merged.add(intervals[i]);
          } else {
              if (intervals[i][1] > merged.get(merged.size() - 1)[1]) {
                  merged.get(merged.size() - 1)[1] = intervals[i][1];
              }
          }
      }
      return merged.toArray(new int[merged.size()][]);
  }
}