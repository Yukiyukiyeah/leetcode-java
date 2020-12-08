class Solution {
  public void rotate(int[] nums, int k) {
      int len = nums.length;
      k = k % len;
      int count = 0;
      for (int start = 0; count < len; start++) {
          int curr = start;
          int prev = nums[start];
          int temp;
          while (true) {
              curr = (curr + k) % len;
              temp = nums[curr];
              nums[curr] = prev;
              prev = temp;   
              count ++;  
              if (curr == start) break;           
          } 
      }
  }
}