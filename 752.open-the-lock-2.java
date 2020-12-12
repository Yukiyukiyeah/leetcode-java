class Solution {
  public int openLock(String[] deadends, String target) {
      Set<String> deads = new HashSet<>();
      for (String s: deadends) {
          deads.add(s);
      }
      Set<String> visited = new HashSet<>();
      Set<String> q1 = new HashSet<>();
      Set<String> q2 = new HashSet<>();
      int step = 0;
      q1.add("0000");
      q2.add(target);

      while (!q1.isEmpty() && !q2.isEmpty()) {
          if (q1.size() > q2.size()) {
              Set<String>  tempForSwap = q1;
              q1 = q2;
              q2 = tempForSwap;
          }
          int sz = q1.size();
          Set<String> temp = new HashSet<>();
          for (String cur: q1) {
              if (deads.contains(cur)) continue;
              if (q2.contains(cur)) return step;
              visited.add(cur);
              for (int j = 0; j < 4; j++) {
                  String up = plusOne(cur, j);
                  if (!visited.contains(up)) temp.add(up);
                  String down = minusOne(cur, j);
                  if (!visited.contains(down)) temp.add(down);
              }
          }
          step++;
          q1 = q2;
          q2 = temp;
      }
      return -1;
  }

  private String plusOne(String s, int j) {
      char[] ch = s.toCharArray();
      if (ch[j] == '9') ch[j] = '0';
      else ch[j] += 1;
      return new String(ch);
  }

  private String minusOne(String s, int j) {
      char[] ch = s.toCharArray();
      if (ch[j] == '0') ch[j] = '9';
      else ch[j] -= 1;
      return new String(ch);
  }
}