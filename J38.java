
/*
 * @Author: your name
 * @Date: 2021-01-13 10:51:48
 * @LastEditTime: 2021-01-13 10:51:49
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/J38.java
 */
class Solution {
  List<String> res = new ArrayList<>();
  StringBuilder path = new StringBuilder();
  
  public String[] permutation(String s) {
      int len = s.length();
      if (len == 0) return new String[0];
      boolean[] visited = new boolean[len];
      char[] c = s.toCharArray();
      Arrays.sort(c);
      dfs(c, 0, visited);
      return res.toArray(new String[0]);
  }

  private void dfs(char[] c, int depth, boolean[] visited) {
      if (depth == c.length) {
          res.add(path.toString());
          return;
      }
      for (int i = 0; i < c.length; i++) {
          if (!visited[i]) {
              if (i > 0 && c[i - 1] == c[i] && !visited[i - 1]) {
                  continue;
              }
              visited[i] = true;
              path.append(c[i]);
              dfs(c, depth + 1, visited);
              path.deleteCharAt(path.length() - 1);
              visited[i] = false;
          }
      }
  }
}