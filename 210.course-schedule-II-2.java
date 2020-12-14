class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
      Map<Integer, List<Integer>> edges = new HashMap<>();
      int[] indeg = new int[numCourses];
      for (int[] info: prerequisites) {
          int dest = info[0];
          int src = info[1];
          List<Integer> lst = edges.getOrDefault(src, new ArrayList<Integer>());
          lst.add(dest);
          edges.put(src, lst);
          indeg[dest]++;
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
          if (edges.containsKey(cur)) {
              for (int v: edges.get(cur)) {
                  indeg[v]--;
                  if (indeg[v] == 0) {
                      q.offer(v);
                  }
              }
          }
      }
      if (visited == numCourses) {
          return res;
      }
      return new int[0];
  }
}
