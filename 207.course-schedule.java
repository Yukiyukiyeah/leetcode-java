class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
      List<List<Integer>> course = new ArrayList<ArrayList<Integer>>();
      int[] indeg = new int[numCourses];
      for (int i = 0; i < numCourses; i++) {
          course.add(new ArrayList<Integer>());
      }
      for (int[] info: prerequisites) {
          course.get(info[1]).add(info[0]);
          indeg[info[0]]++;
      }
      Queue<Integer> q = new LinkedList<>();
      for (int i = 0; i < numCourses; i++) {
          if (indeg[i] == 0) {
              q.offer(i);
          }
      }
      int visited = 0;
      while (!q.isEmpty()) {
          int cur = q.poll();
          visited ++;
          for (int next: course.get(cur)) {
              indeg[next]--;
              if (indeg[next] == 0) {
                  q.offer(next);
              }
          }
      }
      return visited == numCourses;
  }
}