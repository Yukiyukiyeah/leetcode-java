class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
      int len = gas.length;
      for (int i = 0; i < len; i++) {
          int visited = 0;
          int unit = gas[i] - cost[i];
          int pos = (i + 1) % len;
          while (unit >= 0 && pos % len != i) {
              unit = unit + gas[pos] - cost[pos];
              if (unit < 0) break;
              pos = (pos + 1) % len;
          }
          if (unit >= 0 && pos == i) return i;
      }
      return -1;
  }
}
