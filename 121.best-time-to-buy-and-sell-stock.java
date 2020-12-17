class Solution {
  public int maxProfit(int[] prices) {
      int profit = 0, cost = Integer.MAX_VALUE;
      for (int p: prices) {
          cost = Math.min(p, cost);
          profit = Math.max(profit, p - cost);
      }
      return profit;
  }
}
