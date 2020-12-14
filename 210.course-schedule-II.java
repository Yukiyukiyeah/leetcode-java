/*
 * @Author: your name
 * @Date: 2020-12-14 16:09:49
 * @LastEditTime: 2020-12-14 16:10:04
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/210.course-schedule-II.java
 */
class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
      List<List<Integer>> edges = new ArrayList<List<Integer>>();
      for (int i = 0; i < numCourses; i++) {
          edges.add(new ArrayList<Integer>());
      }
      int[] indeg = new int[numCourses];
      for (int[] info: prerequisites) {
          edges.get(info[1]).add(info[0]);
          indeg[info[0]]++;
      }
      int[] res = new int[numCourses];
      Queue<Integer> q = new LinkedList<Integer>();
      for (int i = 0; i < numCourses; i++) {
          if (indeg[i] == 0) {
              q.offer(i);
          }
      }
      int visited = 0;
      while (!q.isEmpty()) {
          int cur = q.poll();
          res[visited] = cur;
          visited++;
          for (int v: edges.get(cur)) {
              indeg[v]--;
              if (indeg[v] == 0) {
                  q.offer(v);
              }
          }
      }
      if (visited == numCourses) {
          return res;
      }
      return new int[0];
  }
}