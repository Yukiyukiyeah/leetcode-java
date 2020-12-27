class Solution {
  List<List<Integer>> res = new ArrayList<List<Integer>>();
  List<Integer> path = new ArrayList<Integer>();
  public List<List<Integer>> combinationSum3(int k, int n) {
      int end = n > 9 ? 9 : n;
      dfs(k, n, 1, end, path);
      return res;
  }
  private void dfs(int k, int n, int start, int end, List<Integer> path) {
      if (k < 0 || n < 0) return;
      if (k == 0 && n == 0) {
          res.add(new ArrayList(path));
          return;
      }
      for (int i = start; i <= end; i++) {
          path.add(i);
          dfs(k - 1, n - i, i + 1, end, path);
          path.remove(path.size() - 1);
      }
  }
}
