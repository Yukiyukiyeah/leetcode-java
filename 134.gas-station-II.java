class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
      int spare = 0;
      int min = Integer.MAX_VALUE;
      int start = 0;
      for (int i = 0; i < gas.length; i++) {
          spare += gas[i] - cost[i];
          if (spare < min){
              min = spare;
              start = (i + 1) % gas.length;
          }
      }
      return spare >= 0 ? start : -1;
  }
}