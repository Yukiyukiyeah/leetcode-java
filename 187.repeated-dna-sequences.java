class Solution {
  public List<String> findRepeatedDnaSequences(String s) {
      int L = 10;
      int len = s.length();
      HashSet<String> seen = new HashSet<>();
      HashSet<String> res = new HashSet<>();
      for (int i = 0; i <= len - L; i++) {
          String curr = s.substring(i, i + L);
          if (seen.contains(curr)) {
              res.add(curr);
              continue;
          }
          seen.add(curr);
      }
      return new ArrayList(res);
  }
}