class Solution {
  public String replaceSpace(String s) {
      char[] s2 = s.toCharArray();
      StringBuilder res = new StringBuilder("");
      for (char c: s2) {
          if (c == ' ') res.append("%20");
          else res.append(c);
      }
      return res.toString();
  }
}
