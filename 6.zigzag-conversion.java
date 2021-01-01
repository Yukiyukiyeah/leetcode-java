class Solution {
  public String convert(String s, int numRows) {
      if (numRows == 1) return s;
      char[] sArr = s.toCharArray();
      StringBuilder res = new StringBuilder();
      int n = (numRows - 1) * 2;
      for (int i = 0; i < numRows; i++) {
          int j = i;
          if (j == 0 || j == numRows - 1) {
              while (j < sArr.length) {
                  res.append(sArr[j]);
                  j += n;
              }
          } else {
              int k = n - i;
              while (j < sArr.length) {
                  res.append(sArr[j]);
                  j += n;
                  if (k < sArr.length) {
                      res.append(sArr[k]);
                      k += n;
                  }
              }
          }
      }
      return res.toString();
  }
}